/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Stateless
public class SemanaPersistance {
   
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public SemanaEntity create(SemanaEntity semanaEntity){
        em.persist(semanaEntity);
        
        return semanaEntity;
    }
    
}