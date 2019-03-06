/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import static co.edu.uniandes.csw.dietas.persistence.SemanaPersistence.LOGGER;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class SuspensionPersistence {
     @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public SuspensionEntity create(SuspensionEntity suspensionParam)
    {
        em.persist(suspensionParam);
        return suspensionParam;
    }
    
   
    
     /**
     * Devuelve todas las suspensiones de la base de datos.
     *
     * @return una lista con todas las suspensiones que encuentre en la base de
     * datos, "select u from SuspensionEntity u" es como un "select * from
     * SuspensionEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<SuspensionEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las suspensiones de una dieta");
        // Se crea un query para buscar todas las suspensiones en la base de datos.
        TypedQuery query = em.createQuery("select u from SuspensionEntity u", SuspensionEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de suspensiones.
        return query.getResultList();
    }
    
    
    /**
     * Devuelve la suspension de la base de datos que tenga el lid indicado.
     *
     * @return una suspensione que encuentre en la base de
     * datos, "select u from SuspensionEntity u" es como un "select * from
     * SuspensionEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public SuspensionEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from ComidaEntity u where u.id = :id", SuspensionEntity.class);
        query=query.setParameter("id", id);
        List<SuspensionEntity> sameId = query.getResultList();
        SuspensionEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
    
    
     public SuspensionEntity update(SuspensionEntity suspensionEntity){
        return em.merge(suspensionEntity);
    }
     
     
     public void delete(Long suspensionId) {

        LOGGER.log(Level.INFO, "Se borra la suspension con el id dado", suspensionId);
        SuspensionEntity suspensionEntity = em.find(SuspensionEntity.class, suspensionId);
        em.remove(suspensionEntity);
    }
    
}
