/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    public DietaEntity findByName(String nombre){
        TypedQuery<DietaEntity> query = em.createQuery("Select e From DietaEntity e where e.nombre = :nombre", DietaEntity.class);
        query = query.setParameter("nombre", nombre);
        List<DietaEntity> sameName = query.getResultList();
        DietaEntity result;
        if(sameName == null || sameName.isEmpty())
            result = null;
        else
            result = sameName.get(0);
        return result;
    }
    
    public DietaEntity findByID(Long idD){
        TypedQuery<DietaEntity> query = em.createQuery("Select e From DietaEntity e where e.id = :id", DietaEntity.class);
        query = query.setParameter("id", idD);
        List<DietaEntity> sameID = query.getResultList();
        DietaEntity result;
        if(sameID == null || sameID.isEmpty())
            result = null;
        else
            result = sameID.get(0);
        return result;
    }
}
