/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import java.util.Date;

/**
 *
 * @author estudiante
 */
public class PersonaDTO {
    
    private Long id;
    private String tipo;
    private String nombre;
    private Date fechaIngreso;
    private String objetivos;
    private Integer tiempoEsperadoMejora;
    private Boolean solicitudEspecial;
    private Boolean tarjetaFidelidad;

    public PersonaDTO(){
        
    }

    public PersonaDTO(PersonaEntity entity){
        this.setId(entity.getId());
        this.setTipo(entity.getTipo());
        this.setNombre(entity.getNombre());
        this.setFechaIngreso(entity.getFechaIngreso());
        this.setObjetivos(entity.getObjetivos());
        this.setTiempoEsperadoMejora(entity.getTiempoEsperadoMejora());
        this.setSolicitudEspecial(entity.isSolicitudEspecial());
        this.setTarjetaFidelidad(entity.isTarjetaFidelidad());
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

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the objetivos
     */
    public String getObjetivos() {
        return objetivos;
    }

    /**
     * @param objetivos the objetivos to set
     */
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * @return the tiempoEsperadoMejora
     */
    public Integer getTiempoEsperadoMejora() {
        return tiempoEsperadoMejora;
    }

    /**
     * @param tiempoEsperadoMejora the tiempoEsperadoMejora to set
     */
    public void setTiempoEsperadoMejora(Integer tiempoEsperadoMejora) {
        this.tiempoEsperadoMejora = tiempoEsperadoMejora;
    }

    /**
     * @return the solicitudEspecial
     */
    public Boolean getSolicitudEspecial() {
        return solicitudEspecial;
    }

    /**
     * @param solicitudEspecial the solicitudEspecial to set
     */
    public void setSolicitudEspecial(Boolean solicitudEspecial) {
        this.solicitudEspecial = solicitudEspecial;
    }

    /**
     * @return the tarjetaFidelidad
     */
    public Boolean getTarjetaFidelidad() {
        return tarjetaFidelidad;
    }

    /**
     * @param tarjetaFidelidad the tarjetaFidelidad to set
     */
    public void setTarjetaFidelidad(Boolean tarjetaFidelidad) {
        this.tarjetaFidelidad = tarjetaFidelidad;
    }
    
    public PersonaEntity toEntity()
    {
        PersonaEntity entidad= new PersonaEntity();
        entidad.setId(this.id);
        entidad.setNombre(this.nombre);
        entidad.setTipo(this.tipo);
        entidad.setFechaIngreso(this.fechaIngreso);
        entidad.setObjetivos(this.objetivos);
        entidad.setTiempoEsperadoMejora(this.tiempoEsperadoMejora);
        entidad.setTarjetaFidelidad(this.tarjetaFidelidad);
        return entidad;
    }


    


    
}
