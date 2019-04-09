/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.SuspensionDTO;
import co.edu.uniandes.csw.dietas.ejb.DietaSuspensionesLogic;
import co.edu.uniandes.csw.dietas.ejb.SuspensionLogic;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
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
 * @author Alejandra Bravoa
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DietaSuspensionesResource {
    
    private static final Logger LOGGER = Logger.getLogger(DietaSuspensionesResource.class.getName());

    @Inject
    private DietaSuspensionesLogic dietaSuspensionLogic;

    @Inject
    private SuspensionLogic suspensionLogic;

    /**
     * Asocia una suspension existente con una dieta existente
     *
     * @param suspensionesId El ID de la suspension que se va a asociar
     * @param dietasId El ID de la dieta al cual se le va a asociar la suspension
     * @return JSON {@link SuspensionDetailDTO} - La suspension asociado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @POST
    @Path("{suspensionesId: \\d+}")
    public SuspensionDTO addSuspension(@PathParam("dietasId") Long dietasId, @PathParam("suspensionesId") Long suspensionesId) {
        if (suspensionLogic.getSuspension(suspensionesId) == null) {
            throw new WebApplicationException("El recurso /suspensiones/" + suspensionesId + " no existe.", 404);
        }
        SuspensionDTO dto = new SuspensionDTO(dietaSuspensionLogic.addAuthor(dietasId, suspensionesId));
        return dto;
    }

    /**
     * Busca y devuelve todas las suspensiones que existen en una dieta.
     *
     * @param dietasId El ID de la dieta del cual se buscan las suspensiones
     * @return JSONArray {@link SuspensionDTO} - Las suspensiones encontradas en la
     * dieta. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<SuspensionDTO> getAuthors(@PathParam("dietasId") Long dietasId) {
        List<SuspensionDTO> lista = suspensionListEntity2DTO(dietaSuspensionLogic.getSuspensiones(dietasId));
        return lista;
    }

    /**
     * Busca y devuelve la suspension con el ID recibido en la URL, relativo a una dieta.
     *
     * @param suspensionesId El ID de la suspension que se busca
     * @param dietasId El ID de la dieta del cual se busca la suspension
     * @return {@link SuspensionDTO} - La suspension encontrada en la dieta.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @GET
    @Path("{suspensionesId: \\d+}")
    public SuspensionDTO getAuthor(@PathParam("dietasId") Long dietasId, @PathParam("suspensionesId") Long suspensionesId) {
        if (suspensionLogic.getSuspension(suspensionesId) == null) {
            throw new WebApplicationException("El recurso /suspensiones/" + suspensionesId + " no existe.", 404);
        }
        SuspensionDTO detailDTO = new SuspensionDTO(dietaSuspensionLogic.getSuspension(dietasId, suspensionesId));
        return detailDTO;
    }

    /**
     * Actualiza la lista de suspensiones de una dieta con la lista que se recibe en
     * el cuerpo.
     *
     * @param dietasId El ID de la dieta al cual se le va a asociar la lista de
     * suspensiones
     * @param suspensiones JSONArray {@link SuspensionDTO} - La lista de suspensiones
     * que se desea guardar.
     * @return JSONArray {@link SuspensionDTO} - La lista actualizada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @PUT
    public List<SuspensionDTO> replaceSuspensiones(@PathParam("dietasId") Long dietasId, List<SuspensionDTO> suspensiones) {
        for (SuspensionDTO suspension : suspensiones) {
            if (suspensionLogic.getSuspension(suspension.getId()) == null) {
                throw new WebApplicationException("El recurso /suspensiones/" + suspension.getId() + " no existe.", 404);
            }
        }
        List<SuspensionDTO> lista = suspensionListEntity2DTO(dietaSuspensionLogic.replaceSuspensiones(dietasId, suspensionListDTO2Entity(suspensiones)));
        return lista;
    }

    /**
     * Elimina la conexión entre la suspension y la dieta recibidos en la URL.
     *
     * @param dietasId El ID de la dieta al cual se le va a desasociar la suspension
     * @param suspensionesId El ID de la suspension que se desasocia
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     * La suspensión se elimina después de haber sido desasociada
     */
    @DELETE
    @Path("{suspensionesId: \\d+}")
    public void removeSuspension(@PathParam("dietasId") Long dietasId, @PathParam("suspensionesId") Long suspensionesId) throws BusinessLogicException{
        if (suspensionLogic.getSuspension(suspensionesId) == null) {
            throw new WebApplicationException("El recurso /suspensiones/" + suspensionesId + " no existe.", 404);
        }
        dietaSuspensionLogic.removeSuspension(dietasId, suspensionesId);
        suspensionLogic.deleteSuspension(suspensionesId);
    }

    /**
     * Convierte una lista de SuspensionEntity a una lista de SuspensionDTO.
     *
     * @param entityList Lista de SuspensionEntity a convertir.
     * @return Lista de SuspensionDTO convertida.
     */
    private List<SuspensionDTO> suspensionListEntity2DTO(List<SuspensionEntity> entityList) {
        List<SuspensionDTO> list = new ArrayList<>();
        for (SuspensionEntity entity : entityList) {
            list.add(new SuspensionDTO(entity));
        }
        return list;
    }
    /**
     * Convierte una lista de SuspensionDTO a una lista de SuspensionEntity.
     *
     * @param dtos Lista de SuspensionDTO a convertir.
     * @return Lista de SuspensionEntity convertida.
     */
    private List<SuspensionEntity> suspensionListDTO2Entity(List<SuspensionDTO> dtos) {
        List<SuspensionEntity> list = new ArrayList<>();
        for (SuspensionDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
