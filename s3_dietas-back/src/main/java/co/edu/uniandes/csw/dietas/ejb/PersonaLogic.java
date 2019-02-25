/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Espitia   
 */

@Stateless
public class PersonaLogic {
    
    
    @Inject
    private PersonaPersistence persistence;
    
    public PersonaEntity createPersona(PersonaEntity persona)throws BusinessLogicException{
        
        if(persistence.findById(persona.getId()) != null){
            throw new BusinessLogicException("Ya existe una persona con ese ID \""+persona.getId()+"\"");
        }
        persona = persistence.create(persona);
        return persona;
    }
}
