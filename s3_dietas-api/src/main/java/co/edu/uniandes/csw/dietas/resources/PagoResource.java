/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PagoDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Alejandra Bravo
 */
@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
    private static final Logger LOGGER = Logger.getLogger(PagoResource.class.getName());
    
    @POST
    public PagoDTO createPago(PagoDTO pago){
       return pago; 
    }
    //Preguntar por el detail de pago en GETs, PUT
    @GET
    @Path("{pagosId: \\d+}")
    public PagoDTO getPago(@PathParam("id") Long pagosId){
        return null;
    }
    
    @GET
    public List<PagoDTO> getPagos(){
        return null;
    }
    
    @PUT
    @Path("{pagosId: \\d+}")
    public PagoDTO updatePago(@PathParam("pagosId") Long pagosId, PagoDTO pago){
        return null;
    }
    
    @DELETE
    @Path("{pagosId: \\d+}")
    public void deletePago(@PathParam("pagosId") Long pagosId){
        
    }
}
