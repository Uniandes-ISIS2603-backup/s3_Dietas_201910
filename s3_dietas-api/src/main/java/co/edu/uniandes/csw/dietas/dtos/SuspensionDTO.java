 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import java.io.Serializable;

/**
 *
 * 
 * @author Andrea Montoya Serje.
 */
public class SuspensionDTO implements Serializable
{
   private Long id;
   private Boolean vigente;
   private String comentarios;
   private Integer numDias;

   
   
    public SuspensionDTO(){
        
    }
    
    
    public SuspensionDTO(SuspensionEntity entity){
        
        this.id = entity.getId();
        this.comentarios = entity.getComentarios();
        this.vigente = entity.isVigente();
        this.numDias = entity.getNumDias();
        
    }
    
    
   public SuspensionEntity toEntity( ){
       SuspensionEntity entity = new SuspensionEntity();
       entity.setComentarios(this.comentarios);
       entity.setId(this.id);
       entity.setNumDias(this.numDias);
       entity.setVigente(this.vigente);
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
     * @return the vigente
     */
    public boolean isVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the numDias
     */
    public int getNumDias() {
        return numDias;
    }

    /**
     * @param numDias the numDias to set
     */
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }
   
   
   
}
