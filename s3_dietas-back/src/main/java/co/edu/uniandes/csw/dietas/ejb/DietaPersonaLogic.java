/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.bravo
 */
@Stateless
public class DietaPersonaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(DietaPersonaLogic.class.getName());

    @Inject
    private DietaPersistence dietaPersistence;

    @Inject
    private PersonaPersistence personaPersistence;

    /**
     * Asocia una Persona existente a una Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Persona
     * @return Instancia de AuthorEntity que fue asociada a Book
     */
    public PersonaEntity addPersona(Long dietasId, Long personasId) {
        PersonaEntity personaEntity = personaPersistence.findById(personasId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.setPersonaDieta(personaEntity);
        return personaPersistence.findById(personasId);
    }

    /**
     * Obtiene la PersonaEntity asociada a una
     * instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @return Persona asociada a una dieta
     */
    public PersonaEntity getPersona(Long dietasId) {
        return dietaPersistence.findByID(dietasId).getPersonaDieta();
    }
    
}
