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
    
    public List<DiaDTO> getDias()
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
        if(getDias()!=null){
            List<DiaEntity> diaEntity= new ArrayList<>();
            for(DiaDTO dia: getDias())
            {
               diaEntity.add(dia.toEntity()); 
            }
            entity.setDias(diaEntity);
        }
        return entity;
    }
    
    public void agregarDias(List<DiaDTO> dias)
    {
        for (int i = 0; i < 10; i++) 
        {
            if(!this.dias.contains(dias.get(i)))
            {
                dias.add(dias.get(i));
            }
            else{
                System.out.print("La persona ya existe");
            }
            
        }
    }
    
    public void eliminarDia(DiaDTO dia)
    {
        if(!this.dias.contains(dia)){
            this.getDias().remove(dia);
        }
        else{
            System.out.print("La persona no existe");
        }
    }
    
}
