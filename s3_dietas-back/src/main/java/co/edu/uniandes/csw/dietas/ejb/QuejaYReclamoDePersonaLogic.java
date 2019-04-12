/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import co.edu.uniandes.csw.dietas.persistence.QuejaYReclamoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class QuejaYReclamoDePersonaLogic {
    private static final Logger LOGGER = Logger.getLogger(PagosDePersonaLogic.class.getName());

    @Inject
    private PersonaPersistence personaPersistence;

    @Inject
    private QuejaYReclamoPersistence quejaPersistence;
    
    /**
     * Asocia una persona existente a un hall
     *
     * @param hallId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Suspension
     * @return Instancia de PersonaEntity que fue asociada a hall
     */
    public QuejaYReclamoEntity addQueja(Long personaId, Long quejaId) {
        QuejaYReclamoEntity quejaEntity = quejaPersistence.findById(quejaId);
        PersonaEntity personaEntity = personaPersistence.find(personaId);
        
        personaEntity.addQuejaYReclamo(quejaEntity);
        
        
        return quejaPersistence.findById(quejaId);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de Hall
     *
     * @param hallsId Identificador de la instancia de Dieta
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de Hall
     */
    public List<QuejaYReclamoEntity> getQuejas(Long personaId) {
        return personaPersistence.find(personaId).getQuejas();
    }
}
