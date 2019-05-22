/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.CalificacionYComentarioDTO;
import co.edu.uniandes.csw.dietas.ejb.CalificacionYComentarioLogic;
import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
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
@Path("calificacionycomentario")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionYComentarioResource 
{
    private static final Logger LOGGER = Logger.getLogger(CalificacionYComentarioResource.class.getName());
   
    
     @Inject
    private CalificacionYComentarioLogic calificacionYcomentarioLogic;
     
 
    /**
     *
     * @param suspension
     * @return
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     */
    @POST
    public CalificacionYComentarioDTO createCalificacionYComentario(CalificacionYComentarioDTO cYc) throws BusinessLogicException{
        CalificacionYComentarioEntity calificacionYcomentarioEntity = cYc.toEntity();
        calificacionYcomentarioEntity = calificacionYcomentarioLogic.createCalificacionYComentario(calificacionYcomentarioEntity);
        CalificacionYComentarioDTO calificacionYcomentarioDTO = new CalificacionYComentarioDTO(calificacionYcomentarioEntity);
        return calificacionYcomentarioDTO; 
    }
    

    
      @GET
    @Path("{calificacionYcomentarioId: \\d+}")
    public CalificacionYComentarioDTO getCalificacionYComentario(@PathParam("calificacionYcomentarioId") Long calificacionYcomentarioId){
        CalificacionYComentarioEntity calificacionYcomentario = calificacionYcomentarioLogic.getCalificacionYComentario(calificacionYcomentarioId);
        if(calificacionYcomentario == null){
            throw new WebApplicationException("El recurso /calificacionYcomentario/"+calificacionYcomentarioId+" no existe.", 404);
        }
        return new CalificacionYComentarioDTO(calificacionYcomentario);
    }
    
    
     @GET
    public List<CalificacionYComentarioDTO> getCalificacionesYComentarios(){
        List<CalificacionYComentarioDTO> list = listEntity2DetailDTO(calificacionYcomentarioLogic.getCalificacionesYComentarios());
        return list;
    }
    
    
    
     @PUT
    @Path("{calificacionYcomentarioId: \\d+}")
    public CalificacionYComentarioDTO updateCalificacionYComentario(@PathParam("calificacionYcomentarioId") Long calificacionYcomentarioId, CalificacionYComentarioDTO calificacionYcomentario){
        calificacionYcomentario.setId(calificacionYcomentarioId);
        if (calificacionYcomentarioLogic.getCalificacionYComentario(calificacionYcomentarioId) == null) {
            throw new WebApplicationException("El recurso /calificacionYcomentario/" + calificacionYcomentarioId + " no existe.", 404);
        }
        CalificacionYComentarioDTO calificacionYcomentarioDTO = new CalificacionYComentarioDTO(calificacionYcomentarioLogic.updateCalificacionYComentario(calificacionYcomentarioId, calificacionYcomentario.toEntity()));
        return calificacionYcomentarioDTO;
    }
    
    
     @DELETE
    @Path("{calificacionYcomentarioId: \\d+}")
    public void deleteCalificacionYComentario(@PathParam("calificacionYcomentarioIdd") Long calificacionYcomentarioId)throws BusinessLogicException
    {
        if(calificacionYcomentarioLogic.getCalificacionYComentario(calificacionYcomentarioId) == null) 
        {
            throw new WebApplicationException("El recurso /suspensiones/" + calificacionYcomentarioId + " no existe.", 404);
        }
        calificacionYcomentarioLogic.deleteCalificacionYComentario(calificacionYcomentarioId);
    }
    
    
    private List<CalificacionYComentarioDTO> listEntity2DetailDTO(List<CalificacionYComentarioEntity> entityList) {
        List<CalificacionYComentarioDTO> list = new ArrayList<>();
        for (CalificacionYComentarioEntity entity : entityList) {
            list.add(new CalificacionYComentarioDTO(entity));
        }
        return list;
    }
    
}