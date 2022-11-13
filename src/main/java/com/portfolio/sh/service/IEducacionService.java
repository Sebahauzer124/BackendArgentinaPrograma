/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IEducacionService {
    public List<Educacion> getEducacion();
    public void saveEducacion(Educacion educacion);
    public void deleteEducacion(Long id);
    public Educacion findEducacion (Long id);
    
}
