/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juan Antonio Restrepo
 */
public class SemanaDTO implements Serializable{
    private Long id;
    private Integer costo;
    private String lugarEntrega;
    private Date horaEntrega;
    
    /**
     * Método constructor de la clase
     */
    public SemanaDTO()
    {
        
    }
    public SemanaDTO (SemanaEntity semanaEntity)
     {
         this.id = semanaEntity.getId();
         this.costo = semanaEntity.getCosto();
         this.horaEntrega= semanaEntity.getHoraEntrega();
         this.lugarEntrega = semanaEntity.getLugarEntrega();
     }

    /**
     * @return the costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    /**
     * @return the lugarEntrega
     */
    public String getLugarEntrega() {
        return lugarEntrega;
    }

    /**
     * @param lugarEntrega the lugarEntrega to set
     */
    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    /**
     * @return the horaentrega
     */
    public Date getHoraEntrega() {
        return horaEntrega;
    }

    /**
     * @param horaentrega the horaentrega to set
     */
    public void setHoraEntrega(Date horaentrega) {
        this.horaEntrega = horaentrega;
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
    
     public SemanaEntity toEntity()
    {
        SemanaEntity entity = new SemanaEntity();
        entity.setCosto(this.getCosto());
        entity.setLugarEntrega(this.getLugarEntrega());
        entity.setId(this.getId());
        entity.setHoraEntrega(this.getHoraEntrega());
        return entity;
    }
     
    
}
