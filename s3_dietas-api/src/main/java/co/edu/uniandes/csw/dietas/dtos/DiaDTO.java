/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class DiaDTO implements Serializable
{
    private Boolean diaEspecial;
    private Long id;
   
    public DiaDTO ()
    {
        
    }
    public DiaDTO(DiaEntity diaEntity)
    {
        this.id = diaEntity.getId();
        this.diaEspecial = diaEntity.isEspecial();
    }

    /**
     * @return the diaEspecial
     */
    public boolean isDiaEspecial() {
        return diaEspecial;
    }

    /**
     * @param diaEspecial the diaEspecial to set
     */
    public void setDiaEspecial(Boolean diaEspecial) {
        this.diaEspecial = diaEspecial;
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
    
    public DiaEntity toEntity()
    {
        DiaEntity entity = new DiaEntity();
        entity.setEspecial(this.isDiaEspecial());
        entity.setId(this.getId());
        return entity;
    }
    
    
    
}
