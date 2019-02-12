/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import java.util.Date;

/**
 *
 * @author estudiante
 */
public class SemanaDetailDTO {
    
    private Date horaEntrega;
    private int id;
    private String lugarEntrega;
    private int costo;

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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    
    
    
}
