/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import co.edu.uniandes.csw.dietas.persistence.DiaPersistance;
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
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class DiaPersistanceTest {
    @Inject 
    private DiaPersistance diaPersistence;
    
    @PersistenceContext
     private EntityManager em;
    
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
}
