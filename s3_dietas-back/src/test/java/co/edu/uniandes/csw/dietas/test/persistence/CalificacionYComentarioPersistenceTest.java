/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;


import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.persistence.CalificacionYComentarioPersistence;
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
public class CalificacionYComentarioPersistenceTest 
{
     @Inject
   private CalificacionYComentarioPersistence  calificacionYcometario;
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(CalificacionYComentarioEntity.class.getPackage())
               .addPackage(CalificacionYComentarioPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   @Test
   public void createCalificacionYComentarioTest(){
       PodamFactory factory= new PodamFactoryImpl();
       CalificacionYComentarioEntity newEntity= factory.manufacturePojo(CalificacionYComentarioEntity.class);
       CalificacionYComentarioEntity result= calificacionYcometario.create(newEntity);
       Assert.assertNotNull(result);
       
       
   }
    
}
