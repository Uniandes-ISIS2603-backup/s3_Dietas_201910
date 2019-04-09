/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;


import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.persistence.SuspensionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author Andrea Montoya Serje
 */
@RunWith(Arquillian.class)
public class SuspensionPersistenceTest {
   
    @Inject
   private SuspensionPersistence suspension;
     
    
    @Inject
    UserTransaction utx;
  
     
     @PersistenceContext
     private EntityManager em;
    private List<SuspensionEntity> data = new ArrayList<SuspensionEntity>(); 
    
     
     @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(SuspensionEntity.class.getPackage())
               .addPackage(SuspensionPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   @Test
   public void createSuspensionTest(){
       PodamFactory factory= new PodamFactoryImpl();
       SuspensionEntity newEntity= factory.manufacturePojo(SuspensionEntity.class);
       SuspensionEntity result= suspension.create(newEntity);
       Assert.assertNotNull(result);
       
       
   }
   
   
    @Test
    public void createSuspensionEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    SuspensionEntity newEntity = factory.manufacturePojo(SuspensionEntity.class);
    SuspensionEntity result = suspension.create(newEntity);

    Assert.assertNotNull(result);
    SuspensionEntity entity = em.find(SuspensionEntity.class, result.getId());
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
        em.createQuery("delete from SuspensionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SuspensionEntity entity = factory.manufacturePojo(SuspensionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    
    
     /**
     * Prueba para consultar la lista de suspensiones.
     */
    @Test
    public void getSuspensionesTest() {
        List<SuspensionEntity> list = suspension.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (SuspensionEntity ent : list) {
            boolean found = false;
            for (SuspensionEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getSuspensionTest() {
        SuspensionEntity entity = data.get(0);
        SuspensionEntity newEntity = suspension.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getNumDias(), newEntity.getNumDias());
    }
    
    
      /**
     * Prueba para eliminar una Suspension.
     */
    @Test
    public void deleteSuspensionTest() {
        SuspensionEntity entity = data.get(0);
        suspension.delete(entity.getId());
        SuspensionEntity deleted = em.find(SuspensionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
    
    
}
