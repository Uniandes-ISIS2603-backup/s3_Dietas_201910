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
public class PersonaDTO {
    
    private Long id;
    private String tipo;
    private String nombre;
    private Date fechaIngreso;
    private String[] objetivos;
    private int tiempoEsperadoMejora;
    private boolean solicitudEspecial;
    private boolean tarjetaFidelidad;
    private String[] fotos;
    private Integer[] calificaciones;
    private String[] comentarios;
    private String[] quejasYReclamos;

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
    public String[] getObjetivos() {
        return objetivos;
    }

    /**
     * @param objetivos the objetivos to set
     */
    public void setObjetivos(String[] objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * @return the tiempoEsperadoMejora
     */
    public int getTiempoEsperadoMejora() {
        return tiempoEsperadoMejora;
    }

    /**
     * @param tiempoEsperadoMejora the tiempoEsperadoMejora to set
     */
    public void setTiempoEsperadoMejora(int tiempoEsperadoMejora) {
        this.tiempoEsperadoMejora = tiempoEsperadoMejora;
    }

    /**
     * @return the solicitudEspecial
     */
    public boolean isSolicitudEspecial() {
        return solicitudEspecial;
    }

    /**
     * @param solicitudEspecial the solicitudEspecial to set
     */
    public void setSolicitudEspecial(boolean solicitudEspecial) {
        this.solicitudEspecial = solicitudEspecial;
    }

    /**
     * @return the tarjetaFidelidad
     */
    public boolean isTarjetaFidelidad() {
        return tarjetaFidelidad;
    }

    /**
     * @param tarjetaFidelidad the tarjetaFidelidad to set
     */
    public void setTarjetaFidelidad(boolean tarjetaFidelidad) {
        this.tarjetaFidelidad = tarjetaFidelidad;
    }

    /**
     * @return the fotos
     */
    public String[] getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(String[] fotos) {
        this.fotos = fotos;
    }

    /**
     * @return the calificaciones
     */
    public Integer[] getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(Integer[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the comentarios
     */
    public String[] getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the quejasYReclamos
     */
    public String[] getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(String[] quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
    }

}
