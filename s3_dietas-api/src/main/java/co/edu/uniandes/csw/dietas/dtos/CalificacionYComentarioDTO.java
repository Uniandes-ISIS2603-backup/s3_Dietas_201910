/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import java.io.Serializable;

/**
 *
 * @author Andrea Montoya Serje.
 */
public class CalificacionYComentarioDTO implements Serializable
{
    private Long id;
    private Integer calificacion;
    private String comentario;
    
    
      
    public CalificacionYComentarioDTO(){
        
    }
    
    
    public CalificacionYComentarioDTO(CalificacionYComentarioEntity entity){
        
        this.id = entity.getId();
        this.comentario = entity.getComentario();
        this.calificacion = entity.getCalificacion();
        
    }
    
    
   public CalificacionYComentarioEntity toEntity( ){
       CalificacionYComentarioEntity entity = new CalificacionYComentarioEntity();
       entity.setComentario(this.comentario);
       entity.setCalificacion(this.calificacion);
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
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the comentarios
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentario(String comentarios) {
        this.comentario = comentarios;
    }
    
    
    
    
}
