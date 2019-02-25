/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.TipoDietaLogic;
import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
public class TipoDietaLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();
   
    @Inject
    private TipoDietaLogic tipoDietaLogic;
    
    
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<TipoDietaEntity> data = new ArrayList<TipoDietaEntity>();
    
     @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(TipoDietaEntity.class.getPackage())
               .addPackage(TipoDietaPersistence.class.getPackage())
               .addPackage(TipoDietaLogic.class.getPackage())
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
        em.createQuery("delete from TipoDietaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            TipoDietaEntity entity = factory.manufacturePojo(TipoDietaEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
   
   
   
//     @Test
//     public void createTipoDietaTest() throws BusinessLogicException{
//      
//        TipoDietaEntity newEntity = factory.manufacturePojo(TipoDietaEntity.class);
//        TipoDietaEntity result = tipoDietaLogic.createTipoDieta(newEntity);
//        Assert.assertNotNull(result);
//        TipoDietaEntity entity = em.find(TipoDietaEntity.class, result.getId());
//        Assert.assertEquals(newEntity.getId(), entity.getId());
//   }
//     
//     
//     @Test //(expected = BusinessLogicException.class)
//     public void createTipoDietaConMismoIdTest() throws BusinessLogicException
//     {   
//         TipoDietaEntity newEntity = factory.manufacturePojo(TipoDietaEntity.class);
//         newEntity.setId(data.get(0).getId());
//         tipoDietaLogic.createTipoDieta(newEntity);
//     }
}
