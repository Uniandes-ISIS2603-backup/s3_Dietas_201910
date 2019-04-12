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
                for(PersonaEntity persona: entity.getPersonas()){
                    personas.add(new PersonaDTO(persona));
                }
            }
          }
    }
    public HallOfFameEntity toEntity(){
        HallOfFameEntity entity=super.toEntity();
        if(getPersonas()!=null){
            List<PersonaEntity> personaEntity= new ArrayList<>();
            for(PersonaDTO persona: getPersonas())
            {
               personaEntity.add(persona.toEntity()); 
            }
            entity.setPersonas(personaEntity);
        }
        return entity;
    }

    /**
     * @return the personas
     */
    public List <PersonaDTO> getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void agregarPersonas(List <PersonaDTO> personas) {
        for (int i = 0; i < 10; i++) {
            if(!this.personas.contains(personas.get(i))){
                this.getPersonas().add(personas.get(i));
            }else{
                System.out.print("la persona ya existe");
            }
        }
    }
    
      /**
     * @param personas the personas to set
     */
    public void eliminarPersona(PersonaDTO persona) {
      
            if(!this.personas.contains(persona)){
                this.getPersonas().remove(persona);
            }else{
                System.out.print("la persona ya existe");
            }
        
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(List <PersonaDTO> personas) {
        this.personas = personas;
    }
    
}
