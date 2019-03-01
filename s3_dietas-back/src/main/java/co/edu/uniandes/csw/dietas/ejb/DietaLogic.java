/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import java.util.List;
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
    private static final Logger LOGGER = Logger.getLogger(DietaLogic.class.getName());
    
    
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
//            LOGGER.log(Level.SEVERE, "La dieta con el id = {0} no existe", dietaId);
        }
        return dietaEntity;
    }
    
    public List<DietaEntity> getDietas() {
        List<DietaEntity> dietas = persistence.findAll();
        return dietas;
    }
    
    public DietaEntity updateDieta(Long dietaId, DietaEntity dietaEntity) {
        DietaEntity newDietaEntity = persistence.update(dietaEntity);
        return newDietaEntity;
    }
    
    public void deleteDieta(Long dietasId) throws BusinessLogicException {
        List<SemanaEntity> semanas = getDieta(dietasId).getSemanas();
        if (semanas != null && !semanas.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene semanas asociadas");
        }
        List<SuspensionEntity> suspensiones = getDieta(dietasId).getSuspension();
        if (suspensiones != null && !suspensiones.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene suspensiones asociadas");
        }
        List<TipoDietaEntity> tiposDieta = getDieta(dietasId).gettDietas();
        if (tiposDieta != null && !tiposDieta.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar la dieta con id = " + dietasId + " porque tiene tipos de dieta asociadas");
        }
        persistence.delete(dietasId);
    }
}
