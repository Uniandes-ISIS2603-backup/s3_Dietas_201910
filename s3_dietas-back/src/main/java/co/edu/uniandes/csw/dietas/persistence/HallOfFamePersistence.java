/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author  Louis Gualtero. 
 */
@Stateless
public class HallOfFamePersistence {
    
     private static final Logger LOGGER = Logger.getLogger(HallOfFamePersistence.class.getName());
    
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
 /**
 * Crea un HallOfFame en la base de datos.
 *
 * @param entity objeto HallOfFame que se crata en la base de datos
 * @return devuelve la entidad creada con un id dado por la base de datos 
 */
    public HallOfFameEntity create(HallOfFameEntity entity){
        LOGGER.log(Level.INFO, "Creando un hall nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir el hall en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
         LOGGER.log(Level.INFO, "Hall creado");
        return entity;
    }
    
/**
 * Devuelve todas los halls of fame de la base de datos
 * 
 * @return una lista con todos los halls of fame que encuentre en la base de 
 * dator, "select u from HallOfFameEntity u" es como un "select * from 
 * HallOfFameEntity;" -SELECT * FROM table_name" en SQL
 */
    public List<HallOfFameEntity> findAll(){
        LOGGER.log(Level.INFO, "Consultando todos los halls");
        // Se crea un query para buscar todas los halls en la base de datos.
        TypedQuery query = em.createQuery("select u from HallOfFameEntity u", HallOfFameEntity.class);
         // Note que en el query se hace uso del método getResultList() que obtiene una lista de halls.
        return query.getResultList();
    }
    
    /**
     * Busca si hay algun Hall of Fame con el id que se envia de argumento
     * 
     * @param hallId: id correspondiente a el hall buscado
     * @return un hall of fame
     
    public HallOfFameEntity find (Long hallId){
        LOGGER.log(Level.INFO, "Consultando el hall con id={0}", hallId);
         Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from HallOfFameEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         
        return em.find(HallOfFameEntity.class, hallId);
    }
    */
    /**
     * Actualiza un hall of fame
     * 
     * @param hallEntity: el hall que viene con los nuevos cambios. Por
     * ejemplo el nombre que pudo cmabiar. En ese caso, se haria uso del metodo
     * update.
     * @return un hall con los cambios aplicados.
     
    public HallOfFameEntity update(HallOfFameEntity hallEntity){
         
         Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el hall con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         
        return em.merge(hallEntity);
    }
    */
    /**
     * Borra una hall de la base de datos recibiendo como argumento el id del
     *  hall
     *
     * @param hallsId: id correspondiente al hall  a borrar.
    
    public void delete(Long hallsId) {

        LOGGER.log(Level.INFO, "Borrando el hall con id={0}", hallsId);
        // Se hace uso de mismo método que esta explicado en public HallOfFameEntity find(Long id) para obtener la hall a borrar.
        HallOfFameEntity hallEntity = em.find(HallOfFameEntity.class, hallsId);
         Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
        EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
        Es similar a "delete from HallOfFameEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.
        em.remove(hallEntity);
    }
    */       
}
