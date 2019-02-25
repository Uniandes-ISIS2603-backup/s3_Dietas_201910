/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.QuejaYReclamoLogic;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.QuejaYReclamoPersistence;
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
 * @author estudiante
 */
@RunWith (Arquillian.class)
public class QuejaYReclamoLogicTest {
    @Inject
    private QuejaYReclamoLogic quejaYReclamoLogic;
    private PodamFactory factory = new PodamFactoryImpl();
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<QuejaYReclamoEntity> data = new ArrayList<QuejaYReclamoEntity>();

    
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(QuejaYReclamoEntity.class.getPackage())
                 .addPackage(QuejaYReclamoLogic.class.getPackage())
                 .addPackage(QuejaYReclamoPersistence.class.getPackage())
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
        em.createQuery("delete from QuejaYReclamoEntity").executeUpdate();
    }
     
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             QuejaYReclamoEntity entity = factory.manufacturePojo(QuejaYReclamoEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     @Test
     public void createQuejaYReclamoTest() throws BusinessLogicException{
         QuejaYReclamoEntity newEntity = factory.manufacturePojo(QuejaYReclamoEntity.class);
         QuejaYReclamoEntity result = quejaYReclamoLogic.createQuejaYReclamo(newEntity);
         Assert.assertNotNull(result);
         QuejaYReclamoEntity entity = em.find(QuejaYReclamoEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
         
     } 
     
     @Test(expected = BusinessLogicException.class)
     public void createDietaConMismoId()throws BusinessLogicException{
         QuejaYReclamoEntity newEntity = factory.manufacturePojo(QuejaYReclamoEntity.class);
         newEntity.setId(data.get(0).getId());
         quejaYReclamoLogic.createQuejaYReclamo(newEntity);
     }
}

