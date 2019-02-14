/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author Alejandra Bravo
 */
@RunWith(Arquillian.class)
public class DietaPersistenceTest {
     @Inject
     private DietaPersistence dietaPersistence;
     
     @PersistenceContext
     private EntityManager em;
     
     @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(DietaEntity.class.getPackage())
                 .addPackage(DietaPersistence.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     @Test
     public void createDietaTest(){
         PodamFactory factory = new PodamFactoryImpl();
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         System.out.print(newEntity);
         DietaEntity result = dietaPersistence.create(newEntity);
       
         Assert.assertNotNull(result);
     }
}  
