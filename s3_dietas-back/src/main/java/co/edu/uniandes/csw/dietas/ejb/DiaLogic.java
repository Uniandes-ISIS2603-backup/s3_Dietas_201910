/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.DiaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Antonio Restrepo
 */

@Stateless
public class DiaLogic 
{
    @Inject
    private DiaPersistence persistence;
    
    public DiaEntity createDia(DiaEntity dia) throws BusinessLogicException
    {
        if(persistence.findId(dia.getId()) != null)
                {
                throw new BusinessLogicException("Ya existe un dia con el id: \'" + dia.getId());
                }
        dia = persistence.create(dia);
        return dia;
    }
    
    
    
}
