/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class DiaDetailDTO extends DiaDTO implements Serializable
{
    
    private List <ComidaDTO> comidas;
 
    
    public DiaDetailDTO (){
        super();
    }
    
    public DiaDetailDTO (DiaEntity entity){
        super(entity);
        if(entity!=null){
            if(entity.getComidas() !=null){
                comidas= new ArrayList<>();
                for(ComidaEntity comidas: entity. getComidas()){
                    //comidas.add(new ComidaDTO(comida));
                }
            }
          }
    }
    public DiaEntity toEntity(){
        DiaEntity entity=super.toEntity();
        if(comidas!=null){
            List<ComidaEntity> comidaEntity= new ArrayList<>();
            for(ComidaDTO comida: comidas)
            {
               comidaEntity.add(comida.toEntity()); 
            }
            entity.setComidas(comidaEntity);
        }
        return entity;
    }
    
}
