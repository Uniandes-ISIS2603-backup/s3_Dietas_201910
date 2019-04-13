/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.SemanaDTO;
import co.edu.uniandes.csw.dietas.ejb.DietaSemanasLogic;
import co.edu.uniandes.csw.dietas.ejb.SemanaLogic;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 *Clase que asocia las semanas a una dieta creada.
 * @author Juan Antonio Restrepo
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DietaSemanasResource {
    
    private static final Logger LOGGER = Logger.getLogger(DietaSemanasResource.class.getName());

    @Inject
    private DietaSemanasLogic dietaSemanaLogic;

    @Inject
    private SemanaLogic semanaLogic;

    /**
     * Asocia una suspension existente con una dieta existente
     *
     * @param semanasId El ID de la suspension que se va a asociar
     * @param dietasId El ID de la dieta al cual se le va a asociar la suspension
     * @return JSON {@link SuspensionDetailDTO} - La suspension asociado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @POST
    @Path("{semanasId: \\d+}")
    public SemanaDTO addSuspension(@PathParam("dietasId") Long dietasId, @PathParam("semanasId") Long semanasId) {
        if (semanaLogic.getSemana(semanasId) == null) {
            throw new WebApplicationException("El recurso /semanas/" + semanasId + " no existe.", 404);
        }
        SemanaDTO dto = new SemanaDTO(dietaSemanaLogic.addSemana(dietasId, semanasId));
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
    public List<SemanaDTO> getSemanas(@PathParam("dietasId") Long dietasId) {
        List<SemanaDTO> lista = semanaListEntity2DTO(dietaSemanaLogic.getSemanas(dietasId));
        return lista;
    }

    /**
     * Busca y devuelve la suspension con el ID recibido en la URL, relativo a una dieta.
     *
     * @param semanasId El ID de la suspension que se busca
     * @param dietasId El ID de la dieta del cual se busca la suspension
     * @return {@link SuspensionDTO} - La suspension encontrada en la dieta.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @GET
    @Path("{semanasId: \\d+}")
    public SemanaDTO getSemanas(@PathParam("dietasId") Long dietasId, @PathParam("semanasId") Long semanasId) {
        if (semanaLogic.getSemana(semanasId) == null) {
            throw new WebApplicationException("El recurso /semanas/" + semanasId + " no existe.", 404);
        }
        SemanaDTO detailDTO = new SemanaDTO(dietaSemanaLogic.getSemana(dietasId, semanasId));
        return detailDTO;
    }

    /**
     * Actualiza la lista de suspensiones de una dieta con la lista que se recibe en
     * el cuerpo.
     *
     * @param dietasId El ID de la dieta al cual se le va a asociar la lista de
     * suspensiones
     * @param semanas JSONArray {@link SuspensionDTO} - La lista de suspensiones
     * que se desea guardar.
     * @return JSONArray {@link SuspensionDTO} - La lista actualizada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     */
    @PUT
    public List<SemanaDTO> replaceSemanas(@PathParam("dietasId") Long dietasId, List<SemanaDTO> semanas) {
        for (SemanaDTO semana : semanas) {
            if (semanaLogic.getSemana(semana.getId()) == null) {
                throw new WebApplicationException("El recurso /semanas/" + semana.getId() + " no existe.", 404);
            }
        }
        List<SemanaDTO> lista = semanaListEntity2DTO(dietaSemanaLogic.replaceSemanas(dietasId, semanaListDTO2Entity(semanas)));
        return lista;
    }

    /**
     * Elimina la conexión entre la suspension y la dieta recibidos en la URL.
     *
     * @param dietasId El ID de la dieta al cual se le va a desasociar la suspension
     * @param susemanasId El ID de la suspension que se desasocia
     * @throws co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la suspension.
     * La suspensión se elimina después de haber sido desasociada
     */
    @DELETE
    @Path("{semanasId: \\d+}")
    public void removeSemana(@PathParam("dietasId") Long dietasId, @PathParam("semanasId") Long semanasId) throws BusinessLogicException{
        if (semanaLogic.getSemana(semanasId) == null) {
            throw new WebApplicationException("El recurso /semanas/" + semanasId + " no existe.", 404);
        }
        dietaSemanaLogic.removeSemana(dietasId, semanasId);
        semanaLogic.deleteSemana(semanasId);
    }

    /**
     * Convierte una lista de SuspensionEntity a una lista de SuspensionDTO.
     *
     * @param entityList Lista de SuspensionEntity a convertir.
     * @return Lista de SuspensionDTO convertida.
     */
    private List<SemanaDTO> semanaListEntity2DTO(List<SemanaEntity> entityList) {
        List<SemanaDTO> list = new ArrayList<>();
        for (SemanaEntity entity : entityList) {
            list.add(new SemanaDTO(entity));
        }
        return list;
    }
    /**
     * Convierte una lista de SuspensionDTO a una lista de SuspensionEntity.
     *
     * @param dtos Lista de SuspensionDTO a convertir.
     * @return Lista de SuspensionEntity convertida.
     */
    private List<SemanaEntity> semanaListDTO2Entity(List<SemanaDTO> dtos) {
        List<SemanaEntity> list = new ArrayList<>();
        for (SemanaDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
