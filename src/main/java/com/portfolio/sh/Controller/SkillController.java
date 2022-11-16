
package com.portfolio.sh.Controller;



import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.model.Skill;
import com.portfolio.sh.service.EducacionService;
import com.portfolio.sh.service.IEducacionService;
import com.portfolio.sh.service.IPersonaService;
import com.portfolio.sh.service.ISkillService;
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
public class SkillController {
    @Autowired
    private ISkillService interSkill;
    
    @GetMapping("/skill/traer")
    public List<Skill> getSkill(){
        return interSkill.getSkill();
   }    
@GetMapping("/skill/traer/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id) {
       Skill skill= interSkill.findSkill(id);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill/crear")
    public ResponseEntity<Skill> createSkill (@RequestBody Skill skill){
    interSkill.saveSkill(skill);
    return new ResponseEntity<>(skill,HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/borrar/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable ("id") Long id){
    interSkill.deleteSkill(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/skill/editar/{id}")
      public ResponseEntity<?> editarSkill(@PathVariable ("id") Long id,
                                    @RequestBody Skill skill){
    Skill ski=interSkill.findSkill(id);
    
   ski.setTituloSkill(skill.getTituloSkill());
   ski.setImagenSkill(skill.getImagenSkill());
   ski.setPorcentaje(skill.getPorcentaje());

   
   interSkill.saveSkill(ski);
   return new ResponseEntity(ski,HttpStatus.OK);
                               
    }
}