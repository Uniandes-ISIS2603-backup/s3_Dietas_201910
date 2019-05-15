/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.DiaDTO;
import co.edu.uniandes.csw.dietas.dtos.DiaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.DiaLogic;
import co.edu.uniandes.csw.dietas.entities.DiaEntity;
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
@Path("dias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DiaResource {
    private static final Logger LOGGER =Logger.getLogger(SemanaResource.class.getName());
    @Inject
    private DiaLogic diaLogic;
    
    @POST
    public DiaDTO crearDia(DiaDTO dia ) throws BusinessLogicException
    {
        DiaEntity entidad = dia.toEntity();
        entidad =diaLogic.createDia(entidad);
        DiaDTO diaDTO = new DiaDTO(entidad);
        return new  DiaDTO(entidad);
    }
    
    
    @GET
    public List<DiaDetailDTO> getDias(){
        List<DiaDetailDTO> darDias = listaEntity2DTO(diaLogic.getDias());
        return darDias;
   
    }
    @GET
    @Path("{diasId:\\d+}")
    public DiaDetailDTO getDia(@PathParam("diasId") Long diaId){
        DiaEntity buscado = diaLogic.getDia(diaId);
        if(buscado == null)
        {
            throw new WebApplicationException("El recurso /dias/" + diaId + " no existe.", 404);
        }
        return new DiaDetailDTO(buscado);
    }
    
    @PUT 
    @Path("{diasId: \\d+}")
    public DiaDetailDTO updateDia(@PathParam("diasId")Long diasId, DiaDetailDTO dia){
       dia.setId(diasId);
       if(diaLogic.getDia(diasId) == null){
           throw new WebApplicationException("El recurso /dias/" +diasId + " no existe" , 404);
       }
       DiaDetailDTO diaUpdateado = new DiaDetailDTO(diaLogic.updateDia(diasId, dia.toEntity()));
       return diaUpdateado;
    }
    
    @DELETE
    @Path("{diasId: \\d+}")
    public void deleteDia(@PathParam("diasId")Long diaId) throws BusinessLogicException
    {
        if(diaLogic.getDia(diaId) == null)
        {
            throw new WebApplicationException("El recurso /dias/" + diaId + "no existe", 404);
        }
        diaLogic.deleteDia(diaId);
    }
    /**
     * Método que me permite pasar toda una lista de entidades a una lista de DTOs
     * @param entityList lista de las entidades que se desean cambiar.
     * @return  lista de ahora los DTOs en vez de las entidades.
     */
    private List<DiaDetailDTO> listaEntity2DTO(List<DiaEntity> entityList){
        List<DiaDetailDTO> lista = new ArrayList<>();
        for(DiaEntity entidad : entityList){
            lista.add(new DiaDetailDTO(entidad));
        }
        return lista;
    }
    
    
}
