/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.service;

import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.model.Skill;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISkillService {
    public List<Skill> getSkill();
    public void saveSkill(Skill skill);
    public void deleteSkill(Long id);
    public Skill findSkill (Long id);
    
}
