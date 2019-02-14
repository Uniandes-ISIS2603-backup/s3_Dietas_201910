/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import java.io.Serializable;

/**
 *
 * @author Alejandra Bravo
 */
public class DietaDTO implements Serializable{
    private Long id;
    private String tipo;
    private String objetivo;
    private int diasSuspendida;

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
}
