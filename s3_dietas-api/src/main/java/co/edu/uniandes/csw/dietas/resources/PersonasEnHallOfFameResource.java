/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.PersonaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.PersonasEnHallOfFameLogic;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Louis
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonasEnHallOfFameResource {
    
    private static final Logger LOGGER = Logger.getLogger(PersonasEnHallOfFameResource.class.getName());

    @Inject
    private PersonasEnHallOfFameLogic personasEnHallOfFameLogic;

    @Inject
    private PersonaLogic personaLogic;
    
    /**
     * Asocia una suspension existente con una dieta existente
     *
     * @param personasId El ID de la suspension que se va a asociar
     * @param hallsId El ID de la dieta al cual se le va a asociar la suspension
     * @return JSON {@link SuspensionDetailDTO} - La suspension asociado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @POST
    @Path("{personasId: \\d+}")
    public PersonaDTO addPersona(@PathParam("hallsId") Long hallsId, @PathParam("personasId") Long personasId) {
        if (personaLogic.getPersona(personasId) == null) {
            throw new WebApplicationException("El recurso /personas/" + personasId + " no existe.", 404);
        }
//        else if(personaLogic.getPersonas().contains() == null){
//            //si la persona ya esta en personas
//        }
        PersonaDTO dto = new PersonaDTO(personasEnHallOfFameLogic.addPersona(hallsId, personasId));
        
        return dto;
    }
    
     /**
     * Busca y devuelve todas las personas que existen en una hall.
     *
     * @param hallsId El ID de la dieta del cual se buscan las suspensiones
     * @return JSONArray {@link SuspensionDTO} - Las suspensiones encontradas en la
     * dieta. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PersonaDetailDTO> getPersonas(@PathParam("hallsId") Long hallsId) {
        List<PersonaDetailDTO> lista = personaListEntity2DTO(personasEnHallOfFameLogic.getPersonas(hallsId));
        return lista;
    }
    
    /**
     * Convierte una lista de PersonaEntity a una lista de PersonaDTO.
     *
     * @param entityList Lista de PersonaEntity a convertir.
     * @return Lista de PersonaDTO convertida.
     */
    private List<PersonaDetailDTO> personaListEntity2DTO(List<PersonaEntity> entityList) {
        List<PersonaDetailDTO> list = new ArrayList<>();
        for (PersonaEntity entity : entityList) {
            list.add(new PersonaDetailDTO(entity));
        }
        return list;
    }

}
