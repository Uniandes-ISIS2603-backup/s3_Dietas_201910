/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.CalificacionYComentarioDTO;
import co.edu.uniandes.csw.dietas.ejb.CalificacionYComentarioDePersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.CalificacionYComentarioLogic;
import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Andrea Montoya
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CalificacionYComentarioDePersonaResourse {
    
    
    private static final Logger LOGGER = Logger.getLogger(CalificacionYComentarioDePersonaResourse.class.getName());

    @Inject
    private CalificacionYComentarioDePersonaLogic calificacionycomentarioDePersonaLogic;

    @Inject
    private CalificacionYComentarioLogic calificacionycomentarioLogic;
    
    /**
     * Asocia una CalificacionYComentario existente con una persona existente
     *
     * @param personasId El ID de la persona que se va a asociar
     * @param calificacionycomentarioId El ID de la CalificacionYComentario al cual se le va a asociar la persona
     * @return JSON {@link SuspensionDetailDTO} 
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @POST
    @Path("{calificacionycomentarioId: \\d+}")
    public CalificacionYComentarioDTO addCalificacionYComentario(@PathParam("personasId") Long personasId, @PathParam("calificacionycomentarioId") Long calificacionycomentarioId) {
        if (calificacionycomentarioLogic.getCalificacionYComentario(calificacionycomentarioId) == null) {
            throw new WebApplicationException("El recurso /calificacionycomentario/" + calificacionycomentarioId + " no existe.", 404);
        }

        CalificacionYComentarioDTO dto = new CalificacionYComentarioDTO(calificacionycomentarioDePersonaLogic.addCalificacionYComentario(personasId, calificacionycomentarioId));        
        return dto;
    }
    
     /**
     * Busca y devuelve todas las personas que existen en una CalificacionYComentario.
     *
     * @param personasId El ID de la persona del cual se buscan las CalificacionYComentario
     * @return JSONArray {@link CalificacionYComentarioDTO} - Las CalificacionYComentario encontradas en la
     * persona. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CalificacionYComentarioDTO> getCalificacionesYComentarios(@PathParam("personasId") Long personasId) {
        List<CalificacionYComentarioDTO> lista = personaListEntity2DTO(calificacionycomentarioDePersonaLogic.getCalificacionesYComentarios(personasId));
        return lista;
    }
    
    /**
     * Convierte una lista de PersonaEntity a una lista de PersonaDTO.
     *
     * @param entityList Lista de PersonaEntity a convertir.
     * @return Lista de PersonaDTO convertida.
     */
    private List<CalificacionYComentarioDTO> personaListEntity2DTO(List<CalificacionYComentarioEntity> entityList) {
        List<CalificacionYComentarioDTO> list = new ArrayList<>();
        for (CalificacionYComentarioEntity entity : entityList) {
            list.add(new CalificacionYComentarioDTO(entity));
        }
        return list;
    }

    
    
}
