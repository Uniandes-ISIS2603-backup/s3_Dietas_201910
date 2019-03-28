/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import java.io.Serializable;

/**
 *
 * @author Alejandra  :)
 */
public class DietaDTO implements Serializable{

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private Long id;
    private String tipo;
    private String objetivo;
    private Integer diasSuspendida;
    private String nombre;

    public DietaDTO(){
        
    }
    
    public DietaDTO(DietaEntity entity){
        setId(entity.getId());
        setTipo(entity.getTipo());
        setObjetivo(entity.getObjetivo());
        setDiasSuspendida(entity.getDiasSuspendida());
        setNombre(entity.getNombre());
        
    }
    
    public DietaEntity toEntity(){
        DietaEntity entity = new DietaEntity();
        entity.setDiasSuspendida(this.getDiasSuspendida());
        entity.setId(this.getId());
        entity.setObjetivo(this.getObjetivo());
        entity.setTipo(this.getTipo());
        entity.setNombre(this.getNombre());
        return entity;
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
    public Integer getDiasSuspendida() {
        return diasSuspendida;
    }

    /**
     * @param diasSuspendida the diasSuspendida to set
     */
    public void setDiasSuspendida(Integer diasSuspendida) {
        this.diasSuspendida = diasSuspendida;
    }
}
