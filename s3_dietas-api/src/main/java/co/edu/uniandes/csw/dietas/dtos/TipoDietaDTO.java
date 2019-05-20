/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;

/**
 *
 * @author Juan Antonio Restrepo
 */
public class TipoDietaDTO {
    
    private Long id;
    private String nombre;
     private String descripcion;
     private String tipo;
    /**
     * Constructor de la clase vacío
     */
    public TipoDietaDTO()
    {
        
    }
    /**
     * Constructor de la clase no vacío
     * @param tipo tipo de entidad que se va a crear
     */
    public TipoDietaDTO(TipoDietaEntity tipo){
        if(tipo!=null)
        {
        this.id = tipo.getId();
        this.nombre = tipo.getNombre();
        this.tipo = tipo.getTipo();
        this.descripcion = tipo.getDescripcion();
        }
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TipoDietaEntity toEntity()
    {
        TipoDietaEntity entity = new TipoDietaEntity();
        entity.setDescripcion(this.getDescripcion());
        entity.setNombre(this.getNombre());
        entity.setTipo(this.getDescripcion());
        return entity;
        
    }
    
}
