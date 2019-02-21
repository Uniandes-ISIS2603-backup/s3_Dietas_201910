/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.QuejaYReclamoLogic;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import co.edu.uniandes.csw.dietas.persistence.QuejaYReclamoPersistence;
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
public class QuejaYReclamoLogicTest {
    @Inject
   private QuejaYReclamoLogic quejaYReclamoLogic;
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
    PodamFactory factory= new PodamFactoryImpl();
         /**
     * Lista que tiene los datos de prueba.
     */
    private List<QuejaYReclamoEntity> data = new ArrayList<QuejaYReclamoEntity>();
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(QuejaYReclamoEntity.class.getPackage())
               .addPackage(QuejaYReclamoLogic.class.getPackage())
               .addPackage(QuejaYReclamoPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
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
        em.createQuery("delete from QuejaYReclamoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            QuejaYReclamoEntity entity = factory.manufacturePojo(QuejaYReclamoEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
   @Test
   public void createPersonaTest()throws BusinessLogicException{
             

       QuejaYReclamoEntity newEntity= factory.manufacturePojo(QuejaYReclamoEntity.class);
       QuejaYReclamoEntity result= quejaYReclamoLogic.createQuejaYReclamo(newEntity);
       Assert.assertNotNull(result);
       PersonaEntity entity= em.find(PersonaEntity.class, result.getId());
       Assert.assertEquals(newEntity.getId(), entity.getId());
      
   }
 @Test
   public void createPersonaConMismoIdTest()throws BusinessLogicException{
      
       QuejaYReclamoEntity newEntity= factory.manufacturePojo(QuejaYReclamoEntity.class);
       newEntity.setId(data.get(0).getId());
       quejaYReclamoLogic.createQuejaYReclamo(newEntity);
   }
   }

