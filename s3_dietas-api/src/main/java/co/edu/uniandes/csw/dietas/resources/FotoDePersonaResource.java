/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.FotoDTO;
import co.edu.uniandes.csw.dietas.ejb.FotoDePersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.FotoLogic;
import co.edu.uniandes.csw.dietas.entities.FotoEntity;
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
 * @author Daniel Espitia
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FotoDePersonaResource {
     private static final Logger LOGGER = Logger.getLogger(FotoDePersonaResource.class.getName());

    @Inject
    private FotoDePersonaLogic fotoDePersonaLogic;

    @Inject
    private FotoLogic fotoLogic;
    
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
    @Path("{fotosId: \\d+}")
    public FotoDTO addFoto(@PathParam("personasId") Long personasId, @PathParam("fotosId") Long fotosId) {
        if (fotoLogic.getFoto(fotosId) == null) {
            throw new WebApplicationException("El recurso /fotos/" + fotosId + " no existe.", 404);
        }

        FotoDTO dto = new FotoDTO(fotoDePersonaLogic.addFoto(personasId, fotosId));        
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
    public List<FotoDTO> getFotos(@PathParam("personasId") Long personasId) {
        List<FotoDTO> lista = personaListEntity2DTO(fotoDePersonaLogic.getFotos(personasId));
        return lista;
    }
    
    /**
     * Busca y devuelve la suspension con el ID recibido en la URL, relativo a una persona.
     *
     * @param fotosId El ID de la suspension que se busca
     * @param personasId El ID de la persona del cual se busca la suspension
     * @return {@link FotoDTO} - La foto encontrada en la persona.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
//    @GET
//    @Path("{fotosId: \\d+}")
//    public FotoDTO getFoto(@PathParam("personasId") Long personasId, @PathParam("fotosId") Long fotosId) {
//        if (fotoLogic.getFoto(fotosId) == null) {
//            throw new WebApplicationException("El recurso /fotos/" + fotosId + " no existe.", 404);
//        }
//        FotoDTO detailDTO = new FotoDTO(fotoDePersonaLogic.getFoto(personasId, fotosId));
//        return detailDTO;
//    }
    
    /**
     * Convierte una lista de PersonaEntity a una lista de PersonaDTO.
     *
     * @param entityList Lista de PersonaEntity a convertir.
     * @return Lista de PersonaDTO convertida.
     */
    private List<FotoDTO> personaListEntity2DTO(List<FotoEntity> entityList) {
        List<FotoDTO> list = new ArrayList<>();
        for (FotoEntity entity : entityList) {
            list.add(new FotoDTO(entity));
        }
        return list;
    }

}
