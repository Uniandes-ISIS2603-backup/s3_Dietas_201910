/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author  Louis Gualtero. 
 */
@Stateless
public class HallOfFamePersistence {
    
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
    public HallOfFameEntity create(HallOfFameEntity entity){
        em.persist(entity);
        return entity;
    }
    
}
