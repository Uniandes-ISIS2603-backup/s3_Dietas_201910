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
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class DietaDePersonaLogic {
     private static final Logger LOGGER = Logger.getLogger(DietaDePersonaLogic.class.getName());

    @Inject
    private PersonaPersistence personaPersistence;

    @Inject
    private DietaPersistence dietaPersistence;
    
    /**
     * Asocia una persona existente a un hall
     *
     * @param hallId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Suspension
     * @return Instancia de PersonaEntity que fue asociada a hall
     */
    public DietaEntity addDietas(Long personaId, Long dietaId) {
        DietaEntity dietaEntity = dietaPersistence.findByID(dietaId);
        PersonaEntity personaEntity = personaPersistence.findById(personaId);        
        personaEntity.addDieta(dietaEntity);
        dietaEntity.setPersonaDieta(personaEntity);
        dietaPersistence.create(dietaEntity);
        personaPersistence.update(personaEntity);
        return dietaPersistence.findByID(dietaId);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de Hall
     *
     * @param hallsId Identificador de la instancia de Dieta
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de Hall
     */
    public List<DietaEntity> getDietas(Long dietaId) {
        return personaPersistence.findById(dietaId).getDietas();
    }
}
