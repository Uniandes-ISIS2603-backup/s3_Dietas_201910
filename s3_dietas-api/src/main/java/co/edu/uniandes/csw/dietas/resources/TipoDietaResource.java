/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

/**
 *
 * @author estudiante
 */
import co.edu.uniandes.csw.dietas.dtos.TipoDietaDTO;
import co.edu.uniandes.csw.dietas.ejb.TipoDietaLogic;
import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
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
@Path("tipoDietas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class TipoDietaResource {
    private static final Logger LOGGER =Logger.getLogger(TipoDietaResource.class.getName());
    
    @Inject
    private TipoDietaLogic tipoDietaLogic;
            
    @POST
    public TipoDietaDTO crearTipoDieta(TipoDietaDTO tipoDietaDTO) throws BusinessLogicException
    {
        TipoDietaEntity entidad = tipoDietaDTO.toEntity();
        entidad= tipoDietaLogic.createTipoDieta(entidad);
        return tipoDietaDTO;
    }
    @GET
    public List<TipoDietaDTO> getTipoDietas(){
        List<TipoDietaDTO> listTipos = listEntity2DTO(tipoDietaLogic.getTipoDietas());
        return listTipos;
    }
    
    @GET
    @Path("{tipoDietasId:\\d+}")
    public TipoDietaDTO getTipoDieta(@PathParam("tipoDietasId") Long tipoDietasId){
        TipoDietaEntity entity = tipoDietaLogic.getTipoDieta(tipoDietasId);
        if(entity == null){
            throw new WebApplicationException("El recurso /tipoDietas/" + tipoDietasId + "no existe", 404);
        }
        return new TipoDietaDTO(entity);
    }
    
    
    
    private List<TipoDietaDTO> listEntity2DTO(List<TipoDietaEntity> entityList) {
        List<TipoDietaDTO> list = new ArrayList<>();
        for (TipoDietaEntity entity : entityList) {
            list.add(new TipoDietaDTO(entity));
        }
        return list;
    }
    @PUT
    @Path("{tipoDietasId: \\d+}")
    public TipoDietaDTO updateHall(@PathParam("tipoDietasId") Long tipoDietasId, TipoDietaDTO tipoDieta){
        tipoDieta.setId(tipoDietasId);
        if (tipoDietaLogic.getTipoDieta(tipoDietasId) == null) {
            throw new WebApplicationException("El recurso /tipoDietas/" + tipoDietasId + " no existe.", 404);
        }
        TipoDietaDTO detailDTO = new TipoDietaDTO(tipoDietaLogic.updateTipoDieta(tipoDietasId, tipoDieta.toEntity()));
        return detailDTO;
    }
    
    @DELETE
    @Path("{tipoDietasId: \\d+}")
    public void deleteHall(@PathParam("tipoDietasId") Long tipoDietasId) throws BusinessLogicException{
        if (tipoDietaLogic.getTipoDieta(tipoDietasId) == null) {
            throw new WebApplicationException("El recurso /tipoDietas/" + tipoDietasId + " no existe.", 404);
        }
        tipoDietaLogic.deleteTipoDieta(tipoDietasId);
    }
}
