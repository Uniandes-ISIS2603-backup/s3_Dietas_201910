/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
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
public class PersonaPersistenceTest {
   @Inject
   private PersonaPersistence personita;
   
      @PersistenceContext
     private EntityManager em;
     
     @Inject
    UserTransaction utx;

   private List<PersonaEntity> data = new ArrayList<PersonaEntity>();
   
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(PersonaEntity.class.getPackage())
               .addPackage(PersonaPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   @Test
   public void createPersonaTest(){
       PodamFactory factory= new PodamFactoryImpl();
       PersonaEntity newEntity= factory.manufacturePojo(PersonaEntity.class);
       PersonaEntity result= personita.create(newEntity);
       Assert.assertNotNull(result);      
   }
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
        em.createQuery("delete from PersonaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
   private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PersonaEntity entity = factory.manufacturePojo(PersonaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
     
    /**
     * Prueba para crear una Dieta.
     */
     @Test
     public void createPersona2Test(){
         PodamFactory factory = new PodamFactoryImpl();
         PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);
         System.out.print(newEntity);
         PersonaEntity result = personita.create(newEntity);
       
         Assert.assertNotNull(result);
         
         PersonaEntity entity = em.find(PersonaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
     }
     
     /**
     * Prueba para consultar la lista de Dietas.
     */
    @Test
    public void getPersonasTest() {
        List<PersonaEntity> list = personita.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PersonaEntity ent : list) {
            boolean found = false;
            for (PersonaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Dieta.
     */
    @Test
    public void getPersonaTest() {
        PersonaEntity entity = data.get(0);
        PersonaEntity newEntity = personita.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        
    }

    /**
     * Prueba para actualizar una Dieta.
     */
    @Test
    public void updatePersonaTest() {
        PersonaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);

        newEntity.setId(entity.getId());

        personita.update(newEntity);

        PersonaEntity resp = em.find(PersonaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Prueba para eliminar una Dieta.
     */
    @Test
    public void deletePersonaTest() {
        PersonaEntity entity = data.get(0);
        personita.delete(entity.getId());
        PersonaEntity deleted = em.find(PersonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
