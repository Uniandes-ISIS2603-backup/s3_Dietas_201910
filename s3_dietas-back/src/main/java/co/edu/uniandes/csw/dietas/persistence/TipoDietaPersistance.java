/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author el juacho
 */
@Stateless
public class TipoDietaPersistance {
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
    public TipoDietaEntity create (TipoDietaEntity tipoDietaEntity)
    {
        em.persist(tipoDietaEntity);
        return tipoDietaEntity;
    }
     
}
