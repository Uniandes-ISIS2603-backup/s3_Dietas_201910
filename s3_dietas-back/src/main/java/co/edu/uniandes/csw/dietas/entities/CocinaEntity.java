/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andrea Montoya Serje
 */
@Entity
public class CocinaEntity extends BaseEntity implements Serializable  
{
    private String direccion;
    
    @PodamExclude
    @OneToMany (mappedBy = "cocina")
    private List<ComidaEntity> comidas = new ArrayList<ComidaEntity>( );
    

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the comida
     */
    public List<ComidaEntity> getComida() {
        return comidas;
    }

    /**
     * @param comida the comida to set
     */
    public void setComida(List<ComidaEntity> comida) {
        this.comidas = comida;
    }

}
