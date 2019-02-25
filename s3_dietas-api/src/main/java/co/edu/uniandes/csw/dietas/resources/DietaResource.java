/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.DietaDTO;
import co.edu.uniandes.csw.dietas.dtos.DietaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.DietaLogic;
import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

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
    
    @Inject
    private DietaLogic logica;
    
    @POST
    public DietaDTO createDieta(DietaDTO dieta)throws BusinessLogicException{
        DietaEntity dietaEntity = dieta.toEntity();
        dietaEntity = logica.createDieta(dietaEntity);
       return new DietaDTO(dietaEntity);
    }
    
    @GET
    public List<DietaDetailDTO> getDietas(){
        return null;
    }
    
    @GET
    @Path("{dietasId: \\d+}")
    public DietaDetailDTO getDieta(@PathParam("dietasId") Long dietasId){
        DietaEntity entidad = logica.getDieta(dietasId);
        if(entidad == null){
            throw new WebApplicationException("El recurso /dietas/"+dietasId+" no existe.", 404);
        }
        return new DietaDetailDTO(entidad);    
    }
    
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
