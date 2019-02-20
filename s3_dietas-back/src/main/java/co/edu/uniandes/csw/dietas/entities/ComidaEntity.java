/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author  Louis Gualtero.
 */
@Entity
public class ComidaEntity extends BaseEntity implements Serializable {
  
    
 
            
    @PodamExclude
    @ManyToOne
    private CocinaEntity cocina;
    
    @PodamExclude
    @ManyToOne
    private DiaEntity dia;
    
    private String tipo;
    private String alimentosYCantidad;

 public ComidaEntity(){
     
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
     * @return the alimentosYCantidad
     */
    public String getAlimentosYCantidad() {
        return alimentosYCantidad;
    }

    /**
     * @param alimentosYCantidad the alimentosYCantidad to set
     */
    public void setAlimentosYCantidad(String alimentosYCantidad) {
        this.alimentosYCantidad = alimentosYCantidad;
    }

    /**
     * @return the cocina
     */
    public CocinaEntity getCocina() {
        return cocina;
    }

    /**
     * @param cocina the cocina to set
     */
    public void setCocina(CocinaEntity cocina) {
        this.cocina = cocina;
    }

    /**
     * @return the dia
     */
    public DiaEntity getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(DiaEntity dia) {
        this.dia = dia;
    }

  
}
