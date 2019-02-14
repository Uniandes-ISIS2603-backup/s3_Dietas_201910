/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.persistence.ComidaPersistence;
import co.edu.uniandes.csw.dietas.persistence.HallOfFamePersistence;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
    
}
