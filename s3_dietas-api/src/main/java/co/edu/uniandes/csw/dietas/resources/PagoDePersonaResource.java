/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PagoDTO;
import co.edu.uniandes.csw.dietas.ejb.PagoLogic;
import co.edu.uniandes.csw.dietas.ejb.PagosDePersonaLogic;
import co.edu.uniandes.csw.dietas.entities.PagoEntity;
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
 * @author estudiante
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagoDePersonaResource {
    private static final Logger LOGGER = Logger.getLogger(PagoDePersonaResource.class.getName());

    @Inject
    private PagosDePersonaLogic pagoDePersonaLogic;

    @Inject
    private PagoLogic pagoLogic;
    
    /**
     * Asocia una foto existente con una persona existente
     *
     * @param personasId El ID de la suspension que se va a asociar
     * @param hallsId El ID de la dieta al cual se le va a asociar la suspension
     * @return JSON {@link SuspensionDetailDTO} - La suspension asociado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @POST
    @Path("{pagosId: \\d+}")
    public PagoDTO addPago(@PathParam("personasId") Long personasId, @PathParam("pagosId") Long pagosId) {
        if (pagoLogic.getPago(pagosId) == null) {
            throw new WebApplicationException("El recurso /pagos/" + pagosId + " no existe.", 404);
        }

        PagoDTO dto = new PagoDTO(pagoDePersonaLogic.addPago(personasId, pagosId));        
        return dto;
    }
    
     /**
     * Busca y devuelve todas las personas que existen en una hall.
     *
     * @param dietasId El ID de la dieta del cual se buscan las suspensiones
     * @return JSONArray {@link SuspensionDTO} - Las suspensiones encontradas en la
     * dieta. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PagoDTO> getPagos(@PathParam("personasId") Long personasId) {
        List<PagoDTO> lista = personaListEntity2DTO(pagoDePersonaLogic.getPagos(personasId));
        return lista;
    }
    
    /**
     * Convierte una lista de PersonaEntity a una lista de PersonaDTO.
     *
     * @param entityList Lista de PersonaEntity a convertir.
     * @return Lista de PersonaDTO convertida.
     */
    private List<PagoDTO> personaListEntity2DTO(List<PagoEntity> entityList) {
        List<PagoDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDTO(entity));
        }
        return list;
    }

}

