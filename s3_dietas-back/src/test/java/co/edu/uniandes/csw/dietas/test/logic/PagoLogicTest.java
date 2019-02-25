/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.PagoLogic;
import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PagoPersistence;
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
public class PagoLogicTest {
    @Inject
    private PagoLogic pagoLogic;
    private PodamFactory factory = new PodamFactoryImpl();
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<PagoEntity> data = new ArrayList<PagoEntity>();

    
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(PagoEntity.class.getPackage())
                 .addPackage(PagoLogic.class.getPackage())
                 .addPackage(PagoPersistence.class.getPackage())
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
        em.createQuery("delete from PagoEntity").executeUpdate();
    }
     
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             PagoEntity entity = factory.manufacturePojo(PagoEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     @Test
     public void createPagoTest() throws BusinessLogicException{
         PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
         PagoEntity result = pagoLogic.createPago(newEntity);
         Assert.assertNotNull(result);
         PagoEntity entity = em.find(PagoEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
         Assert.assertEquals(newEntity.getModoPago(), entity.getModoPago());
     } 
     
     @Test(expected = BusinessLogicException.class)
     public void createPagoConMismoModo()throws BusinessLogicException{
         PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
         newEntity.setModoPago(data.get(0).getModoPago());
         pagoLogic.createPago(newEntity);
     }
}
