/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.SemanaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Antonio Restrepo
 */

@Stateless
public class SemanaLogic {
    
    @Inject
    private SemanaPersistence persistence;
    
    public SemanaEntity crearSemana(SemanaEntity semana) throws BusinessLogicException
    {
        if(persistence.findId(semana.getId()) != null)
                {
                throw new BusinessLogicException("Ya existe una semana con el id: \'" + semana.getId());
                }
        semana = persistence.create(semana);
        return semana;
    }
}
