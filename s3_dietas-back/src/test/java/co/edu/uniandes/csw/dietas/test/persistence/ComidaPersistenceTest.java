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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
  
  
   
}
