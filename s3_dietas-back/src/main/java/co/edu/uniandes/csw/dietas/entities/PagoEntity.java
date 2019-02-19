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
 * @author Alejandra Bravo
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable{

    @PodamExclude
    @ManyToOne
    private PersonaEntity persona;
    
    private String modoPago;    
    /**
     * @return the modoPago
     */
    public String getModoPago() {
        return modoPago;
    }

    /**
     * @param modoPago the modoPago to set
     */
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    /**
     * @return the persona
     */
    public PersonaEntity getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    
}
