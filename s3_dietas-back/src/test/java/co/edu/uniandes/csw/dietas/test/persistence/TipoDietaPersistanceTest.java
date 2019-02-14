/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.test.persistence;

import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
import co.edu.uniandes.csw.dietas.persistence.TipoDietaPersistance;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author el juancho
 */
@RunWith(Arquillian.class)
public class TipoDietaPersistanceTest {
    @Inject
    private TipoDietaPersistance tipoDietaPersistence;
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
        .addPackage(TipoDietaEntity.class.getPackage())
        .addPackage(TipoDietaPersistance.class.getPackage())
        .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
        .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Test
    public void createEditorialTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TipoDietaEntity newEntity = factory.manufacturePojo(TipoDietaEntity.class);
        TipoDietaEntity result = tipoDietaPersistence.create(newEntity);

        Assert.assertNotNull(result);
    }
}
