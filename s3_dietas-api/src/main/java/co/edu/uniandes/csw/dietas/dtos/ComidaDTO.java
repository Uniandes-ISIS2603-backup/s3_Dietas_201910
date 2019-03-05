/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
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
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param comidaEntity: Es la entidad que se va a convertir a DTO
     */
    public ComidaDTO(ComidaEntity comidaEntity) {
        if (comidaEntity != null) {
            this.id = comidaEntity.getId();
            this.tipo = comidaEntity.getTipo();
            this.alimentosYCantidades= comidaEntity.getAlimentosYCantidad();
        }
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

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ComidaEntity toEntity() {
        ComidaEntity comidaEntity = new ComidaEntity();
        comidaEntity.setId(this.id);
        comidaEntity.setTipo(this.tipo);
        comidaEntity.setAlimentosYCantidad(this.alimentosYCantidades);
        return comidaEntity;
   
    }
   

  

}
