/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author estudiante
 */
@Entity
public class DiaEntity extends BaseEntity implements Serializable {

     private boolean especial;
    /**
     * @return the especial
     */
    public boolean isEspecial() {
        return especial;
    }

    /**
     * @param especial the especial to set
     */
    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
   
    
    
    
}
