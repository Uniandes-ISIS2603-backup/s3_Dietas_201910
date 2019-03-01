/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import java.io.Serializable;

/**
 *
 * @author Alejandra
 */
public class PagoDTO implements Serializable{
    private Long id;
    private String modoPago;
    private PersonaDTO persona;
    
    public PagoDTO(){
        
    }
    
    public PagoDTO(PagoEntity entity){
        setId(entity.getId());
        setModoPago(entity.getModoPago());
    }
    
    public PagoEntity toEntity(){
        PagoEntity entity = new PagoEntity();
        entity.setId(this.getId());
        entity.setModoPago(this.getModoPago());
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
     * @return the modoPago
     */
    public String getModoPago() {
        return modoPago;
    }

    /**
     * @param modoPago the modoPago to set
     */
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
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
