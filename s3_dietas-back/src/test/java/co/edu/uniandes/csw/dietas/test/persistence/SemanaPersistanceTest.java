/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.persistence.SemanaPersistance;
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
 * @author Juan Antonio Restrepo
 */

@RunWith(Arquillian.class)
public class SemanaPersistanceTest {
    
    @Inject 
    private SemanaPersistance semanaPersistence;
    
    @PersistenceContext
     private EntityManager em;
    
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(SemanaEntity.class.getPackage())
                 .addPackage(SemanaPersistance.class.getPackage())
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
    
}
