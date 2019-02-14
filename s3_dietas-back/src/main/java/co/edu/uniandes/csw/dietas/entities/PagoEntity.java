/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.entities;
import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author Alejandra Bravo
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable{

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
    private String modoPago;
    
}
