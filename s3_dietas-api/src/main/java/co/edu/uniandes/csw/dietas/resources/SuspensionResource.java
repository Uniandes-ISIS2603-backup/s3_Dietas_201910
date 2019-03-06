/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.SuspensionDTO;
import co.edu.uniandes.csw.dietas.ejb.SuspensionLogic;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.ArrayList;
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
 * @author Andrea Montoya Serje.
 */
@Path("suspensiones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SuspensionResource 
{
     private static final Logger LOGGER = Logger.getLogger(SuspensionResource.class.getName());
    
       
    @Inject
    private SuspensionLogic suspensionLogic;
     
 
    /**
     *
     * @param suspension
     * @return
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @POST
    public SuspensionDTO createSuspension(SuspensionDTO suspension) throws BusinessLogicException{
        SuspensionEntity suspensionEntity = suspension.toEntity();
        suspensionEntity = suspensionLogic.createSuspension(suspensionEntity);
        SuspensionDTO suspensionDTO = new SuspensionDTO(suspensionEntity);
        return suspensionDTO; 
    }
    
      
      @GET
    @Path("{SuspensionId: \\d+}")
    public SuspensionDTO getSuspension(@PathParam("SuspensionId") Long suspensionId){
        SuspensionEntity suspension = suspensionLogic.getSuspension(suspensionId);
        if(suspension == null){
            throw new WebApplicationException("El recurso /suspension/"+suspensionId+" no existe.", 404);
        }
        return new SuspensionDTO(suspension);
    }
    
    private List<SuspensionDTO> listEntity2DetailDTO(List<SuspensionEntity> entityList) {
        List<SuspensionDTO> list = new ArrayList<>();
        for (SuspensionEntity entity : entityList) {
            list.add(new SuspensionDTO(entity));
        }
        return list;
    }
    
    
     @GET
    public List<SuspensionDTO> getSuspensiones(){
        List<SuspensionDTO> list = listEntity2DetailDTO(suspensionLogic.getSuspensiones());
        return list;
    }
    
    
      @PUT
    @Path("{suspensionesId: \\d+}")
    public SuspensionDTO updateSuspension(@PathParam("suspensionesId") Long suspensionesId, SuspensionDTO suspension){
        suspension.setId(suspensionesId);
        if (suspensionLogic.getSuspension(suspensionesId) == null) {
            throw new WebApplicationException("El recurso /suspension/" + suspensionesId + " no existe.", 404);
        }
        SuspensionDTO suspensionDTO = new SuspensionDTO(suspensionLogic.updateSuspension(suspensionesId, suspension.toEntity()));
        return suspensionDTO;
    }
    
     @DELETE
    @Path("{suspensionesId: \\d+}")
    public void deleteSuspension(@PathParam("suspensionesId") Long suspensionesId)throws BusinessLogicException{
        if (suspensionLogic.getSuspension(suspensionesId) == null) {
            throw new WebApplicationException("El recurso /suspensiones/" + suspensionesId + " no existe.", 404);
        }
        suspensionLogic.deleteSuspension(suspensionesId);
    }
    
}
