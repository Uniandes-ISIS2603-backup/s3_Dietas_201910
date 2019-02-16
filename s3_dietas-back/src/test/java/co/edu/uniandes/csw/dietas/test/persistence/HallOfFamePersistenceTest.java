/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Louis  Gualtero.
 */
@RunWith(Arquillian.class)
public class HallOfFamePersistenceTest {
    
     /**
     * Inyección de la dependencia a la clase ComidaPersistence cuyos métodos
     * se van a probar.
     */
      @Inject
      private HallOfFamePersistence hallOfFamePersistence;
      
      @PersistenceContext
      private EntityManager em;
      
      
      private List<HallOfFameEntity> data = new ArrayList<>();
      
       @Deployment
     public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HallOfFameEntity.class.getPackage())
                .addPackage(HallOfFamePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
     
     @Test
  public void createPersistenceTest(){
      PodamFactory factory = new PodamFactoryImpl();
        HallOfFameEntity newEntity = factory.manufacturePojo(HallOfFameEntity.class);
        
        System.out.print(newEntity.getId());
        System.out.print(hallOfFamePersistence.toString());
        HallOfFameEntity result = hallOfFamePersistence.create(newEntity);
        System.out.print(newEntity.getId());
        Assert.assertNotNull(result);
  }
  
   /**
     * Prueba para consultar la lista de Halls of fame.
     */
  @Test
  public void getHallsTest(){
      List <HallOfFameEntity> list = hallOfFamePersistence.findAll();
       Assert.assertEquals(data.size(), list.size());
        for (HallOfFameEntity ent : list) {
            boolean found = false;
            for (HallOfFameEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
  }
  
    /**
     * Prueba para consultar un hall.
    
    @Test
    public void geHallTest() {
        HallOfFameEntity entity = data.get(0);
        HallOfFameEntity newEntity = hallOfFamePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getMensaje(), newEntity.getMensaje());
    }
 */
  
  /**
     * Prueba para actualizar un Hall.
    
    @Test
    public void updateHallTest() {
        HallOfFameEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        HallOfFameEntity newEntity = factory.manufacturePojo(HallOfFameEntity.class);

        newEntity.setId(entity.getId());

        hallOfFamePersistence.update(newEntity);

        HallOfFameEntity resp = em.find(HallOfFameEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
 */
  
   /**
     * Prueba para eliminar un Hall.
    
    @Test
    public void deleteHallTest() {
        HallOfFameEntity entity = data.get(0);
        hallOfFamePersistence.delete(entity.getId());
        HallOfFameEntity deleted = em.find(HallOfFameEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
     */
}
