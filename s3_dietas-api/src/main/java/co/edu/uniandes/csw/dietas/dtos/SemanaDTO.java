/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class SemanaDTO implements Serializable{
    private int id;
    
    /**
     * Método constructor de la clase
     */
    public SemanaDTO()
    {
        
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
    
}
