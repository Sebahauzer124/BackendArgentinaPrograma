/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.portfolio.sh.Repository.PersonaRepository;


@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository persoRepository;

    @Override
    public List<Persona> getPersonas() {
    List<Persona> listaPersonas= persoRepository.findAll();
    return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
    persoRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
    persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
    Persona perso= persoRepository.findById(id).orElse(null);
    return perso;
    }
    
     

  
    }