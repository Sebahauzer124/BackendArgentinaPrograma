
package com.portfolio.sh.Controller;



import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.service.EducacionService;
import com.portfolio.sh.service.IEducacionService;
import com.portfolio.sh.service.IPersonaService;
import com.portfolio.sh.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://argentinaprograma22.web.app")
@RestController
public class EducacionController {
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
   }    
@GetMapping("/educacion/traer/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id) {
       Educacion educacion= interEducacion.findEducacion(id);
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")  
    @PostMapping("/educacion/crear")
    public ResponseEntity<Educacion> createEducacion (@RequestBody Educacion educacion){
    interEducacion.saveEducacion(educacion);
    return new ResponseEntity<>(educacion,HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/borrar/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable ("id") Long id){
    interEducacion.deleteEducacion(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
    
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/educacion/editar/{id}")
      public ResponseEntity<?> editarEducacion(@PathVariable ("id") Long id,
                                    @RequestBody Educacion educacion){
    Educacion educ=interEducacion.findEducacion(id);
    
   educ.setTituloEdu(educacion.getTituloEdu());
   educ.setFechaEdu(educacion.getFechaEdu());
   educ.setImagenEdu(educacion.getImagenEdu());

   
   interEducacion.saveEducacion(educ);
   return new ResponseEntity(educ,HttpStatus.OK);
                               
    }
}