/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.persistence.SemanaPersistence;
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
 * @author Juan Antonio Restrepo
 */

@RunWith(Arquillian.class)
public class SemanaPersistanceTest {
    
   @Inject 
    private SemanaPersistence semanaPersistence;
    
    @PersistenceContext
     private EntityManager em;
    private List<SemanaEntity> data = new ArrayList<SemanaEntity>();
    
    @Inject
    UserTransaction utx;
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(SemanaEntity.class.getPackage())
                 .addPackage(SemanaPersistence.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     @Test
     public void createSemanaTest(){
         PodamFactory factory = new PodamFactoryImpl();
         SemanaEntity newEntity = factory.manufacturePojo(SemanaEntity.class);
         System.out.print(newEntity);
         SemanaEntity result = semanaPersistence.create(newEntity);
       
         Assert.assertNotNull(result);
     }
     @Test
    public void createSemanaEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    SemanaEntity newEntity = factory.manufacturePojo(SemanaEntity.class);
    SemanaEntity result = semanaPersistence.create(newEntity);

    Assert.assertNotNull(result);
    SemanaEntity entity = em.find(SemanaEntity.class, result.getId());
    Assert.assertNotNull(entity);
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
        em.createQuery("delete from SemanaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SemanaEntity entity = factory.manufacturePojo(SemanaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
      /**
     * Prueba para consultar la lista de semanas.
     */
    @Test
    public void getSemanasTest() {
        List<SemanaEntity> list = semanaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (SemanaEntity ent : list) {
            boolean found = false;
            for (SemanaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getSemanaTest() {
        SemanaEntity entity = data.get(0);
        SemanaEntity newEntity = semanaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getCosto(), newEntity.getCosto());
    }

    

    /**
     * Prueba para eliminar una Semana.
     */
    @Test
    public void deleteSemanaTest() {
        SemanaEntity entity = data.get(0);
        semanaPersistence.delete(entity.getId());
        SemanaEntity deleted = em.find(SemanaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}