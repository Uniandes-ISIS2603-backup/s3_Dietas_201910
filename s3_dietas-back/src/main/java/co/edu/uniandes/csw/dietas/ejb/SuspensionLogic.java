/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.SuspensionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class SuspensionLogic 
{
    @Inject
    private SuspensionPersistence suspensionP;
    

    
    public SuspensionEntity createSuspension (SuspensionEntity suspension) throws BusinessLogicException
    {
        if(suspensionP.findById( suspension.getId())!= null)
        {
            throw new BusinessLogicException("Ya existe una suspension con ese id");
        }
        suspension = suspensionP.create(suspension);
        return suspension;
    }
    
     public SuspensionEntity getSuspension(Long suspensionId) {
        SuspensionEntity suspensionEntity = suspensionP.findById(suspensionId);
        if (suspensionEntity == null) {
//            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", suspensionId);
        }
        return suspensionEntity;
    }
     
     public List<SuspensionEntity> getSuspensiones() {
        List<SuspensionEntity> pagos = suspensionP.findAll();
        return pagos;
    }
     
     public SuspensionEntity updateSuspension(Long suspensionId, SuspensionEntity suspensionEntity) {
        SuspensionEntity suspensionE = suspensionP.update(suspensionEntity);
        return suspensionE;
    }
     
     public void deleteSuspension(Long suspensionId) throws BusinessLogicException {
        suspensionP.delete(suspensionId);
    }
}
