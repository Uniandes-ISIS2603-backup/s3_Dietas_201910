/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Daniel Espitia   
 */
@Entity
public class PersonaEntity extends BaseEntity implements Serializable {
    
    private String tipo;
    private String nombre;
    private Date fechaIngreso;
    private String objetivos;
    private int tiempoEsperadoMejora;
    private boolean solicitudEspecial;
    private boolean tarjetaFidelidad;
  
    @PodamExclude
    @OneToMany(mappedBy = "personaDieta")
    private List<DietaEntity> dietas = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne()
    private HallOfFameEntity hall;

    @PodamExclude
    @OneToMany(mappedBy = "persona")
    private List<QuejaYReclamoEntity> quejas = new ArrayList<>();
        
    @PodamExclude
    @OneToMany(mappedBy = "persona")
    private List<PagoEntity> pagos = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "persona")
    private List<CalificacionYComentarioEntity> calificacionesYComentarios = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "persona")
    private List<FotoEntity> fotos = new ArrayList<>();

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
     * @return the halls
     */
    public HallOfFameEntity getHalls() {
        return getHall();
    }

    /**
     * @param halls the halls to set
     */
    public void setHalls(HallOfFameEntity halls) {
        this.setHall(getHall());
    }

    /**
     * @return the quejas
     */
    public List<QuejaYReclamoEntity> getQuejas() {
        return quejas;
    }

    /**
     * @param quejas the quejas to set
     */
    public void setQuejas(List<QuejaYReclamoEntity> quejas) {
        this.quejas = quejas;
    }

    /**
     * @return the pagos
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the calificacionesYComentarios
     */
    public List<CalificacionYComentarioEntity> getCalificacionesYComentarios() {
        return calificacionesYComentarios;
    }

    /**
     * @param calificacionesYComentarios the calificacionesYComentarios to set
     */
    public void setCalificacionesYComentarios(List<CalificacionYComentarioEntity> calificacionesYComentarios) {
        this.calificacionesYComentarios = calificacionesYComentarios;
    }

    /**
     * @return the fotos
     */
    public List<FotoEntity> getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(List<FotoEntity> fotos) {
        this.fotos = fotos;
    }

    /**
     * @return the dietas
     */
    public List<DietaEntity> getDietas() {
        return dietas;
    }

    /**
     * @param dietas the dietas to set
     */
    public void setDietas(List<DietaEntity> dietas) {
        this.dietas = dietas;
    }

    /**
     * @return the hall
     */
    public HallOfFameEntity getHall() {
        return hall;
    }

    /**
     * @param hall the hall to set
     */
    public void setHall(HallOfFameEntity hall) {
        this.hall = hall;
    }
          
}
     

