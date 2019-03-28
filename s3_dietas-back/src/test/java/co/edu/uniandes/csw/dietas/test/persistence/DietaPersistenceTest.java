/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Alejandra Bravo
 */
@RunWith(Arquillian.class)
public class DietaPersistenceTest {
     @Inject
     private DietaPersistence dietaPersistence;
     
     @PersistenceContext
     private EntityManager em;
     
     @Inject
    UserTransaction utx;

    private List<DietaEntity> data = new ArrayList<DietaEntity>();
     
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
     @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(DietaEntity.class.getPackage())
                 .addPackage(DietaPersistence.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     /**
     * Configuración inicial de la prueba.
     */
     @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from DietaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DietaEntity entity = factory.manufacturePojo(DietaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
     
    /**
     * Prueba para crear una Dieta.
     */
     @Test
     public void createDietaTest(){
         PodamFactory factory = new PodamFactoryImpl();
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         System.out.print(newEntity);
         DietaEntity result = dietaPersistence.create(newEntity);
       
         Assert.assertNotNull(result);
         
         DietaEntity entity = em.find(DietaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
     }
     
     /**
     * Prueba para consultar la lista de Dietas.
     */
    @Test
    public void getDietasTest() {
        List<DietaEntity> list = dietaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DietaEntity ent : list) {
            boolean found = false;
            for (DietaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Dieta.
     */
    @Test
    public void getDietaTest() {
        DietaEntity entity = data.get(0);
        DietaEntity newEntity = dietaPersistence.findByID(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getObjetivo(), newEntity.getObjetivo());
    }

    /**
     * Prueba para actualizar una Dieta.
     */
    @Test
    public void updateDietaTest() {
        DietaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);

        newEntity.setId(entity.getId());

        dietaPersistence.update(newEntity);

        DietaEntity resp = em.find(DietaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Prueba para eliminar una Dieta.
     */
    @Test
    public void deleteDietaTest() {
        DietaEntity entity = data.get(0);
        dietaPersistence.delete(entity.getId());
        DietaEntity deleted = em.find(DietaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}  
