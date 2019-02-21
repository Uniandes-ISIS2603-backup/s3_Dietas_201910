/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;


import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import co.edu.uniandes.csw.dietas.persistence.QuejaYReclamoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class QuejaYReclamoLogic {
    
    @Inject
    private QuejaYReclamoPersistence persistence;
    
    public QuejaYReclamoEntity createQuejaYReclamo(QuejaYReclamoEntity quejaYReclamo)throws BusinessLogicException
    {
        if(persistence.findById(quejaYReclamo.getId())!=null)
        {
            throw new BusinessLogicException("Ya existe una queja y reclamo con el id\""+quejaYReclamo.getId()+"\"");
        }
        quejaYReclamo= persistence.create(quejaYReclamo);
        return quejaYReclamo;
    }
}
