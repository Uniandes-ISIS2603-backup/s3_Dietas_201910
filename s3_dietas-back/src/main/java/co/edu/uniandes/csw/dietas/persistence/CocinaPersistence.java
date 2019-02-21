/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
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
public class CocinaPersistence {
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public CocinaEntity create(CocinaEntity cocinaParam)
    {
        em.persist(cocinaParam);
        return cocinaParam;
    }

    public SuspensionEntity create(SuspensionEntity newEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      
    public CocinaEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from ComidaEntity u where e.id = :id", CocinaEntity.class);
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
}
