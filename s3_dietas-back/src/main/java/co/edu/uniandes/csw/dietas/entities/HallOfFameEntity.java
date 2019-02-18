/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.OneToMany;

/**
 *
 * @author  Louis Gualtero.
 */
@Entity
public class HallOfFameEntity extends BaseEntity implements Serializable{
    
    
    @PodamExclude
    @OneToMany(mappedBy = "halls")
    private List<PersonaEntity> personas = new ArrayList<>();
    
    public HallOfFameEntity(){
        
    }
    
    /**
     * Mensaje en Hall Of Fame 
     */
    private String mensaje;

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
