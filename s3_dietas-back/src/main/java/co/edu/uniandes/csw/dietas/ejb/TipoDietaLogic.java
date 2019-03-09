/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistence;
import static co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistence.LOGGER;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Stateless
public class TipoDietaLogic {
    
    @Inject
    private TipoDietaPersistence persistence;
    
    public TipoDietaEntity createTipoDieta(TipoDietaEntity tipoDieta) throws BusinessLogicException
    {
        if(persistence.findId(tipoDieta.getId()) != null)
                {
                throw new BusinessLogicException("Ya existe un tipoDieta con el id: \'" + tipoDieta.getId());
                }
        tipoDieta = persistence.create(tipoDieta);
        return tipoDieta;
    }
     public TipoDietaEntity getTipoDieta(Long TipoDietaId)
    {
        TipoDietaEntity entidad = persistence.findId(TipoDietaId);
        if(entidad == null)
        {
            LOGGER.log(Level.SEVERE, "El TipoDieta con el id = {0} no existe", TipoDietaId);
        }
        return entidad;
    }
    public List<TipoDietaEntity> getTipoDietas(){
        List<TipoDietaEntity> TipoDietas = persistence.findAll();
        return TipoDietas;
    }
    public TipoDietaEntity updateTipoDieta(Long TipoDietaId, TipoDietaEntity entidadNueva){
        TipoDietaEntity nuevo = persistence.update(entidadNueva);
        return nuevo;
    }
    
    public void deleteTipoDieta(Long idTipoDieta)throws BusinessLogicException{
        persistence.delete(idTipoDieta);
    }
}
