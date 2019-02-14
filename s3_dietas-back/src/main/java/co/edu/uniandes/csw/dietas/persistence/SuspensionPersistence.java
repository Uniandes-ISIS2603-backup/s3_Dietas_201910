/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
