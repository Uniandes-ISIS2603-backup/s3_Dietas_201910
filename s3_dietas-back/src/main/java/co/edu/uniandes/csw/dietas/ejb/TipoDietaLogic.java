/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estutipoDietante
 */
@Stateless
public class TipoDietaLogic {
    @Inject
    private TipoDietaPersistence persistence;
    
    public TipoDietaEntity crearTipoDieta(TipoDietaEntity tipoDieta) throws BusinessLogicException
    {
        if(persistence.findId(tipoDieta.getId()) != null)
                {
                throw new BusinessLogicException("Ya existe un tipoDieta con el id: \'" + tipoDieta.getId());
                }
        tipoDieta = persistence.create(tipoDieta);
        return tipoDieta;
    }
    
}
