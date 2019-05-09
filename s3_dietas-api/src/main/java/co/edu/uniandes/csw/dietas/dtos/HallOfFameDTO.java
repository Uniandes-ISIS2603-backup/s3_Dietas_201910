/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import java.io.Serializable;

/**
 *
 * @author Louis
 */
public class HallOfFameDTO implements Serializable {
    private Long id;
    private String mensaje;

    public HallOfFameDTO(){
        
    }
    
     public HallOfFameDTO (HallOfFameEntity entity){
         if(entity!=null){
        this.id=entity.getId();
        this.mensaje=entity.getMensaje();
         }
    }
    
    public HallOfFameEntity toEntity(){
        HallOfFameEntity entity = new HallOfFameEntity();
        entity.setId(this.getId());
        entity.setMensaje(this.getMensaje());
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
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
