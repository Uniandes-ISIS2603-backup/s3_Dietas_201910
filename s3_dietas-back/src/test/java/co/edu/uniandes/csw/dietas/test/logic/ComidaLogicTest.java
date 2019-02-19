/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.ComidaLogic;
import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.ComidaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.junit.runner.RunWith;

/**
 *
 * @author Louis Gualtero
 */
@RunWith(Arquillian.class)
public class ComidaLogicTest {
    
     private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia a la clase ComidaLogic cuyos métodos se
     * van a probar.
     */
    @Inject
    private ComidaLogic comidaLogic;
    
    
     /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
     /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    private UserTransaction utx;
    
     /**
     * Lista que tiene los datos de prueba.
     */
    private List<ComidaEntity> data = new ArrayList<ComidaEntity>();
    
     /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComidaEntity.class.getPackage())
                .addPackage(ComidaLogic.class.getPackage())
                .addPackage(ComidaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from ComidaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ComidaEntity entity = factory.manufacturePojo(ComidaEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
     /**
     * Prueba para crear un Comida.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test
    public void createComidaTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        ComidaEntity result = comidaLogic.createComida(newEntity);
        Assert.assertNotNull(result);
        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para crear un Comida con el mismo nombre de un Comida que ya
     * existe.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createComidaConMismoNombreTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        newEntity.setId(data.get(0).getId());
        comidaLogic.createComida(newEntity);
    }
}
