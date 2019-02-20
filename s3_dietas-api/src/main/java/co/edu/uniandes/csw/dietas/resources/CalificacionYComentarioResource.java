/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.CalificacionYComentarioDTO;
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
@Path("calificacionycomentario")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionYComentarioResource 
{
    private static final Logger LOGGER = Logger.getLogger(CalificacionYComentarioResource.class.getName());
    
    @POST
    public CalificacionYComentarioDTO createCalificacionYComentario(CalificacionYComentarioDTO calificacionycomentario){
       return calificacionycomentario; 
    }
    
    @GET
    public List<CalificacionYComentarioDTO> getCalificacionesYComentarios(){
        return null;
    }
    
    @GET
    @Path("{calificacionycomentarioId: \\d+}")
    public CalificacionYComentarioDTO getCalificacionYComentario(@PathParam("calificacionycomentarioId") Long calificacionycomentarioIdId){
        return null;
    }
    
   
    
}
