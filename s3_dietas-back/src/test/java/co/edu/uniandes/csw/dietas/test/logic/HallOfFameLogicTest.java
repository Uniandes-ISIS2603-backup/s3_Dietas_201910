/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.HallOfFameLogic;
import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
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
public class HallOfFameLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia a la clase HallOfFameLogic cuyos métodos se
     * van a probar.
     */
    @Inject
    private HallOfFameLogic hallLogic;
    
    
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
    private List<HallOfFameEntity> data = new ArrayList<HallOfFameEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HallOfFameEntity.class.getPackage())
                .addPackage(HallOfFameLogic.class.getPackage())
                .addPackage(HallOfFamePersistence.class.getPackage())
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
        em.createQuery("delete from HallOfFameEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            HallOfFameEntity entity = factory.manufacturePojo(HallOfFameEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
    
    /**
     * Prueba para crear un HallOfFame.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test
    public void createHallOfFameTest() throws BusinessLogicException {
        HallOfFameEntity newEntity = factory.manufacturePojo(HallOfFameEntity.class);
        HallOfFameEntity result = hallLogic.createHallOfFame(newEntity);
        Assert.assertNotNull(result);
        HallOfFameEntity entity = em.find(HallOfFameEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getMensaje(), entity.getMensaje());
    }
    
     /**
     * Prueba para crear un HallOfFame con el mismo nombre de un HallOfFame que ya
     * existe.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createHallOfFameConMismoNombreTest() throws BusinessLogicException {
        HallOfFameEntity newEntity = factory.manufacturePojo(HallOfFameEntity.class);
        newEntity.setId(data.get(0).getId());
        hallLogic.createHallOfFame(newEntity);
    }
    
}
