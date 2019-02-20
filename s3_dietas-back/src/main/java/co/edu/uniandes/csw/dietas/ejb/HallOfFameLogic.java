/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author Louis Gualtero
 */
@Stateless
public class HallOfFameLogic {
    
     @Inject
    private HallOfFamePersistence persistence;
    
    /**
     * Crea un hall en la persistencia.
     *
     * @param hall La entidad que representa la hall a
     * persistir.
     * @return La entidad del hall luego de persistirla.
     * @throws BusinessLogicException Si la hall a persistir ya existe.
     */
    public HallOfFameEntity createHallOfFame(HallOfFameEntity hall) throws BusinessLogicException{
        
         if (persistence.findById(hall.getId()) != null)  {
            throw new BusinessLogicException("Ya existe un HallOfFame con el id \"" + hall.getId() + "\"");
        }
         // Invoca la persistencia para crear la hall
        hall=persistence.create(hall);
        return hall;
    }
}