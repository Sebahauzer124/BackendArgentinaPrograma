package com.portfolio.sh.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre", nullable = false, updatable = true)
    private String nombre;

    @Column(name = "apellido", nullable = false, updatable = true)
    private String apellido;

    @Column(name = "img", nullable = false, updatable = true)
    private String img;
    
    @Column(name = "acerca_de", nullable = false, updatable = true)
    private String acercaDe;
    
    @Column(name = "titulo", nullable = false, updatable = true)
    private String titulo;
    
    @JsonBackReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educacionList;
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experienciaList;
    @OneToMany(mappedBy = "persona")
    private List<Skill> skillList;

    public Persona() {
    }

    public Persona(Long Id, String nombre, String apellido, String img, String acercaDe, String titulo) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
        this.titulo = titulo;
    }

 
 
}

