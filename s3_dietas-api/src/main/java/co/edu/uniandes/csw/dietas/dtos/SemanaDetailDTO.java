/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class SemanaDetailDTO extends SemanaDTO implements Serializable
{
    
    
    private List<DiaDTO> dias;
    
    public List<DiaDTO> darDias()
    {
            return dias;    
    }
    public void setDias(List<DiaDTO> pDias)
    {
        this.dias=pDias;
    }
    
    public SemanaDetailDTO()
    {
        super();
    }
    
    public SemanaDetailDTO (SemanaEntity entity)
    {
         super(entity);
        if(entity!=null){
            if(entity.getDias() !=null){
                dias= new ArrayList<>();
                for(DiaEntity dia: entity. getDias()){
                   dias.add(new DiaDTO(dia));
                }
            }
          }
    }
   
    
    public SemanaEntity toEntity(){
        SemanaEntity entity=super.toEntity();
        if(dias!=null){
            List<DiaEntity> diaEntity= new ArrayList<>();
            for(DiaDTO dia: dias)
            {
               diaEntity.add(dia.toEntity()); 
            }
            entity.setDias(diaEntity);
        }
        return entity;
    }
    
    
}
