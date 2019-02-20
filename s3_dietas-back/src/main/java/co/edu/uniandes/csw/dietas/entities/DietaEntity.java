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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Alejandra Bravo
 */
@Entity
public class DietaEntity extends BaseEntity implements Serializable {


    @PodamExclude
    @ManyToOne
    private PersonaEntity personaDieta;
    
    @PodamExclude
    @ManyToMany(mappedBy = "tDieta")
    private List<TipoDietaEntity> tDieta = new ArrayList<TipoDietaEntity>( );
    
    @PodamExclude
    @OneToMany (mappedBy = "dieta")
    private List<SuspensionEntity> suspensiones = new ArrayList<SuspensionEntity>( );
    
    @PodamExclude
    @OneToMany (mappedBy = "dietas")
    private List<SemanaEntity> semanas = new ArrayList<SemanaEntity>( );
 
    private String tipo;
    private String objetivo;
    private int diasSuspendida;
    


    public DietaEntity(){
        
    }
    
   

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the diasSuspendida
     */
    public int getDiasSuspendida() {
        return diasSuspendida;
    }

    /**
     * @param diasSuspendida the diasSuspendida to set
     */
    public void setDiasSuspendida(int diasSuspendida) {
        this.diasSuspendida = diasSuspendida;
    }

    /**
     * @return the personaDieta
     */
    public PersonaEntity getPersonaDieta() {
        return personaDieta;
    }

    /**
     * @param personaDieta the personaDieta to set
     */
    public void setPersonaDieta(PersonaEntity personaDieta) {
        this.personaDieta = personaDieta;
    }

    /**
     * @return the tDieta
     */
    public List<TipoDietaEntity> gettDieta() {
        return tDieta;
    }

    /**
     * @param tDieta the tDieta to set
     */
    public void settDieta(List<TipoDietaEntity> tDieta) {
        this.tDieta = tDieta;
    }

    /**
     * @return the suspension
     */
    public List<SuspensionEntity> getSuspension() {
        return suspensiones;
    }

    /**
     * @param suspension the suspension to set
     */
    public void setSuspension(List<SuspensionEntity> suspension) {
        this.suspensiones = suspension;
    }

    /**
     * @return the semanas
     */
    public List<SemanaEntity> getSemanas() {
        return semanas;
    }

    /**
     * @param semanas the semanas to set
     */
    public void setSemanas(List<SemanaEntity> semanas) {
        this.semanas = semanas;
    }

   

}
