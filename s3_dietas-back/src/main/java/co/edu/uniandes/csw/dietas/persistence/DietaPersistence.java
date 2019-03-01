/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private static final Logger LOGGER = Logger.getLogger(DietaPersistence.class.getName());
    
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
    
    public List<DietaEntity> findAll() {
//        LOGGER.log(Level.INFO, "Consultando todas las dietas");
        TypedQuery query = em.createQuery("Select u from DietaEntity u", DietaEntity.class);
        return query.getResultList();
    }
    
    public DietaEntity update(DietaEntity dietaEntity){
        return em.merge(dietaEntity);
    }
    
    public void delete(Long dietasId) {
        DietaEntity dietaEntity = em.find(DietaEntity.class, dietasId);
        em.remove(dietaEntity);
    }
}
