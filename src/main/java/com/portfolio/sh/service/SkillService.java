/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.Repository.EducacionRepository;
import com.portfolio.sh.Repository.ExperienciaRepository;
import com.portfolio.sh.Repository.PersonaRepository;
import com.portfolio.sh.Repository.SkillRepository;
import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Experiencia;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private SkillRepository SkillRepository;

    @Override
    public List<Skill> getSkill() {
    List<Skill> listaSkill= SkillRepository.findAll();
    return listaSkill;
    }

       @Override
    public void saveSkill(Skill skill) {
    SkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
    SkillRepository.deleteById(id);
    }

  
  @Override
    public Skill findSkill(Long id) {
    Skill skill= SkillRepository.findById(id).orElse(null);
    return skill;
    }



  
    }