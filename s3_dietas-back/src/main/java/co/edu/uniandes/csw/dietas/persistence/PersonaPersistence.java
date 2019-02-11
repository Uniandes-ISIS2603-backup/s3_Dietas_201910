/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class PersonaPersistence {
    
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public PersonaEntity create(PersonaEntity personaParam)
    {
        em.persist(personaParam);
        return personaParam;
    }
}
