/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.DietaPersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.mappers.WebApplicationExceptionMapper;
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
 * @author Alejandra Bravoa
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DietaPersonaResource {

    private static final Logger LOGGER = Logger.getLogger(DietaPersonaResource.class.getName());

    @Inject
    private DietaPersonaLogic dietaPersonaLogic;

    @Inject
    private PersonaLogic personaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Asocia una persona existente con una dieta existente
     *
     * @param personasId El ID de la persona que se va a asociar
     * @param dietasId El ID de la dieta a la cual se le va a asociar la persona
     * @return JSON {@link PersonaDetailDTO} - La persona asociada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la persona.
     */
    @POST
    @Path("{personasId: \\d+}")
    public PersonaDetailDTO addPersona(@PathParam("dietasId") Long dietasId, @PathParam("personasId") Long personasId) {
        if (personaLogic.getPersona(personasId) == null) {
            throw new WebApplicationException("El recurso /personas/" + personasId + " no existe.", 404);
        }
        PersonaDetailDTO detailDTO = new PersonaDetailDTO(dietaPersonaLogic.addPersona(dietasId, personasId));
        return detailDTO;
    }

    /**
     * Busca y devuelve la persona que existen en una dieta.
     *
     * @param dietasId El ID de la dieta del cual se busca la persona
     * @return PersonaDetailDTO.
     */
    @GET
    public PersonaDetailDTO getPersona(@PathParam("dietasId") Long dietasId) {
        return new PersonaDetailDTO(dietaPersonaLogic.getPersona(dietasId));
    } 
}
