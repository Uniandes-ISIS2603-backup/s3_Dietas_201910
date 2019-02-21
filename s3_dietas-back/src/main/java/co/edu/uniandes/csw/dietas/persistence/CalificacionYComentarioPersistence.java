/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import java.util.List;
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
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public CalificacionYComentarioEntity create(CalificacionYComentarioEntity calificacionYcomentariParam)
    {
        em.persist(calificacionYcomentariParam);
        return calificacionYcomentariParam;
    }
    
    
     public CalificacionYComentarioEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from CalificacionYComentarioEntity u where e.id = :id", CalificacionYComentarioEntity.class);
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
}
