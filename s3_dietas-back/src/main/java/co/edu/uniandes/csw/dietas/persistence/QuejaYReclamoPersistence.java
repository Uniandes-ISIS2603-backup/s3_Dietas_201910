/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author estudiante
 */
@Stateless
public class QuejaYReclamoPersistence {
        
    private static final Logger LOGGER = Logger.getLogger(QuejaYReclamoPersistence.class.getName());
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public QuejaYReclamoEntity create(QuejaYReclamoEntity quejaYReclamoParam)
    {
        em.persist(quejaYReclamoParam);
        return quejaYReclamoParam;
    }
     /**
     * Devuelve todas las quejas y reclamos de la base de datos.
     *
     * @return una lista con todas las quejas y reclamos que encuentre en la base de
     * datos, "select u from QuejaYReclamoEntity u" es como un "select * from
     * PersonaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<QuejaYReclamoEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las quejas y reclamos");
        // Se crea un query para buscar todas las quejas y reclamos en la base de datos.
        TypedQuery query = em.createQuery("select u from QuejaYReclamoEntity u", QuejaYReclamoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de comidas.
        return query.getResultList();
    }
    
    /**
     * Busca si hay alguna queja y reclamo con el id que se envía de argumento
     *
     * @param quejaYReclamoId: id correspondiente a la comida buscada.
     * @return una comida.
     */
    public QuejaYReclamoEntity find(Long quejaYReclamoId) {
        LOGGER.log(Level.INFO, "Consultando la persona con id={0}", quejaYReclamoId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from QuejaYReclamoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(QuejaYReclamoEntity.class, quejaYReclamoId);
    }
    
    public QuejaYReclamoEntity findById(Long id){
        TypedQuery query = em.createQuery("select u from QuejaYReclamoEntity u where u.id = :id", QuejaYReclamoEntity.class);
        query=query.setParameter("id", id);
        List<QuejaYReclamoEntity> sameId = query.getResultList();
        QuejaYReclamoEntity result;
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
     * Actualiza una queja y reclamo.
     *
     * @param quejaYReclamoEntity: la persona que viene con los nuevos cambios. Por
     * ejemplo los objetivos pudieron cambiar. En ese caso, se haria uso del método
     * update.
     * @return una comida con los cambios aplicados.
     */
    public QuejaYReclamoEntity update(QuejaYReclamoEntity quejaYReclamoEntity) {
        LOGGER.log(Level.INFO, "Actualizando la persona con id={0}", quejaYReclamoEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la comida con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(quejaYReclamoEntity);
    }
    
     /**
     * Borra una queja y reclamo de la base de datos recibiendo como argumento el id de
     * la persona
     *
     * @param quejaYReclamoId: id correspondiente a la persona a borrar.
     */
    public void delete(Long quejaYReclamoId) {

        LOGGER.log(Level.INFO, "Borrando la persona con id={0}", quejaYReclamoId);
        // Se hace uso de mismo método que esta explicado en public QuejaYReclamoEntity find(Long id) para obtener la persona a borrar.
        QuejaYReclamoEntity quejaYReclamoEntity = em.find(QuejaYReclamoEntity.class, quejaYReclamoId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
        EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
        Es similar a "delete from QuejaYReclamoEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(quejaYReclamoEntity);
    }
}
