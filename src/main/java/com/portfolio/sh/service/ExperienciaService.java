/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.Repository.EducacionRepository;
import com.portfolio.sh.Repository.ExperienciaRepository;
import com.portfolio.sh.Repository.PersonaRepository;
import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Experiencia;
import com.portfolio.sh.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
    List<Experiencia> listaExperiencia= experienciaRepository.findAll();
    return listaExperiencia;
    }

       @Override
    public void saveExperiencia(Experiencia experiencia) {
    experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
    experienciaRepository.deleteById(id);
    }

  
  @Override
    public Experiencia findExperiencia(Long id) {
    Experiencia experiencia= experienciaRepository.findById(id).orElse(null);
    return experiencia;
    }



  
    }