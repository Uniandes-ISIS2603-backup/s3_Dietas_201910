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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class QuejaYReclamoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(QuejaYReclamoLogic.class.getName());
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
    
    public QuejaYReclamoEntity getQuejaYReclamo(Long quejaId){
     QuejaYReclamoEntity quejaA = persistence.findById(quejaId);
        if(quejaA == null){
            LOGGER.log(Level.SEVERE, "La queja con el id = {0} no existe", quejaId);
        }
        return quejaA;
    }
    
    public List<QuejaYReclamoEntity> getQuejaYReclamo() {
        List<QuejaYReclamoEntity> quejas = persistence.findAll();
        return quejas;
    }
    
    public QuejaYReclamoEntity updateQuejaYReclamo(Long quejaId, QuejaYReclamoEntity quejaEntity) {
        QuejaYReclamoEntity newQuejaYReclamoEntity = persistence.update(quejaEntity);
        return newQuejaYReclamoEntity;
    }
    
    public void deleteQuejaYReclamo(Long quejaId) throws BusinessLogicException {
        persistence.delete(quejaId);
    } 
}
