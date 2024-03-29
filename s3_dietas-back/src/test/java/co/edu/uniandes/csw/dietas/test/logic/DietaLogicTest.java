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

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(DietaEntity.class.getPackage())
                 .addPackage(DietaLogic.class.getPackage())
                 .addPackage(DietaPersistence.class.getPackage())
                 .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                 .addAsManifestResource("META-INF/beans.xml","beans.xml");
     }
     
     /**
     * Configuración inicial de la prueba.
     */
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
        em.createQuery("delete from DietaEntity").executeUpdate();
    }
     
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             DietaEntity entity = factory.manufacturePojo(DietaEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     /**
     * Prueba para crear una Dieta.
     */
     @Test
     public void createDietaTest() throws BusinessLogicException{
         DietaEntity newEntity = factory.manufacturePojo(DietaEntity.class);
         DietaEntity result = dietaLogic.createDieta(newEntity);
         Assert.assertNotNull(result);
         DietaEntity entity = em.find(DietaEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
         Assert.assertEquals(newEntity.getObjetivo(), entity.getObjetivo());
     } 
     
     /**
     * Prueba para crear una Dieta con el mismo id.
     */
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

     /**
     * Prueba para consultar la lista de Pagos.
     */
    @Test
    public void getAuthorsTest() {
        List<DietaEntity> list = dietaLogic.getDietas();
        Assert.assertEquals(data.size(), list.size());
        for (DietaEntity entity : list) {
            boolean found = false;
            for (DietaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Pago.
     */
    @Test
    public void getAuthorTest() {
        DietaEntity entity = data.get(0);
        DietaEntity resultEntity = dietaLogic.getDieta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
    }
     
    /**
     * Prueba para actualizar una Dieta.
     */
    @Test
    public void updateDietaTest() {
        DietaEntity entity = data.get(0);
        DietaEntity pojoEntity = factory.manufacturePojo(DietaEntity.class);

        pojoEntity.setId(entity.getId());

        dietaLogic.updateDieta(pojoEntity.getId(), pojoEntity);

        DietaEntity resp = em.find(DietaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getObjetivo(), resp.getObjetivo());
    }

    /**
     * Prueba para eliminar una Dieta
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test
    public void deleteDietaTest() throws BusinessLogicException {
        DietaEntity entity = data.get(0);
        dietaLogic.deleteDieta(entity.getId());
        DietaEntity deleted = em.find(DietaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}

