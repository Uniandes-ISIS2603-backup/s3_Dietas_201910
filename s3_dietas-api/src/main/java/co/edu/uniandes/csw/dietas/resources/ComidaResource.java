/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.ComidaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Louis Gualtero
 */
@Path("comidas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ComidaResource {
    
    
    private static final Logger LOGGER = Logger.getLogger(ComidaResource.class.getName());
     
    @POST
    public ComidaDTO crearComida(ComidaDTO comida){
        return comida;
    }
}
