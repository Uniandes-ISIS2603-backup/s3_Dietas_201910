/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.DiaLogic;
import co.edu.uniandes.csw.dietas.entities.DiaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.DiaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
 * @author Juan Antonio Restrepo
 */
@RunWith(Arquillian.class)
public class DiaLogicTest {
     @Inject
    private DiaLogic diaLogic;
    
      private PodamFactory factory = new PodamFactoryImpl();

    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<DiaEntity> data = new ArrayList<DiaEntity>();
    
     @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(DiaEntity.class.getPackage())
               .addPackage(DiaPersistence.class.getPackage())
               .addPackage(DiaLogic.class.getPackage())
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
        em.createQuery("delete from DiaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            DiaEntity entity = factory.manufacturePojo(DiaEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
   
   
   
     @Test
     public void createDiaTest() throws BusinessLogicException{
         
       DiaEntity newEntity= factory.manufacturePojo(DiaEntity.class);
       DiaEntity result= diaLogic.createDia(newEntity);
       Assert.assertNotNull(result);
      DiaEntity entity = em.find(DiaEntity.class, result.getId());
      Assert.assertEquals(newEntity.getId(), entity.getId());
      
   }
     
     
     @Test (expected = BusinessLogicException.class)
     public void createDiaConMismoIdTest() throws BusinessLogicException
     {   
         DiaEntity newEntity = factory.manufacturePojo(DiaEntity.class);
         newEntity.setId(data.get(0).getId());
         diaLogic.createDia(newEntity);
     }      
    
    
}
