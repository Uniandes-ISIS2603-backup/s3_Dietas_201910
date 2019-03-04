/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alejandra Bravo
 */
@Stateless
public class PagoLogic {
    @Inject
    private PagoPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());
    
    public PagoEntity createPago(PagoEntity pago)throws BusinessLogicException{
        
        if(persistence.findByModo(pago.getModoPago()) != null || persistence.findById(pago.getId()) != null){
            throw new BusinessLogicException("Ya existe un pago con ese modo \""+pago.getModoPago()+"\"");
        }
        pago = persistence.create(pago);
        return pago;
    }
    
    public PagoEntity getPago(Long pagoId){
        PagoEntity pagoE = persistence.findById(pagoId);
        if(pagoE == null){
            LOGGER.log(Level.SEVERE, "El pago con el id = {0} no existe", pagoId);
        }
        return pagoE;
    }
    
    public List<PagoEntity> getPagos() {
        List<PagoEntity> pagos = persistence.findAll();
        return pagos;
    }
    
    public PagoEntity updatePago(Long pagoId, PagoEntity pagoEntity) {
        PagoEntity newPagoEntity = persistence.update(pagoEntity);
        return newPagoEntity;
    }
    
    public void deletePago(Long pagosId) throws BusinessLogicException {
        persistence.delete(pagosId);
    } 
}
