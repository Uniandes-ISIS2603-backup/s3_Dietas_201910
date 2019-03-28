/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;


import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.persistence.CalificacionYComentarioPersistence;
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
 * @author Andrea Montoya Serje
 */
@RunWith(Arquillian.class)
public class CalificacionYComentarioPersistenceTest 
{
     @Inject
   private CalificacionYComentarioPersistence  calificacionYcomentario;
     
       @Inject
    UserTransaction utx;
  
     
     @PersistenceContext
     private EntityManager em;
    private List<CalificacionYComentarioEntity> data = new ArrayList<CalificacionYComentarioEntity>(); 
     
     
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(CalificacionYComentarioEntity.class.getPackage())
               .addPackage(CalificacionYComentarioPersistence.class.getPackage())
               .addAsManifestResource("META-INf/persistence.xml","persistence.xml")
               .addAsManifestResource("META-INF/beans.xml","beans.xml");
   }
   
   
   /**
     *  prueba para crear una calificacion y comentario.
     */
   @Test
   public void createCalificacionYComentarioTest(){
       PodamFactory factory= new PodamFactoryImpl();
       CalificacionYComentarioEntity newEntity= factory.manufacturePojo(CalificacionYComentarioEntity.class);
       CalificacionYComentarioEntity result= calificacionYcomentario.create(newEntity);
       Assert.assertNotNull(result);
       
       
   }
   
   
    /**
     *  prueba para crear una entidad de calificacion y comentario.
     */
   @Test
    public void createCalificacionYComentarioEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    CalificacionYComentarioEntity newEntity = factory.manufacturePojo(CalificacionYComentarioEntity.class);
    CalificacionYComentarioEntity result = calificacionYcomentario.create(newEntity);

    Assert.assertNotNull(result);
    CalificacionYComentarioEntity entity = em.find(CalificacionYComentarioEntity.class, result.getId());
    Assert.assertNotNull(entity);
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
        em.createQuery("delete from SuspensionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
           CalificacionYComentarioEntity entity = factory.manufacturePojo(CalificacionYComentarioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    
    
//     /**
//     * Prueba para consultar la lista de calificacionesycomentarioss.
//     */
//    @Test
//    public void getCalificacionesYComentariosTest() {
//        List<CalificacionYComentarioEntity> list = calificacionYcomentario.findAll();
//        Assert.assertEquals(data.size(), list.size());
//        for (CalificacionYComentarioEntity ent : list) {
//            boolean found = false;
//            for (CalificacionYComentarioEntity entity : data) {
//                if (ent.getId().equals(entity.getId())) {
//                    found = true;
//                }
//            }
//            Assert.assertTrue(found);
//        }
//    }
    
    
    @Test
    public void getCalificacionYComentarioTest() {
        CalificacionYComentarioEntity entity = data.get(0);
        CalificacionYComentarioEntity newEntity = calificacionYcomentario.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getCalificacion(), newEntity.getCalificacion());
    }
    
    
      /**
     * Prueba para eliminar una calificacion y comentario.
     */
    @Test
    public void deleteCalificacionYComentarioTest() {
        CalificacionYComentarioEntity entity = data.get(0);
        calificacionYcomentario.delete(entity.getId());
        CalificacionYComentarioEntity deleted = em.find(CalificacionYComentarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
    
   
   
   
   
   
   
   
   
   
   
   
   
   
    
}
