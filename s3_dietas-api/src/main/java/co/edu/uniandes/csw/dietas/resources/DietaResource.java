/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.DietaDTO;
import co.edu.uniandes.csw.dietas.dtos.DietaDetailDTO;
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
@Path("dietas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DietaResource {
    private static final Logger LOGGER = Logger.getLogger(DietaResource.class.getName());
    
    @POST
    public DietaDTO createPago(DietaDTO dieta){
       return dieta; 
    }
//    
//    @GET
//    public List<DietaDetailDTO> getDietas(){
//        return null;
//    }
//    
//    @GET
//    @Path("{dietasId: \\d+}")
//    public DietaDetailDTO getDieta(@PathParam("dietasId") Long dietasId){
//        return null;
//    }
//    
//    @PUT
//    @Path("{dietasId: \\d+}")
//    public DietaDetailDTO updateDieta(@PathParam("dietasId") Long dietasId, DietaDTO dieta){
//        return null;
//    }
//    
//    @DELETE
//    @Path("{dietasId: \\d+}")
//    public void deleteDieta(@PathParam("dietasId") Long dietasId){
//        
//    }
}
