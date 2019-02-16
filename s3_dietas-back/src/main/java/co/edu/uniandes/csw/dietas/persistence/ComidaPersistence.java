/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;

/**
 *
 * @author  Louis Gualtero.
 */
@Stateless
public class ComidaPersistence {
    private static final Logger LOGGER = Logger.getLogger(ComidaPersistence.class.getName());
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
    /**
     * Crea una comida en la base de datos
     *
     * @param comidaEntity objeto comida que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ComidaEntity create(ComidaEntity comidaEntity){
        LOGGER.log(Level.INFO, "Creando una comida nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la comida en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(comidaEntity);
         LOGGER.log(Level.INFO, "Comida creada");
        return comidaEntity;
    }
     /**
     * Devuelve todas las comidas de la base de datos.
     *
     * @return una lista con todas las comidas que encuentre en la base de
     * datos, "select u from ComidaEntity u" es como un "select * from
     * ComidaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ComidaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las comidas");
        // Se crea un query para buscar todas las comidas en la base de datos.
        TypedQuery query = em.createQuery("select u from ComidaEntity u", ComidaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de comidas.
        return query.getResultList();
    }
    
    /**
     * Busca si hay alguna comida con el id que se envía de argumento
     *
     * @param comidaId: id correspondiente a la comida buscada.
     * @return una comida.
     */
    public ComidaEntity find(Long comidaId) {
        LOGGER.log(Level.INFO, "Consultando la comida con id={0}", comidaId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ComidaEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(ComidaEntity.class, comidaId);
    }
    
     /**
     * Actualiza una comida.
     *
     * @param comidaEntity: la comida que viene con los nuevos cambios. Por
     * ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una comida con los cambios aplicados.
     */
    public ComidaEntity update(ComidaEntity comidaEntity) {
        LOGGER.log(Level.INFO, "Actualizando la comida con id={0}", comidaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la comida con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(comidaEntity);
    }
    
     /**
     * Borra una comida de la base de datos recibiendo como argumento el id de
     * la comida
     *
     * @param comidaId: id correspondiente a la coimda a borrar.
     */
    public void delete(Long comidaId) {

        LOGGER.log(Level.INFO, "Borrando la comida con id={0}", comidaId);
        // Se hace uso de mismo método que esta explicado en public ComidaEntity find(Long id) para obtener la author a borrar.
        ComidaEntity comidaEntity = em.find(ComidaEntity.class, comidaId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
        EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
        Es similar a "delete from ComidaEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(comidaEntity);
    }
}
