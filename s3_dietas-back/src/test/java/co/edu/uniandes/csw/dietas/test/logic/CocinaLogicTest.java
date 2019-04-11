/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.CocinaLogic;
import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.CocinaPersistence;
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
public class CocinaLogicTest
{
     @Inject
    private CocinaLogic cocinaLogic;
    
      private PodamFactory factory = new PodamFactoryImpl();

    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<CocinaEntity> data = new ArrayList<CocinaEntity>();
    
     @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(CocinaEntity.class.getPackage())
               .addPackage(CocinaPersistence.class.getPackage())
               .addPackage(CocinaLogic.class.getPackage())
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
        em.createQuery("delete from CocinaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CocinaEntity entity = factory.manufacturePojo(CocinaEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
   
   
   
     @Test
     public void createCocinaTest() throws BusinessLogicException{
         
       CocinaEntity newEntity= factory.manufacturePojo(CocinaEntity.class);
       CocinaEntity result= cocinaLogic.createCocina(newEntity);
       Assert.assertNotNull(result);
      CocinaEntity entity = em.find(CocinaEntity.class, result.getId());
      Assert.assertEquals(newEntity.getId(), entity.getId());
      
   }
     
     
     @Test(expected = BusinessLogicException.class)
     public void createCocinaConMismoIdTest() throws BusinessLogicException
     {   
         CocinaEntity newEntity = factory.manufacturePojo(CocinaEntity.class);
         newEntity.setId(data.get(0).getId());
         cocinaLogic.createCocina(newEntity);
     }
     
   
     
     
     
      /**
     * Prueba para consultar la lista de Cocinas.
     */
    @Test
    public void getCocinasTest() {
        List<CocinaEntity> list = cocinaLogic.getCocinas();
        Assert.assertEquals(data.size(), list.size());
        for (CocinaEntity entity : list) {
            boolean found = false;
            for (CocinaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
    
    /**
     * Prueba para consultar una Cocina.
     */
    @Test
    public void getCocinaTest() {
        CocinaEntity entity = data.get(0);
        CocinaEntity resultEntity = cocinaLogic.getCocina(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getDireccion(), resultEntity.getDireccion());
    }
    
    
    
     /**
     * Prueba para actualizar una Cocina.
     */
    @Test
    public void updateCocinaTest() {
        CocinaEntity entity = data.get(0);
        CocinaEntity pojoEntity = factory.manufacturePojo(CocinaEntity.class);
        pojoEntity.setId(entity.getId());
        cocinaLogic.updateCocina(pojoEntity.getId(), pojoEntity);
        CocinaEntity resp = em.find(CocinaEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getDireccion(), resp.getDireccion());
    }
    
    
        /**
     * Prueba para eliminar una Cocina
     *
     * @throws BusinessLogicException
     */
    @Test
    public void deleteCocinaTest() throws BusinessLogicException {
        CocinaEntity entity = data.get(0);
        cocinaLogic.deleteCocina(entity.getId());
        CocinaEntity deleted = em.find(CocinaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     
     
     
     
   
}
