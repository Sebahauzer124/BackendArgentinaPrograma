
package com.portfolio.sh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    
    
   private String tituloSkill;
    
    
   private String imagenSkill;
    
     
    private double porcentaje;
   
    @ManyToOne() 
    private Persona persona;   

    public Skill() {
    }

    public Skill(Long id, String tituloSkill, String imagenSkill, double porcentaje) {
        this.id = id;
        this.tituloSkill = tituloSkill;
        this.imagenSkill = imagenSkill;
        this.porcentaje = porcentaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloSkill() {
        return tituloSkill;
    }

    public void setTituloSkill(String tituloSkill) {
        this.tituloSkill = tituloSkill;
    }

    public String getImagenSkill() {
        return imagenSkill;
    }

    public void setImagenSkill(String imagenSkill) {
        this.imagenSkill = imagenSkill;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

  

    
    
    

  

 
   
}