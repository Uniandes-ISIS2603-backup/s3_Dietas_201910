/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author estudiante
 */
@Stateless
public class DiaPersistance {
    
     @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public DiaEntity create(DiaEntity diaEntity){
        em.persist(diaEntity);
        
        return diaEntity;
    }
    
}
