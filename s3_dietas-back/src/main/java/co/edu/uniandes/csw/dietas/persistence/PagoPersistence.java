/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alejandra
 */
@Stateless
public class PagoPersistence {
    
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    
    public PagoEntity create(PagoEntity pagoEntity){
        em.persist(pagoEntity);
        
        return pagoEntity;
    }
    
    public PagoEntity findByModo(String modoP){
        TypedQuery<PagoEntity> query = em.createQuery("Select e From PagoEntity e where e.modoPago = :modo", PagoEntity.class);
        query = query.setParameter("modo", modoP);
        List<PagoEntity> sameModo = query.getResultList();
        PagoEntity result;
        if(sameModo == null || sameModo.isEmpty())
            result = null;
        else
            result = sameModo.get(0);
        return result;
    }
}
