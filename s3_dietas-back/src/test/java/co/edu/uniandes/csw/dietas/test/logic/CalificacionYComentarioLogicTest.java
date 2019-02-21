/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.CalificacionYComentarioLogic;
import co.edu.uniandes.csw.dietas.ejb.SuspensionLogic;
import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.CalificacionYComentarioPersistence;
import co.edu.uniandes.csw.dietas.persistence.SuspensionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
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
public class CalificacionYComentarioLogicTest
{
     @Inject
    private CalificacionYComentarioLogic calificacionYcomentarioLogic;
    
      private PodamFactory factory = new PodamFactoryImpl();

    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<CalificacionYComentarioEntity> data = new ArrayList<CalificacionYComentarioEntity>();
    
     @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(CalificacionYComentarioEntity.class.getPackage())
               .addPackage(CalificacionYComentarioPersistence.class.getPackage())
               .addPackage(CalificacionYComentarioLogic.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   
   
       @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from CalificacionYComentarioEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CalificacionYComentarioEntity entity = factory.manufacturePojo(CalificacionYComentarioEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
   
   
   
      
     @Test
     public void createCalificacionYComentarioTest() throws BusinessLogicException{
         
       CalificacionYComentarioEntity newEntity= factory.manufacturePojo(CalificacionYComentarioEntity.class);
       CalificacionYComentarioEntity result= calificacionYcomentarioLogic.createCalificacionYComentario(newEntity);
       Assert.assertNotNull(result);
      CalificacionYComentarioEntity entity = em.find(CalificacionYComentarioEntity.class, result.getId());
      Assert.assertEquals(newEntity.getId(), entity.getId());
      
   }
     
     
     @Test(expected = BusinessLogicException.class)
     public void createCalificacionYComentarioConMismoIdTest() throws BusinessLogicException
     {   
         CalificacionYComentarioEntity newEntity = factory.manufacturePojo(CalificacionYComentarioEntity.class);
         newEntity.setId(data.get(0).getId());
         calificacionYcomentarioLogic.createCalificacionYComentario(newEntity);
     }
   
}
