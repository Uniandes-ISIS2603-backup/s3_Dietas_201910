/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Juan Antonio Restrepo
 */@Entity
public class DiaEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany(mappedBy = "dia")
    private List<ComidaEntity> comidas = new ArrayList<ComidaEntity>();
    
     @PodamExclude
    @ManyToOne
    private SemanaEntity semana;
    
    private boolean especial;
     
    /**
     * @return the id
     */

     
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
