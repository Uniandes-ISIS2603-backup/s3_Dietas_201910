/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.persistence.ComidaPersistence;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author  Louis Gualtero.
 */
@RunWith(Arquillian.class)
public class ComidaPersistenceTest {
      
      /**
     * Inyección de la dependencia a la clase ComidaPersistence cuyos métodos
     * se van a probar.
     */
      @Inject
      private ComidaPersistence comidaPersistence;
      
      @PersistenceContext
      private EntityManager em;
      
      private List<ComidaEntity> data = new ArrayList<>();
      
      
      
  @Deployment
  public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComidaEntity.class.getPackage())
                .addPackage(ComidaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
  
  
  @Test
  public void createPersistenceTest(){
      PodamFactory factory = new PodamFactoryImpl();
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        
        System.out.print(newEntity.getId());
        System.out.print(comidaPersistence.toString());
        ComidaEntity result = comidaPersistence.create(newEntity);
System.out.print(newEntity.getId());
        Assert.assertNotNull(result);
  }
  
   /**
     * Prueba para consultar la lista de Comidas.
     */
    @Test
    public void getAuthorsTest() {
        List<ComidaEntity> list = comidaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ComidaEntity ent : list) {
            boolean found = false;
            for (ComidaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Comida.
     
    @Test
    public void getComdaTest() {
        ComidaEntity entity = data.get(0);
        ComidaEntity newEntity = comidaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getAlimentosYCantidad(), newEntity.getAlimentosYCantidad());
    }
    */
    
    
    /**
     * Prueba para actualizar un Comida.
     
    @Test
    public void updateComidaTest() {
        ComidaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);

        newEntity.setId(entity.getId());

        comidaPersistence.update(newEntity);

        ComidaEntity resp = em.find(ComidaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
    */
    
    /**
     * Prueba para eliminar un Comida.
    
    @Test
    public void deleteComidaTest() {
        ComidaEntity entity = data.get(0);
        comidaPersistence.delete(entity.getId());
        ComidaEntity deleted = em.find(ComidaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    */
}
