/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Louis
 */
public class HallOfFameDetailDTO extends HallOfFameDTO implements Serializable {
    
    private List <PersonaDTO> personas;
 
    
    public HallOfFameDetailDTO (){
        super();
    }
    
    public HallOfFameDetailDTO (HallOfFameEntity entity){
        super(entity);
        if(entity!=null){
            if(entity.getPersonas() !=null){
                personas= new ArrayList<>();
                for(PersonaEntity personas: entity. getPersonas()){
                    //personas.add(new PersonaDTO(persona));
                }
            }
          }
    }
    public HallOfFameEntity toEntity(){
        HallOfFameEntity entity=super.toEntity();
        if(personas!=null){
            List<PersonaEntity> personaEntity= new ArrayList<>();
            for(PersonaDTO persona: personas)
            {
               //personaEntity.add(persona.toEntity()); 
            }
            entity.setPersonas(personaEntity);
        }
        return entity;
    }
    
}
