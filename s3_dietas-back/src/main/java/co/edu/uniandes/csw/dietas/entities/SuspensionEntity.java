/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andrea Montoya Serje
 */
@Entity
public class SuspensionEntity extends BaseEntity implements Serializable 
{
    private boolean vigente;
    private int numDias;
    private String comentarios;
    
    //@PodamExclude
    //@ManyToOne
    //private DietaEntity dieta;

    /**
     * @return the vigente
     */
    public boolean isVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    /**
     * @return the numDias
     */
    public int getNumDias() {
        return numDias;
    }

    /**
     * @param numDias the numDias to set
     */
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
