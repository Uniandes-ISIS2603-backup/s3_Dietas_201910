/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
import java.util.List;
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
    public HallOfFameEntity getHall(Long hallId){
        HallOfFameEntity hallEntity= persistence.findById(hallId);
        if(hallEntity == null){
            //            LOGGER.log(Level.SEVERE, "El hall con el id = {0} no existe", hallId);
        }
        return hallEntity;
    }
    public List<HallOfFameEntity> getHalls() {
        List<HallOfFameEntity> halls = persistence.findAll();
        return halls;
    }
    
     public HallOfFameEntity updateHall(Long hallId, HallOfFameEntity hallEntity) {
        HallOfFameEntity newHallEntity = persistence.update(hallEntity);
        return newHallEntity;
    }
     
    public void deleteHall(Long hallId) throws BusinessLogicException {
        List<PersonaEntity> personas = getHall(hallId).getPersonas();
        if (personas != null && !personas.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el hall con id = " + hallId + " porque tiene personas asociadas");
        }
        
        persistence.delete(hallId);
    }
    
}
