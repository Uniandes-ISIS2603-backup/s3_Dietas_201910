/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandra Bravo
 */
@Stateless
public class DietaPersistence {
    
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public DietaEntity create(DietaEntity dietaEntity){
        
        em.persist(dietaEntity);
        
        return dietaEntity;
    }
}
