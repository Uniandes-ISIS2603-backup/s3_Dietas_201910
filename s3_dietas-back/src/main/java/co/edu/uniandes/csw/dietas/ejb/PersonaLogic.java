/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Espitia   
 */

@Stateless
public class PersonaLogic {
    
     private static final Logger LOGGER = Logger.getLogger(PersonaLogic.class.getName());
     
    @Inject
    private PersonaPersistence persistence;
    
        public PersonaEntity createPersona(PersonaEntity persona)throws BusinessLogicException{
        
        if(persistence.findById(persona.getId()) != null){
            throw new BusinessLogicException("Ya existe una persona con ese ID \""+persona.getId());
        }
        persona = persistence.create(persona);
        return persona;
    }

    
    public PersonaEntity getPersona(Long personaId) {
        PersonaEntity personaEntity = persistence.findById(personaId);
        if (personaEntity == null) {
           LOGGER.log(Level.SEVERE, "La persona con el id = {0} no existe", personaId);
        }
        return personaEntity;
    }
    
    public List<PersonaEntity> getPersonas() {
        List<PersonaEntity> dietas = persistence.findAll();
        return dietas;
    }
    
    public PersonaEntity updatePersona(Long dietaId, PersonaEntity personaEntity) {
        PersonaEntity newPersonaEntity = persistence.update(personaEntity);
        return newPersonaEntity;
    }
    
    public void deletePersona(Long dietasId) throws BusinessLogicException {
//        List<SemanaEntity> semanas = getDieta(dietasId).getSemanas();
//        if (semanas != null && !semanas.isEmpty()) {
//            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene semanas asociadas");
//        }
//        List<SuspensionEntity> suspensiones = getDieta(dietasId).getSuspension();
//        if (suspensiones != null && !suspensiones.isEmpty()) {
//            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene suspensiones asociadas");
//        }
//        List<TipoDietaEntity> tiposDieta = getDieta(dietasId).gettDietas();
//        if (tiposDieta != null && !tiposDieta.isEmpty()) {
//            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene tipos de dieta asociadas");
//        }
//        persistence.delete(dietasId);
    }



}



