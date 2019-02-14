/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import java.io.Serializable;

/**
 *
 * @author Louis
 */
public class ComidaDTO implements Serializable{
    private Long id;
    private String tipo;
    private String alimentosYCantidades;

    /*
    * Constructor por defecto
    */
    public ComidaDTO (){
        
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
     * @return the alimentosYCantidades
     */
    public String getAlimentosYCantidades() {
        return alimentosYCantidades;
    }

    /**
     * @param alimentosYCantidades the alimentosYCantidades to set
     */
    public void setAlimentosYCantidades(String alimentosYCantidades) {
        this.alimentosYCantidades = alimentosYCantidades;
    }
    
   

  

}
