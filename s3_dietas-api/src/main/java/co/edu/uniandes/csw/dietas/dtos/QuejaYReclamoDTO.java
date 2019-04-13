/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class QuejaYReclamoDTO implements Serializable{
    
    private Long id;
    private String especificacion;
    private PersonaDTO persona;

    
    public QuejaYReclamoDTO(){
        
    }
    
    public QuejaYReclamoDTO(QuejaYReclamoEntity entity){
        setId(entity.getId());
        setEspecificacion(entity.getEspecificacion());
       
    }
    
    public QuejaYReclamoEntity toEntity(){
        QuejaYReclamoEntity entity = new QuejaYReclamoEntity();
        entity.setId(this.getId());
        entity.setEspecificacion(this.getEspecificacion());
       
        return entity;
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
     * @return the especificacion
     */
    public String getEspecificacion() {
        return especificacion;
    }

    /**
     * @param especificacion the especificacion to set
     */
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
    /**
     * @return the persona
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
}
