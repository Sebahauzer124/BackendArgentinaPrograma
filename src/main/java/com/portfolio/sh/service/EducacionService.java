/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.Repository.EducacionRepository;
import com.portfolio.sh.Repository.PersonaRepository;
import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public List<Educacion> getEducacion() {
    List<Educacion> listaEducacion= educacionRepository.findAll();
    return listaEducacion;
    }

       @Override
    public void saveEducacion(Educacion educacion) {
    educacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
    educacionRepository.deleteById(id);
    }

  
  @Override
    public Educacion findEducacion(Long id) {
    Educacion educacion= educacionRepository.findById(id).orElse(null);
    return educacion;
    }



  
    }