/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class CocinaPersistence {
    
    
     private static final Logger LOGGER = Logger.getLogger(CocinaPersistence.class.getName());
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
   
    public CocinaEntity create(CocinaEntity cocinaParam)
    {    LOGGER.log(Level.INFO, "Creando una cocina nueva");
        em.persist(cocinaParam);
        LOGGER.log(Level.INFO, "Comida creada");
        return cocinaParam;
    }

     
    
     /**
     * Devuelve todas las suspensiones de la base de datos.
     *
     * @return una lista con todas las suspensiones que encuentre en la base de
     * datos, "select u from SuspensionEntity u" es como un "select * from
     * SuspensionEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<CocinaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las cocinas");
        // Se crea un query para buscar todas las cocinas en la base de datos.
        TypedQuery query = em.createQuery("select u from CocinaEntity u", CocinaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de cocinas.
        return query.getResultList();
    }
    
      
    public CocinaEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from CocinaEntity u where u.id = :id", CocinaEntity.class);
        query=query.setParameter("id", id);
        List<CocinaEntity> sameId = query.getResultList();
        CocinaEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
  
    
    
    public CocinaEntity findByDirection(String direccion){
        TypedQuery<CocinaEntity> query = em.createQuery("Select e From CocinaEntity e where e.direccion = :direccion", CocinaEntity.class);
        query = query.setParameter("direccion", direccion);
        List<CocinaEntity> sameDireccion = query.getResultList();
        CocinaEntity result;
        if(sameDireccion == null || sameDireccion.isEmpty())
            result = null;
        else
            result = sameDireccion.get(0);
        return result;
    }
    
        public CocinaEntity update(CocinaEntity cocinaEntity){
        return em.merge(cocinaEntity);
    }
    
    public void delete(Long cocinaId) {

        LOGGER.log(Level.INFO, "Borrando la cocina con id={0}", cocinaId);      
        CocinaEntity cocinaEntity = em.find(CocinaEntity.class, cocinaId);        
        em.remove(cocinaEntity);
    }
    
}
