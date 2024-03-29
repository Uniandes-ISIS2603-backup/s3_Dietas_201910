/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Entity
public class SemanaEntity extends BaseEntity implements Serializable
{

    
    private Date horaEntrega;
    private String lugarEntrega;
    private Integer costo;
   
    @PodamExclude
    @OneToMany(mappedBy = "semana")
    private List<DiaEntity> dias = new ArrayList<DiaEntity>();
    
    @PodamExclude
    @ManyToOne
    private DietaEntity dieta;


    /**
     * Método que me permite crear una SemanaEntity (Constructor de la clase).
     */
    public SemanaEntity()
    {
        
    }
    
    
    /**
     * @return the horaEntrega
     */
    public Date getHoraEntrega() {
        return horaEntrega;
    }

    /**
     * @param horaEntrega the horaEntrega to set
     */
    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    /**
     * @return the lugarEntrega
     */
    public String getLugarEntrega() {
        return lugarEntrega;
    }

    /**
     * @param lugarEntrega the lugarEntrega to set
     */
    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    /**
     * @return the costo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }
    /**
     * Devuelve la dieta que tiene la semana
     * @return la dieta a la cual pertenece la semana
     */
    public DietaEntity getDieta(){
        return dieta;
    }
    /**
     * Método que me permite asignar una dieta
     * @param dieta dieta que se va a asignar
     */
    public void setDieta(DietaEntity dieta)
    {
        this.dieta= dieta;
    }
    
    public void setDias(List<DiaEntity> diasSemana)
    {
        this.dias = diasSemana;
    }
    public List<DiaEntity> getDias(){
        return dias;
    }
    
}