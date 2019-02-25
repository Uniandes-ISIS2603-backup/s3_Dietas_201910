/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandra
 */
public class DietaDetailDTO extends DietaDTO implements Serializable{
    private List<SemanaDTO> semanas;
    private List<SuspensionDTO> suspensiones;
    
    public DietaDetailDTO (){
        super();
    }
    
    public DietaDetailDTO(DietaEntity entity){
        super(entity);
        if(entity != null)
        {
            if(entity.getSemanas() != null){
                semanas = new ArrayList<>();
                for (SemanaEntity semana : entity.getSemanas()) {
//                semanas.add(new SemanaDTO(semana));
                }
            }
            if(entity.getSuspension() != null){
                suspensiones = new ArrayList<>();
                for (SuspensionEntity suspension : entity.getSuspension()) {
//                    suspensiones.add(new SuspensionDTO(suspension))
                }
            }
            
            
        }
    }
    
    public DietaEntity toEntity(){
        DietaEntity entity = super.toEntity();
        if(semanas != null){
            List<SemanaEntity> semanaEntity = new ArrayList<>();
            for (SemanaDTO semana : semanas) {
//                semanaEntity.add(semana.toEntity());
            }
            entity.setSemanas(semanaEntity);
        }
        if(suspensiones != null){
            List<SuspensionEntity> suspensionEntity = new ArrayList<>();
            for (SuspensionDTO suspension : suspensiones) {
//                suspensionEntity.add(suspension.toEntity());
            }
            entity.setSuspension(suspensionEntity);
        }
        return entity;
    }
}
