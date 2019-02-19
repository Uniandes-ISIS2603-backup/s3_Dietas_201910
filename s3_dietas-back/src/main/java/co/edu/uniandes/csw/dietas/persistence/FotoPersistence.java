/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;

import co.edu.uniandes.csw.dietas.entities.FotoEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Louis Gualtero
 */
@Stateless
public class FotoPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(FotoPersistence.class.getName());
    
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    
    /**
 * Crea un Foto en la base de datos.
 *
 * @param entity objeto Foto que se crata en la base de datos
 * @return devuelve la entidad creada con un id dado por la base de datos 
 */
    public FotoEntity create(FotoEntity entity){
        LOGGER.log(Level.INFO, "Creando una foto nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir el foto en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
         LOGGER.log(Level.INFO, "Foto creada");
        return entity;
    }
    
    /**
 * Devuelve todas las fotos de la base de datos
 * 
 * @return una lista con todos los fotos que encuentre en la base de 
 * dator, "select u from FotoEntity u" es como un "select * from 
 * FotoEntity;" -SELECT * FROM table_name" en SQL
 */
    public List<FotoEntity> findAll(){
        LOGGER.log(Level.INFO, "Consultando todas las fotos");
        // Se crea un query para buscar todas los fotos en la base de datos.
        TypedQuery query = em.createQuery("select u from FotoEntity u", FotoEntity.class);
         // Note que en el query se hace uso del método getResultList() que obtiene una lista de fotos.
        return query.getResultList();
    }
    
    /**
     * Busca si hay algun foto con el id que se envia de argumento
     * 
     * @param fotoId: id correspondiente a el foto buscado
     * @return un foto 
     */
    public FotoEntity find (Long fotoId){
        LOGGER.log(Level.INFO, "Consultando el foto con id={0}", fotoId);
         /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from FotoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(FotoEntity.class, fotoId);
    }
    
    
    public FotoEntity findByName(String name){
        TypedQuery query = em.createQuery("select u from FotoEntity u where e.name = :name", FotoEntity.class);
        query=query.setParameter("name", name);
        List<FotoEntity> sameName = query.getResultList();
        FotoEntity result;
        if(sameName == null){
            result=null;
        }else if(sameName.isEmpty()){
            result=null;
        }else{
            result = sameName.get(0);
        }
        return result;
    }
    
    /**
     * Actualiza un foto
     * 
     * @param fotoEntity: el foto que viene con los nuevos cambios. Por
     * ejemplo el nombre que pudo cmabiar. En ese caso, se haria uso del metodo
     * update.
     * @return una foto con los cambios aplicados.
     */
    public FotoEntity update(FotoEntity fotoEntity){
         
         /*Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el foto con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(fotoEntity);
    }
    
    /**
     * Borra una foto de la base de datos recibiendo como argumento el id de la
     *  foto
     *
     * @param fotoId: id correspondiente al foto  a borrar.
     */  
    public void delete(Long fotoId) {

        LOGGER.log(Level.INFO, "Borrando el foto con id={0}", fotoId);
        // Se hace uso de mismo método que esta explicado en public FotoEntity find(Long id) para obtener la foto a borrar.
        FotoEntity fotoEntity = em.find(FotoEntity.class, fotoId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
        EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
        Es similar a "delete from FotoEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.
        */
        em.remove(fotoEntity);
    }
    
    
}
