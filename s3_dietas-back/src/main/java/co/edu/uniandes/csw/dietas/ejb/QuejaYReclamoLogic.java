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
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final Logger LOGGER = Logger.getLogger(QuejaYReclamoLogic.class.getName());
    
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
        QuejaYReclamoEntity queja = persistence.findById(quejaId);
        if(queja == null){
            LOGGER.log(Level.SEVERE, "La queja con el id = {0} no existe", quejaId);
        }
        return queja;
    }
    
    public List<QuejaYReclamoEntity> getQuejasYReclamos() {
        List<QuejaYReclamoEntity> quejas = persistence.findAll();
        return quejas;
    }
    
    public QuejaYReclamoEntity updateQuejaYReclamo(Long quejaId, QuejaYReclamoEntity quejaEntity) {
        QuejaYReclamoEntity newQuejaEntity = persistence.update(quejaEntity);
        return newQuejaEntity;
    }
    
    public void deleteQuejaYReclamo(Long quejaId) throws BusinessLogicException {
        persistence.delete(quejaId);
    } 
}
