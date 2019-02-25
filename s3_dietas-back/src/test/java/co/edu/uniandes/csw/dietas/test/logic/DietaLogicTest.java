/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.DietaLogic;
import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
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
 * @author Alejandra Bravo
 */
@RunWith (Arquillian.class)
public class DietaLogicTest {
    
    @Inject
    private DietaLogic dietaLogic;
    private PodamFactory factory = new PodamFactoryImpl();
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<DietaEntity> data = new ArrayList<DietaEntity>();

    
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(DietaEntity.class.getPackage())
                 .addPackage(DietaLogic.class.getPackage())
                 .addPackage(DietaPersistence.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
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
    
    private void clearData() {
        em.createQuery("delete from DietaEntity").executeUpdate();
    }
     
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             DietaEntity entity = factory.manufacturePojo(DietaEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     @Test
     public void createDietaTest() throws BusinessLogicException{
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         DietaEntity result = dietaLogic.createDieta(newEntity);
         Assert.assertNotNull(result);
         DietaEntity entity = em.find(DietaEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
         Assert.assertEquals(newEntity.getObjetivo(), entity.getObjetivo());
     } 
     
     @Test(expected = BusinessLogicException.class)
     public void createDietaConMismoId()throws BusinessLogicException{
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         newEntity.setId(data.get(0).getId());
         dietaLogic.createDieta(newEntity);
     }
     
     @Test(expected = BusinessLogicException.class)
     public void createDietaConMismoNombre()throws BusinessLogicException{
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         newEntity.setNombre(data.get(0).getNombre());
         dietaLogic.createDieta(newEntity);
     }
}
