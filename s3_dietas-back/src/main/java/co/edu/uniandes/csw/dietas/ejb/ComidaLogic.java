/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.ComidaPersistence;
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
    
    
}
