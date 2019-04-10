/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;


import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;

import co.edu.uniandes.csw.dietas.persistence.QuejaYReclamoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Daniel Espitia
 */
@RunWith(Arquillian.class)
public class QuejaYReclamoPersistenceTest {
    
    @Inject
   private QuejaYReclamoPersistence quejita;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;

    private List<QuejaYReclamoEntity> data = new ArrayList<QuejaYReclamoEntity>();
    
    /**
     * Configuración inicial de la prueba.
     */
     @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from QuejaYReclamoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            QuejaYReclamoEntity entity = factory.manufacturePojo(QuejaYReclamoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
     
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(QuejaYReclamoEntity.class.getPackage())
               .addPackage(QuejaYReclamoPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   @Test
   public void createQuejaYReclamoTest()
   {PodamFactory factory = new PodamFactoryImpl();
         QuejaYReclamoEntity newEntity = factory.manufacturePojo(QuejaYReclamoEntity.class);
         System.out.print(newEntity);
         QuejaYReclamoEntity result = quejita.create(newEntity);
       
         Assert.assertNotNull(result);
         QuejaYReclamoEntity entity = em.find(QuejaYReclamoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getEspecificacion(), entity.getEspecificacion());             
   }
   
    /**
     * Prueba para consultar la lista de quejas.
     */
    @Test
    public void getQuejasYReclamosTest() {
        List<QuejaYReclamoEntity> list = quejita.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (QuejaYReclamoEntity ent : list) {
            boolean found = false;
            for (QuejaYReclamoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una queja.
     */
    @Test
    public void getQuejaYReclamoTest() {
        QuejaYReclamoEntity entity = data.get(0);
        QuejaYReclamoEntity newEntity = quejita.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getEspecificacion(), newEntity.getEspecificacion());
    }

    /**
     * Prueba para actualizar una queja.
     */
    @Test
    public void updateQuejaYReclamoTest() {
        QuejaYReclamoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        QuejaYReclamoEntity newEntity = factory.manufacturePojo(QuejaYReclamoEntity.class);

        newEntity.setId(entity.getId());

        quejita.update(newEntity);

        QuejaYReclamoEntity resp = em.find(QuejaYReclamoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getEspecificacion(), resp.getEspecificacion());
    }

    /**
     * Prueba para eliminar una queja.
     */
    @Test
    public void deleteQuejaYReclamoTest() {
        QuejaYReclamoEntity entity = data.get(0);
        quejita.delete(entity.getId());
        QuejaYReclamoEntity deleted = em.find(QuejaYReclamoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
   
}
