/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
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
 * @author el juacho
 */
@Stateless
public class TipoDietaPersistence {
   public static final Logger LOGGER = Logger.getLogger(TipoDietaPersistence.class.getName());
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public TipoDietaEntity create (TipoDietaEntity tipoDietaEntity){
        LOGGER.log(Level.INFO,"Creando un tipoDieta nuevo");
        em.persist(tipoDietaEntity);
        LOGGER.log(Level.INFO, "Nueva tipoDieta creada");
        return tipoDietaEntity;
    }
    
    public List <TipoDietaEntity> findAll()
    {
         LOGGER.log(Level.INFO, "Consultando todas las tipoDietas");
        Query q = em.createQuery("select u from TipoDietaEntity u");
        return q.getResultList();
    }
    public TipoDietaEntity find(Long tipoDietaId)
    {
         LOGGER.log(Level.INFO, "Consultando el tipoDieta con id={0}", tipoDietaId);
        return em.find(TipoDietaEntity.class, tipoDietaId);
    }
    
    public TipoDietaEntity update(TipoDietaEntity tipoDietaEntity)
    {
        LOGGER.log(Level.INFO, "Actualizando el libro con id={0}", tipoDietaEntity.getId());
        return em.merge(tipoDietaEntity);
    }
    public void delete(Long tipoDietaId)
    {
        LOGGER.log(Level.INFO, "Borrando el tipoDieta con id={0}", tipoDietaId);
       TipoDietaEntity tipoDietaEntity = em.find(TipoDietaEntity.class, tipoDietaId);
        em.remove(tipoDietaEntity);
    }
     public TipoDietaEntity findId(Long id)
    {
        TypedQuery query = em.createQuery("select u from TipoDietaEntity u where u.id = :id", TipoDietaEntity.class);
        query=query.setParameter("id", id);
        List<TipoDietaEntity> sameId = query.getResultList();
        TipoDietaEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
    
     
     
}
