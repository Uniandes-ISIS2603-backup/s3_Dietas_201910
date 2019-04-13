/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.logic;

import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
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
 * @author Daniel Espitia
 */

@RunWith(Arquillian.class)
public class PersonaLogicTest {
@Inject
    private PersonaLogic personaLogic;
    private PodamFactory factory = new PodamFactoryImpl();
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<PersonaEntity> data = new ArrayList<PersonaEntity>();

    
    @Deployment
     public static JavaArchive createDeployment(){
         return ShrinkWrap.create(JavaArchive.class)
                 .addPackage(PersonaEntity.class.getPackage())
                 .addPackage(PersonaLogic.class.getPackage())
                 .addPackage(PersonaPersistence.class.getPackage())
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
        em.createQuery("delete from PersonaEntity").executeUpdate();
    }
     
     private void insertData(){
         for (int i = 0; i < 3; i++) {
             PersonaEntity entity = factory.manufacturePojo(PersonaEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     @Test
     public void createPersonaTest() throws BusinessLogicException{
         PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);
         PersonaEntity result = personaLogic.createPersona(newEntity);
         Assert.assertNotNull(result);
         PersonaEntity entity = em.find(PersonaEntity.class, result.getId());
         Assert.assertEquals(newEntity.getId(), entity.getId());
       
     } 
     
     @Test(expected = BusinessLogicException.class)
     public void createPersonaConMismoId()throws BusinessLogicException{
         PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);
         newEntity.setId(data.get(0).getId());
         personaLogic.createPersona(newEntity);
     }
      /**
     * Prueba para consultar la lista de personas.
     */
    @Test
    public void getPersonasTest() {
        List<PersonaEntity> list = personaLogic.getPersonas();
        Assert.assertEquals(data.size(), list.size());
        for (PersonaEntity entity : list) {
            boolean found = false;
            for (PersonaEntity storedEntity : data) {
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
    public void getPersonaTest() {
        PersonaEntity entity = data.get(0);
        PersonaEntity resultEntity = personaLogic.getPersona(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
 
    }
     
     /**
     * Prueba para actualizar un Pago.
     */
    @Test
    public void updatePersonaTest() {
        PersonaEntity entity = data.get(0);
        PersonaEntity pojoEntity = factory.manufacturePojo(PersonaEntity.class);

        pojoEntity.setId(entity.getId());

        personaLogic.updatePersona(pojoEntity.getId(), pojoEntity);

        PersonaEntity resp = em.find(PersonaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }

    /**
     * Prueba para eliminar un Pago
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void deletePersonaTest() throws BusinessLogicException {
        PersonaEntity entity = data.get(0);
        personaLogic.deletePersona(entity.getId());
        PersonaEntity deleted = em.find(PersonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

   }


