/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
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
public class CalificacionYComentarioPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(CalificacionYComentarioPersistence.class.getName());
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
    
    
    public CalificacionYComentarioEntity create(CalificacionYComentarioEntity calificacionYcomentariParam)
    {
        em.persist(calificacionYcomentariParam);
        return calificacionYcomentariParam;
    }
    
    
    
     public List<CalificacionYComentarioEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las CalificacionesYComentarios de una dieta");
        // Se crea un query para buscar todas las CalificacionesYComentarios en la base de datos.
        TypedQuery query = em.createQuery("select u from CalificacionYComentarioEntity u", CalificacionYComentarioEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de CalificacionesYComentarios.
        return query.getResultList();
    }
    
    
    
     public CalificacionYComentarioEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from CalificacionYComentarioEntity u where u.id = :id", CalificacionYComentarioEntity.class);
        query=query.setParameter("id", id);
        List<CalificacionYComentarioEntity> sameId = query.getResultList();
        CalificacionYComentarioEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
     
      public CalificacionYComentarioEntity update(CalificacionYComentarioEntity calificacionYcomentarioEntity){
        return em.merge(calificacionYcomentarioEntity);
    }
     
     
     public void delete(Long calificacionYcomentarioId) {

        LOGGER.log(Level.INFO, "Se borra la CalificacionYComentario con el id dado", calificacionYcomentarioId);
        CalificacionYComentarioEntity calificacionYcomentarioEntity = em.find(CalificacionYComentarioEntity.class, calificacionYcomentarioId);
        em.remove(calificacionYcomentarioEntity);
    }
     
}