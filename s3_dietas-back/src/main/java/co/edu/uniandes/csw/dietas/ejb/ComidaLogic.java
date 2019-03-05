/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.ComidaPersistence;
import static co.edu.uniandes.csw.dietas.persistence.SemanaPersistence.LOGGER;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Louis Gualtero
 */
@Stateless
public class ComidaLogic {
    
    @Inject
    private ComidaPersistence persistence;
    
    /**
     * Crea una comida en la persistencia.
     *
     * @param comida La entidad que representa la comida a
     * persistir.
     * @return La entiddad de la comida luego de persistirla.
     * @throws BusinessLogicException Si la comida a persistir ya existe.
     */
    public ComidaEntity createComida(ComidaEntity comida) throws BusinessLogicException{
        
         if (persistence.findById(comida.getId()) != null)  {
            throw new BusinessLogicException("Ya existe una Comida con el id \"" + comida.getId() + "\"");
        }
         // Invoca la persistencia para crear la comida
        comida=persistence.create(comida);
        return comida;
    }
    
     public ComidaEntity getComida(Long comidaId){
        ComidaEntity comidaE = persistence.findById(comidaId);
        if(comidaE == null){
            LOGGER.log(Level.SEVERE, "La comida con el id = {0} no existe", comidaId);
        }
        return comidaE;
    }
     
      public List<ComidaEntity> getComidas() {
        List<ComidaEntity> comidas = persistence.findAll();
        return comidas;
    }
      
      public ComidaEntity updateComida(Long comidaId, ComidaEntity comidaEntity) {
        ComidaEntity newComidaEntity = persistence.update(comidaEntity);
        return newComidaEntity;
    }
    
    public void deleteComida(Long comidasId) throws BusinessLogicException {
        persistence.delete(comidasId);
    } 
    
}
