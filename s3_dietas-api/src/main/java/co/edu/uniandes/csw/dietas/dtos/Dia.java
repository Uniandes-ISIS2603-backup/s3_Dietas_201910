/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

/**
 *
 * @author estudiante
 */
public class Dia 
{
    private boolean diaEspecial;
    private int id;
    public Dia ()
    {
        
    }

    /**
     * @return the diaEspecial
     */
    public boolean isDiaEspecial() {
        return diaEspecial;
    }

    /**
     * @param diaEspecial the diaEspecial to set
     */
    public void setDiaEspecial(boolean diaEspecial) {
        this.diaEspecial = diaEspecial;
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
