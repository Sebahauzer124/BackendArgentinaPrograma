
package com.portfolio.sh.Controller;



import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Experiencia;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.service.EducacionService;
import com.portfolio.sh.service.ExperienciaService;
import com.portfolio.sh.service.IExperienciaService;
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
public class ExperienciaController {
    @Autowired
    private IExperienciaService interExperiencia;
    
    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia(){
        return interExperiencia.getExperiencia();
   }    
@GetMapping("/experiencia/traer/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
       Experiencia experiencia= interExperiencia.findExperiencia(id);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/crear")
    public ResponseEntity<Experiencia> createExperiencia (@RequestBody Experiencia experiencia){
    interExperiencia.saveExperiencia(experiencia);
    return new ResponseEntity<>(experiencia,HttpStatus.CREATED);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/borrar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable ("id") Long id){
    interExperiencia.deleteExperiencia(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/experiencia/editar/{id}")
      public ResponseEntity<?> editarExperiencia(@PathVariable ("id") Long id,
                                    @RequestBody Experiencia experiencia){
    Experiencia exp=interExperiencia.findExperiencia(id);
    
   exp.setTituloExp(experiencia.getTituloExp());
   exp.setFechaExp(experiencia.getFechaExp());
   exp.setImagenExp(experiencia.getImagenExp());
   exp.setDescExp(experiencia.getDescExp());

   
   interExperiencia.saveExperiencia(exp);
   return new ResponseEntity(exp,HttpStatus.OK);
                               
    }
}