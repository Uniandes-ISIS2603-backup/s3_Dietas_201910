/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;



import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.persistence.FotoPersistence;
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
 * @author Louis Gualtero
 */
@RunWith(Arquillian.class)
public class FotoPersistenceTest {
        /**
     * Inyección de la dependencia a la clase FotoPersistence cuyos métodos
     * se van a probar.
     */
      @Inject
      private FotoPersistence fotoPersistence;
      
      @PersistenceContext
      private EntityManager em;
      
      private List<FotoEntity> data = new ArrayList<>();
          
  @Deployment
  public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FotoEntity.class.getPackage())
                .addPackage(FotoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
   
  @Test
  public void createPersistenceTest(){
      PodamFactory factory = new PodamFactoryImpl();
        FotoEntity newEntity = factory.manufacturePojo(FotoEntity.class);
        
        System.out.print(newEntity.getId());
        System.out.print(fotoPersistence.toString());
        FotoEntity result = fotoPersistence.create(newEntity);
System.out.print(newEntity.getId());
        Assert.assertNotNull(result);
  }
  
   /**
     * Prueba para consultar la lista de Fotos.
     */
    @Test
    public void getFotosTest() {
        List<FotoEntity> list = fotoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (FotoEntity ent : list) {
            boolean found = false;
            for (FotoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
       /**
     * Prueba para consultar un Foto.
     
    @Test
    public void getComdaTest() {
        FotoEntity entity = data.get(0);
        FotoEntity newEntity = fotoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getAlimentosYCantidad(), newEntity.getAlimentosYCantidad());
    }
    */
    
    
    /**
     * Prueba para actualizar un Foto.
     
    @Test
    public void updateFotoTest() {
        FotoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        FotoEntity newEntity = factory.manufacturePojo(FotoEntity.class);

        newEntity.setId(entity.getId());

        fotoPersistence.update(newEntity);

        FotoEntity resp = em.find(FotoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
    */
    
    /**
     * Prueba para eliminar un Foto.
    
    @Test
    public void deleteFotoTest() {
        FotoEntity entity = data.get(0);
        fotoPersistence.delete(entity.getId());
        FotoEntity deleted = em.find(FotoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    */
}
