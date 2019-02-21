/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PagoPersistence;
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
    
    public PagoEntity createPago(PagoEntity pago)throws BusinessLogicException{
        
        if(persistence.findByModo(pago.getModoPago()) != null){
            throw new BusinessLogicException("Ya existe un pago con ese modo \""+pago.getModoPago()+"\"");
        }
        pago = persistence.create(pago);
        return pago;
    }
}
