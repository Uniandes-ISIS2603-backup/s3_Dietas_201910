/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;


import co.edu.uniandes.csw.dietas.ejb.FotoLogic;
import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.FotoPersistence;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.junit.runner.RunWith;

/**
 *
 * @author Louis Gualtero
 */
@RunWith(Arquillian.class)
public class FotoLogicTest {
    
      private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Inyección de la dependencia a la clase FotoLogic cuyos métodos se
     * van a probar.
     */
    @Inject
    private FotoLogic fotoLogic;
    
    
     /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
     /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    private UserTransaction utx;
    
     /**
     * Lista que tiene los datos de prueba.
     */
    private List<FotoEntity> data = new ArrayList<FotoEntity>();
    
    
     /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FotoEntity.class.getPackage())
                .addPackage(FotoLogic.class.getPackage())
                .addPackage(FotoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
        em.createQuery("delete from FotoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            FotoEntity entity = factory.manufacturePojo(FotoEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
    
     /**
     * Prueba para crear un Foto.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test
    public void createFotoTest() throws BusinessLogicException {
        FotoEntity newEntity = factory.manufacturePojo(FotoEntity.class);
        FotoEntity result = fotoLogic.createFoto(newEntity);
        Assert.assertNotNull(result);
        FotoEntity entity = em.find(FotoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }
    
    /**
     * Prueba para crear un Foto con el mismo nombre de un Foto que ya
     * existe.
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createFotoConMismoNombreTest() throws BusinessLogicException {
        FotoEntity newEntity = factory.manufacturePojo(FotoEntity.class);
        newEntity.setNombre(data.get(0).getNombre());
        fotoLogic.createFoto(newEntity);
    }
      /**
     * Prueba para consultar la lista de Fotos.
     */
    @Test
    public void getFotosTest() {
        List<FotoEntity> list = fotoLogic.getFotos();
        Assert.assertEquals(data.size(), list.size());
        for (FotoEntity entity : list) {
            boolean found = false;
            for (FotoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar un Foto.
     */
    @Test
    public void getFotoTest() {
        FotoEntity entity = data.get(0);
        FotoEntity resultEntity = fotoLogic.getFoto(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
    }
    /**
     * Prueba para actualizar una Foto.
     */
    @Test
    public void updateFotoTest() {
        FotoEntity entity = data.get(0);
        FotoEntity pojoEntity = factory.manufacturePojo(FotoEntity.class);

        pojoEntity.setId(entity.getId());

        fotoLogic.updateFoto(pojoEntity.getId(), pojoEntity);

        FotoEntity resp = em.find(FotoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getUrl(), resp.getUrl());
    }
    
    /**
     * Prueba para eliminar una Foto
     *
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @Test
    public void deleteFotoTest() throws BusinessLogicException {
        FotoEntity entity = data.get(0);
        fotoLogic.deleteFoto(entity.getId());
        FotoEntity deleted = em.find(FotoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
