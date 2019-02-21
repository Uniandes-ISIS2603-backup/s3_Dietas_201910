/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.SuspensionDTO;
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
 * @author Andrea Montoya Serje.
 */
@Path("suspension")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SuspensionResource 
{
     private static final Logger LOGGER = Logger.getLogger(SuspensionResource.class.getName());
    
    @POST
    public SuspensionDTO createSuspension(SuspensionDTO suspension){
       return suspension; 
    }
    
//    @GET
//    public List<SuspensionDTO> getSuspensiones(){
//        return null;
//    }
//    
//    @GET
//    @Path("{suspensionId: \\d+}")
//    public SuspensionDTO getSuspension(@PathParam("suspensionId") Long suspensionId){
//        return null;
//    }
//    
//    @PUT
//    @Path("{suspensionId: \\d+}")
//    public SuspensionDTO updateSuspension(@PathParam("suspensionId") Long suspensionId, SuspensionDTO suspension){
//        return null;
//    }
    
    
}
