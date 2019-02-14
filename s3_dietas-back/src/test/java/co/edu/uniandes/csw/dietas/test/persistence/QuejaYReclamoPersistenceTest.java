/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;


import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;

import co.edu.uniandes.csw.dietas.persistence.QuejasYReclamosPersistence;
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
 * @author Daniel Espitia
 */
@RunWith(Arquillian.class)
public class QuejaYReclamoPersistenceTest {
    
    @Inject
   private QuejasYReclamosPersistence quejita;
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(QuejaYReclamoEntity.class.getPackage())
               .addPackage(QuejasYReclamosPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   @Test
   public void createPersonaTest(){
       PodamFactory factory= new PodamFactoryImpl();
       QuejaYReclamoEntity newEntity= factory.manufacturePojo(QuejaYReclamoEntity.class);
       QuejaYReclamoEntity result= quejita.create(newEntity);
       Assert.assertNotNull(result);
       
       
   }
}
