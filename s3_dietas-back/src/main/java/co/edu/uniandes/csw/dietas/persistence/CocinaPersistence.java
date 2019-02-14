/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
