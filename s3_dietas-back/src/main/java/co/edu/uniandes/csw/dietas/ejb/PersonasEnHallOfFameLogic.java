/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Louis
 */

@Stateless
public class PersonasEnHallOfFameLogic {
    
     private static final Logger LOGGER = Logger.getLogger(PersonasEnHallOfFameLogic.class.getName());

    @Inject
    private HallOfFamePersistence hallOfFamePersistence;

    @Inject
    private PersonaPersistence personaPersistence;
    
    /**
     * Asocia una persona existente a un hall
     *
     * @param hallId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Suspension
     * @return Instancia de PersonaEntity que fue asociada a hall
     */
    public PersonaEntity addPersona(Long hallId, Long personasId) {
        PersonaEntity personaEntity = personaPersistence.findById(personasId);
        HallOfFameEntity hallEntity = hallOfFamePersistence.find(hallId);
        
        
        hallEntity.addPersona(personaEntity);
        
        
        return personaPersistence.findById(personasId);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de Hall
     *
     * @param hallsId Identificador de la instancia de Dieta
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de Hall
     */
    public List<PersonaEntity> getPersonas(Long hallsId) {
        return hallOfFamePersistence.find(hallsId).getPersonas();
    }
}
