/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.PagoPersistence;
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
public class PagosDePersonaLogic {
            
     private static final Logger LOGGER = Logger.getLogger(PagosDePersonaLogic.class.getName());

    @Inject
    private PersonaPersistence personaPersistence;

    @Inject
    private PagoPersistence pagoPersistence;
    
    /**
     * Asocia una persona existente a un hall
     *
     * @param hallId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Suspension
     * @return Instancia de PersonaEntity que fue asociada a hall
     */
    public PagoEntity addPago(Long personaId, Long pagoid) {
        PagoEntity pagoEntity = pagoPersistence.findById(pagoid);
        PersonaEntity personaEntity = personaPersistence.find(personaId);
        
        personaEntity.addPago(pagoEntity);     
        
        
        return pagoPersistence.findById(pagoid);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de Hall
     *
     * @param hallsId Identificador de la instancia de Dieta
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de Hall
     */
    public List<PagoEntity> getPagos(Long personaId) {
        return personaPersistence.find(personaId).getPagos();
    }
}
