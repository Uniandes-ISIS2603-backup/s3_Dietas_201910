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

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(PagoEntity.class.getPackage())
                 .addPackage(PagoLogic.class.getPackage())
                 .addPackage(PagoPersistence.class.getPackage())
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
        em.createQuery("delete from PagoEntity").executeUpdate();
    }
     
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             PagoEntity entity = factory.manufacturePojo(PagoEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     /**
     * Prueba para crear un Pago.
     */
     @Test
     public void createPagoTest() throws BusinessLogicException{
         PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
         PagoEntity result = pagoLogic.createPago(newEntity);
         Assert.assertNotNull(result);
         PagoEntity entity = em.find(PagoEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
         Assert.assertEquals(newEntity.getModoPago(), entity.getModoPago());
     } 
     
     /**
     * Prueba para crear un Pago.
     */
     @Test(expected = BusinessLogicException.class)
     public void createPagoConMismoModo()throws BusinessLogicException{
         PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
         newEntity.setModoPago(data.get(0).getModoPago());
         pagoLogic.createPago(newEntity);
     }
     
     /**
     * Prueba para consultar la lista de Pagos.
     */
    @Test
    public void getAuthorsTest() {
        List<PagoEntity> list = pagoLogic.getPagos();
        Assert.assertEquals(data.size(), list.size());
        for (PagoEntity entity : list) {
            boolean found = false;
            for (PagoEntity storedEntity : data) {
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
        PagoEntity entity = data.get(0);
        PagoEntity resultEntity = pagoLogic.getPago(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getModoPago(), resultEntity.getModoPago());
    }
     
     /**
     * Prueba para actualizar un Pago.
     */
    @Test
    public void updateAuthorTest() {
        PagoEntity entity = data.get(0);
        PagoEntity pojoEntity = factory.manufacturePojo(PagoEntity.class);

        pojoEntity.setId(entity.getId());

        pagoLogic.updatePago(pojoEntity.getId(), pojoEntity);

        PagoEntity resp = em.find(PagoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getModoPago(), resp.getModoPago());
    }

    /**
     * Prueba para eliminar un Pago
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void deleteAuthorTest() throws BusinessLogicException {
        PagoEntity entity = data.get(0);
        pagoLogic.deletePago(entity.getId());
        PagoEntity deleted = em.find(PagoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
