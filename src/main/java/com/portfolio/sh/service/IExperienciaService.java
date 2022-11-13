/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.model.Experiencia;
import com.portfolio.sh.model.Persona;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(Long id);
    public Experiencia findExperiencia (Long id);
    
}