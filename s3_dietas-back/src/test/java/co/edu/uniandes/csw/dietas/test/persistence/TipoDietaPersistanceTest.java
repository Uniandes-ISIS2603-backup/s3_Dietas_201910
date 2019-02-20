/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistance;
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
 * @author el juancho
 */
@RunWith(Arquillian.class)
public class TipoDietaPersistanceTest {
    @Inject 
    private TipoDietaPersistance tipoDietaPersistence;
    
    @PersistenceContext
     private EntityManager em;
    private List<TipoDietaEntity> data = new ArrayList<TipoDietaEntity>();
    
    @Inject
    UserTransaction utx;
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(TipoDietaEntity.class.getPackage())
                 .addPackage(TipoDietaPersistance.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     @Test
     public void createTipoDietaTest(){
         PodamFactory factory = new PodamFactoryImpl();
         TipoDietaEntity newEntity = factory.manufacturePojo(TipoDietaEntity.class);
         System.out.print(newEntity);
         TipoDietaEntity result = tipoDietaPersistence.create(newEntity);
       
         Assert.assertNotNull(result);
     }
     @Test
    public void createTipoDietaEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    TipoDietaEntity newEntity = factory.manufacturePojo(TipoDietaEntity.class);
    TipoDietaEntity result = tipoDietaPersistence.create(newEntity);

    Assert.assertNotNull(result);
    TipoDietaEntity entity = em.find(TipoDietaEntity.class, result.getId());
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
        em.createQuery("delete from TipoDietaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TipoDietaEntity entity = factory.manufacturePojo(TipoDietaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
      /**
     * Prueba para consultar la lista de tipoDietas.
     */
    @Test
    public void getTipoDietasTest() {
        List<TipoDietaEntity> list = tipoDietaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TipoDietaEntity ent : list) {
            boolean found = false;
            for (TipoDietaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getTipoDietaTest() {
        TipoDietaEntity entity = data.get(0);
        TipoDietaEntity newEntity = tipoDietaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    

    /**
     * Prueba para eliminar una TipoDieta.
     */
    @Test
    public void deleteTipoDietaTest() {
        TipoDietaEntity entity = data.get(0);
        tipoDietaPersistence.delete(entity.getId());
        TipoDietaEntity deleted = em.find(TipoDietaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
