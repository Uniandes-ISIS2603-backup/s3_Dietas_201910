/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alejandra Bravo
 */
@Stateless
public class DietaLogic {
    @Inject
    private DietaPersistence persistence;
    
    public DietaEntity createDieta(DietaEntity dieta)throws BusinessLogicException{
        
        if(persistence.findById(dieta.getId()) != null){
            throw new BusinessLogicException("Ya existe una dieta con ese ID \""+dieta.getId()+"\"");
        }
        dieta = persistence.create(dieta);
        return dieta;
    }
}
