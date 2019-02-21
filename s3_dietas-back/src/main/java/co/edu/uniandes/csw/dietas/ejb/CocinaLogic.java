/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.CocinaPersistence;
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
public class CocinaLogic 
{
    @Inject
    private CocinaPersistence cocinaP;
    

    
    public CocinaEntity createCocina (CocinaEntity cocina) throws BusinessLogicException
    {
        if(cocinaP.findById( cocina.getId())!= null)
        {
            throw new BusinessLogicException("Ya existe una cocina con ese id");
        }
        cocinaP.create(cocina);
        return cocina;
    }
}

