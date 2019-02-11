/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import java.io.Serializable;

/**
 *
 * @author Alejandra
 */
public class PagoDTO implements Serializable{
    private Long id;
    private String modoPago;
    
    public PagoDTO(){
        
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the modoPago
     */
    public String getModoPago() {
        return modoPago;
    }

    /**
     * @param modoPago the modoPago to set
     */
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }
}
