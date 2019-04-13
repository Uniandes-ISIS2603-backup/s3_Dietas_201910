/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class PersonaPersistence {
    @PersistenceContext(unitName = "dietasPU")
    protected EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(PersonaPersistence.class.getName());
    
        public PersonaEntity create(PersonaEntity personaEntity){
        em.persist(personaEntity);
        
        return personaEntity;
        }    
    public PersonaEntity findById(Long personaId){
        return em.find(PersonaEntity.class, personaId); 
    }
    
    public List<PersonaEntity> findAll() {
        TypedQuery query = em.createQuery("select u from PersonaEntity u", PersonaEntity.class);
         // Note que en el query se hace uso del método getResultList() que obtiene una lista de halls.
        return query.getResultList();
    }
    
    public PersonaEntity update(PersonaEntity personaEntity){
        return em.merge(personaEntity);
    }
    
    public void delete(Long personaId) {
        PersonaEntity personaEntity = em.find(PersonaEntity.class, personaId);
        em.remove(personaEntity);
    }
}
