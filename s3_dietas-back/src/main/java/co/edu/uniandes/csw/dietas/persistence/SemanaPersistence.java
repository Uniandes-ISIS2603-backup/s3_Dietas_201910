/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
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
public class SemanaPersistence {
   public static final Logger LOGGER = Logger.getLogger(SemanaPersistence.class.getName());
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public SemanaEntity create (SemanaEntity semanaEntity){
        LOGGER.log(Level.INFO,"Creando un semana nuevo");
        em.persist(semanaEntity);
        LOGGER.log(Level.INFO, "Nueva semana creada");
        return semanaEntity;
    }
    
    public List <SemanaEntity> findAll()
    {
         LOGGER.log(Level.INFO, "Consultando todas las semanas");
        Query q = em.createQuery("select u from SemanaEntity u");
        return q.getResultList();
    }
    public SemanaEntity find(Long semanaId)
    {
         LOGGER.log(Level.INFO, "Consultando el semana con id={0}", semanaId);
        return em.find(SemanaEntity.class, semanaId);
    }
    
    public SemanaEntity update(SemanaEntity semanaEntity)
    {
        LOGGER.log(Level.INFO, "Actualizando el libro con id={0}", semanaEntity.getId());
        return em.merge(semanaEntity);
    }
    public void delete(Long semanaId)
    {
        LOGGER.log(Level.INFO, "Borrando el semana con id={0}", semanaId);
       SemanaEntity semanaEntity = em.find(SemanaEntity.class, semanaId);
        em.remove(semanaEntity);
    }
    
     public SemanaEntity findId(Long pId)
    {
        TypedQuery<SemanaEntity> query = em.createQuery("Select e From SemanaEntity e where e.id = :id", SemanaEntity.class);
        query = query.setParameter("id", pId);
        List<SemanaEntity> sameId = query.getResultList();
        SemanaEntity semanaBuscada;
        if(sameId == null)
        {
            semanaBuscada =null;
        }
        if(sameId.isEmpty())
        {
            semanaBuscada = null;
        }
        else{
            semanaBuscada = sameId.get(0);
        }
        return semanaBuscada;
    }
    
}