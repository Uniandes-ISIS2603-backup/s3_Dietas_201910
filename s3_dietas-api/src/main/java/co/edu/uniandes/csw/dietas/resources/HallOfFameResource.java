/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.HallOfFameDTO;
import co.edu.uniandes.csw.dietas.ejb.HallOfFameLogic;
import co.edu.uniandes.csw.dietas.entities.HallOfFameEntity;
import co.edu.uniandes.csw.dietas.dtos.HallOfFameDetailDTO;
import javax.ws.rs.PathParam;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import java.util.List;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Louis Gualtero
 */

@Path("halls")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class HallOfFameResource {
   
      @Inject
     private HallOfFameLogic hallLogic;
      
     private static final Logger LOGGER = Logger.getLogger(HallOfFameResource.class.getName());
     
     @POST
     public HallOfFameDTO crearHall(HallOfFameDTO hall) throws BusinessLogicException{
         HallOfFameEntity entidad= hall.toEntity();
         entidad=hallLogic.createHallOfFame(entidad);
                  return new HallOfFameDTO(entidad);
     }
     
    @GET
    public List<HallOfFameDetailDTO> getHall(){
       return null;
    }
    
    @GET
    @Path("{hallsId: \\d+}")
    public HallOfFameDetailDTO getHall(@PathParam("hallsId") Long hallsId){
        HallOfFameEntity entity = hallLogic.getHall(hallsId);
        if(entity == null){
            throw new WebApplicationException("El recurso /halls/"+hallsId+" no existe.",404);
        }
          return new HallOfFameDetailDTO(entity);
        
    }
}
     

