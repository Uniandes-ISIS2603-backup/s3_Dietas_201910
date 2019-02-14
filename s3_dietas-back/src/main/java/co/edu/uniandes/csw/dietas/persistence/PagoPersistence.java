/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
