/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import java.io.Serializable;

/**
 *
 * @author  Andrea Montoya Serje.
 */
public class CocinaDTO implements Serializable{
    private Long id;
    private String direccion;
    
    
     
    public CocinaDTO(){
        
    }
    
    
    public CocinaDTO(CocinaEntity entity){
        
        if(entity != null){
           this.id = entity.getId();
           this.direccion = entity.getDireccion();
      }
        
    }
    
    
   public CocinaEntity toEntity(){
       CocinaEntity entity = new CocinaEntity();
       entity.setDireccion(this.direccion);
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
