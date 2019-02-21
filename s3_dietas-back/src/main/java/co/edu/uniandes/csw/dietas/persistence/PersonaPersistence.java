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

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class PersonaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaPersistence.class.getName());

    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public PersonaEntity create(PersonaEntity personaParam)
    {
        em.persist(personaParam);
        return personaParam;
    }
     /**
     * Devuelve todas las personas de la base de datos.
     *
     * @return una lista con todas las personas que encuentre en la base de
     * datos, "select u from PersonaEntity u" es como un "select * from
     * PersonaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<PersonaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las personas");
        // Se crea un query para buscar todas las personas en la base de datos.
        TypedQuery query = em.createQuery("select u from PersonaEntity u", PersonaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de comidas.
        return query.getResultList();
    }
    
    /**
     * Busca si hay alguna persona con el id que se envía de argumento
     *
     * @param personaId: id correspondiente a la comida buscada.
     * @return una comida.
     */
    public PersonaEntity find(Long personaId) {
        LOGGER.log(Level.INFO, "Consultando la persona con id={0}", personaId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from PersonaEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(PersonaEntity.class, personaId);
    }
    
    public PersonaEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from PersonaEntity u where u.id = :id", PersonaEntity.class);
        query=query.setParameter("id", id);
        List<PersonaEntity> sameId = query.getResultList();
        PersonaEntity result;
        if(sameId == null){
            result=null;
        }else if(sameId.isEmpty()){
            result=null;
        }else{
            result = sameId.get(0);
        }
        return result;
    }
    
     /**
     * Actualiza una persona.
     *
     * @param personaEntity: la persona que viene con los nuevos cambios. Por
     * ejemplo los objetivos pudieron cambiar. En ese caso, se haria uso del método
     * update.
     * @return una comida con los cambios aplicados.
     */
    public PersonaEntity update(PersonaEntity personaEntity) {
        LOGGER.log(Level.INFO, "Actualizando la persona con id={0}", personaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la comida con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(personaEntity);
    }
    
     /**
     * Borra una persona de la base de datos recibiendo como argumento el id de
     * la persona
     *
     * @param personaId: id correspondiente a la persona a borrar.
     */
    public void delete(Long personaId) {

        LOGGER.log(Level.INFO, "Borrando la persona con id={0}", personaId);
        // Se hace uso de mismo método que esta explicado en public PersonaEntity find(Long id) para obtener la persona a borrar.
        PersonaEntity personaEntity = em.find(PersonaEntity.class, personaId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
        EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
        Es similar a "delete from PersonaEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(personaEntity);
    }
}
