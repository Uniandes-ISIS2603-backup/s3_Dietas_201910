/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.CocinaDTO;
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
 * @author  Andrea Montoya Serje.
 */
@Path("cocina")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CocinaResource 
{
    private static final Logger LOGGER = Logger.getLogger(CocinaResource.class.getName());
    
    @POST
    public CocinaDTO createCocina(CocinaDTO cocina){
       return cocina; 
    }
    
    @GET
    @Path("{cocinaId: \\d+}")
    public CocinaDTO getCocina(@PathParam("cocinanId") Long cocinaId){
        return null;
    }
    
    @GET
    @Path("{name: [a-zA-Z][a-zA-Z]*}}")
    public CocinaDTO getCocina(@PathParam("cocinanDireccion") String cocinaDireccion){
        return null;
    }
    
    
    @DELETE
    @Path("{cocinaId: \\d+}")
    public void deleteCocina(@PathParam("cocinaId") Long cocinaId){
        
    }
    
}
