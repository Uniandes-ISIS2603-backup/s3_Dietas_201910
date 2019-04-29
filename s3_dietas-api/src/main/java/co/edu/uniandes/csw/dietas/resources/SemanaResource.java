/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.SemanaDTO;
import co.edu.uniandes.csw.dietas.dtos.SemanaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.SemanaLogic;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
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
 * @author Juan Antonio Restrepo
 */
@Path("semanas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class SemanaResource {
    private static final Logger LOGGER =Logger.getLogger(SemanaResource.class.getName());
    
    @Inject
    private SemanaLogic semanaLogic;
    
    @POST
    public SemanaDTO crearSemana(SemanaDTO semanaDTO) throws BusinessLogicException{
        SemanaEntity entidad = semanaDTO.toEntity();
        entidad =semanaLogic.createSemana(entidad);
        SemanaDTO semana = new SemanaDTO(entidad);
        return new SemanaDTO(entidad);
    }
    
     @GET
    public List<SemanaDTO> getSemanas(){
        List<SemanaDTO> darSemanas = listaEntity2DTO(semanaLogic.getSemanas());
        return darSemanas;
   
    }
    @GET
    @Path("{semanasId:\\d+}")
    public SemanaDetailDTO getSemana(@PathParam("semanasId") Long semanaId){
        SemanaEntity buscado = semanaLogic.getSemana(semanaId);
        if(buscado == null)
        {
            throw new WebApplicationException("El recurso /semanas/" + semanaId + " no existe.", 404);
        }
        return new SemanaDetailDTO(buscado);
    }
    
    @PUT 
    @Path("{semanasId: \\d+}")
    public SemanaDetailDTO updateSemana(@PathParam("semanasId")Long semanasId, SemanaDetailDTO semana){
       semana.setId(semanasId);
       if(semanaLogic.getSemana(semanasId) == null){
           throw new WebApplicationException("El recurso /semanas/" +semanasId + " no existe" , 404);
       }
       SemanaDetailDTO semanaUpdateado = new SemanaDetailDTO(semanaLogic.updateSemana(semanasId, semana.toEntity()));
       return semanaUpdateado;
    }
    
    @DELETE
    @Path("{semanasId: \\d+}")
    public void deleteSemana(@PathParam("semanasId")Long semanaId) throws BusinessLogicException
    {
        if(semanaLogic.getSemana(semanaId) == null)
        {
            throw new WebApplicationException("El recurso /semanas/" + semanaId + "no existe", 404);
        }
        semanaLogic.deleteSemana(semanaId);
    }
    /**
     * Método que me permite pasar toda una lista de entidades a una lista de DTOs
     * @param entityList lista de las entidades que se desean cambiar.
     * @return  lista de ahora los DTOs en vez de las entidades.
     */
    private List<SemanaDTO> listaEntity2DTO(List<SemanaEntity> entityList){
        List<SemanaDTO> lista = new ArrayList<>();
        for(SemanaEntity entidad : entityList){
            lista.add(new SemanaDetailDTO(entidad));
        }
        return lista;
    }
}
