/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Stateless
public class DiaPersistence {
    
    public static final Logger LOGGER = Logger.getLogger(DiaPersistence.class.getName());
     @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
     
    
    public DiaEntity create(DiaEntity diaEntity){
        LOGGER.log(Level.INFO,"Creando un dia nuevo");
        em.persist(diaEntity);
        LOGGER.log(Level.INFO, "Nuevo día creado");
        return diaEntity;
    }
    
    public List<DiaEntity> findAll()
    {
         LOGGER.log(Level.INFO, "Consultando todos los dias");
        Query q = em.createQuery("select u from DiaEntity u");
        return q.getResultList();
    }
    
    public DiaEntity findId(Long pId)
    {
        TypedQuery<DiaEntity> query = em.createQuery("select u from DiaEntity u where u.id = :id", DiaEntity.class);
        query = query.setParameter("id", pId);
        List<DiaEntity> sameId = query.getResultList();
        DiaEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
    
    public DiaEntity find(Long diaId)
    {
         LOGGER.log(Level.INFO, "Consultando el dia con id={0}", diaId);
        return em.find(DiaEntity.class, diaId);
    }
    
    public DiaEntity update(DiaEntity diaEntity)
    {
        LOGGER.log(Level.INFO, "Actualizando el dia con id={0}", diaEntity.getId());
        return em.merge(diaEntity);
    }
    public void delete(Long diaId)
    {
        LOGGER.log(Level.INFO, "Borrando el dia con id={0}", diaId);
       DiaEntity diaEntity = em.find(DiaEntity.class, diaId);
        em.remove(diaEntity);
    }
    
    
    
}
