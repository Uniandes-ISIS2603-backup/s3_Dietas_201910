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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra Bravo
 */
@Stateless
public class DietaLogic {
    @Inject
    private DietaPersistence persistence;
    
    public DietaEntity createDieta(DietaEntity dieta)throws BusinessLogicException{
        
        if(((persistence.findByName(dieta.getNombre()) != null) || (persistence.findByID(dieta.getId()) != null))){
            throw new BusinessLogicException("Ya existe una dieta con ese nombre o ID \""+dieta.getNombre());
        }
        dieta = persistence.create(dieta);
        return dieta;
    }
    
    public DietaEntity getDieta(Long dietaId) {
        DietaEntity dietaEntity = persistence.findByID(dietaId);
        if (dietaEntity == null) {
//            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", dietaId);
        }
        return dietaEntity;
    }
}
