/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.SemanaPersistence;
import static co.edu.uniandes.csw.dietas.persistence.SemanaPersistence.LOGGER;
import java.util.List;
import java.util.logging.Level;
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
    
    public SemanaEntity createSemana(SemanaEntity semana) throws BusinessLogicException
    {
        if(persistence.findId(semana.getId()) != null)
                {
                throw new BusinessLogicException("Ya existe una semana con el id: \'" + semana.getId());
                }
        semana = persistence.create(semana);
        return semana;
    }
     public SemanaEntity getSemana(Long semanaId)
    {
        SemanaEntity entidad = persistence.findId(semanaId);
        if(entidad == null)
        {
            LOGGER.log(Level.SEVERE, "El semana con el id = {0} no existe", semanaId);
        }
        return entidad;
    }
    public List<SemanaEntity> getSemanas(){
        List<SemanaEntity> semanas = persistence.findAll();
        return semanas;
    }
    public SemanaEntity updateSemana(Long semanaId, SemanaEntity entidadNueva){
        SemanaEntity nuevo = persistence.update(entidadNueva);
        return nuevo;
    }
    
    public void deleteSemana(Long idSemana)throws BusinessLogicException{
        persistence.delete(idSemana);
    }
    
}
