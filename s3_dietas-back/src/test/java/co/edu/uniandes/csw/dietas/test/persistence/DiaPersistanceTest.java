/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import co.edu.uniandes.csw.dietas.persistence.DiaPersistance;
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
 * @author juan restrepo
 */
@RunWith(Arquillian.class)
public class DiaPersistanceTest {
    @Inject 
    private DiaPersistance diaPersistence;
    
    @PersistenceContext
     private EntityManager em;
    private List<DiaEntity> data = new ArrayList<DiaEntity>();
    
    @Inject
    UserTransaction utx;
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(DiaEntity.class.getPackage())
                 .addPackage(DiaPersistance.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     @Test
     public void createPagoTest(){
         PodamFactory factory = new PodamFactoryImpl();
         DiaEntity newEntity = factory.manufacturePojo(DiaEntity.class);
         System.out.print(newEntity);
         DiaEntity result = diaPersistence.create(newEntity);
       
         Assert.assertNotNull(result);
     }
     @Test
    public void createDiaEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    DiaEntity newEntity = factory.manufacturePojo(DiaEntity.class);
    DiaEntity result = diaPersistence.create(newEntity);

    Assert.assertNotNull(result);
    DiaEntity entity = em.find(DiaEntity.class, result.getId());
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
        em.createQuery("delete from DiaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DiaEntity entity = factory.manufacturePojo(DiaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
      /**
     * Prueba para consultar la lista de dias.
     */
    @Test
    public void getDiasTest() {
        List<DiaEntity> list = diaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DiaEntity ent : list) {
            boolean found = false;
            for (DiaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getDiaTest() {
        DiaEntity entity = data.get(0);
        DiaEntity newEntity = diaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    

    /**
     * Prueba para eliminar una Dia.
     */
    @Test
    public void deleteDiaTest() {
        DiaEntity entity = data.get(0);
        diaPersistence.delete(entity.getId());
        DiaEntity deleted = em.find(DiaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
