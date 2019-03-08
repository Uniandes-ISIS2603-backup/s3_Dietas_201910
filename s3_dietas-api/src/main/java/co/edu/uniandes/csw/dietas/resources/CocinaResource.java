/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;
import co.edu.uniandes.csw.dietas.dtos.CocinaDTO;
import co.edu.uniandes.csw.dietas.ejb.CocinaLogic;
import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
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
 * @author  Andrea Montoya Serje.
 */
@Path("cocinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CocinaResource 
{
    private static final Logger LOGGER = Logger.getLogger(CocinaResource.class.getName());
    
      @Inject
    private CocinaLogic cocinaLogic;
    
    
    
    @POST
    public CocinaDTO createCocina(CocinaDTO cocina) throws BusinessLogicException{
        CocinaEntity cocinaEntity = cocina.toEntity();
        cocinaEntity = cocinaLogic.createCocina(cocinaEntity);
        CocinaDTO cocinaDTO = new CocinaDTO(cocinaEntity);
        return cocinaDTO; 
    }
   
     @GET
    @Path("{CocinasId: \\d+}")
    public CocinaDTO getCocina(@PathParam("CocinasId") Long cocinasId){
        CocinaEntity cocina = cocinaLogic.getCocina(cocinasId);
        if(cocina == null){
            throw new WebApplicationException("El recurso /cocinas/"+cocinasId+" no existe.", 404);
        }
        return new CocinaDTO(cocina);
    }
    
    
       
     @GET
    public List<CocinaDTO> getCocinas(){
        List<CocinaDTO> list = listEntity2DetailDTO(cocinaLogic.getCocinas());
        return list;
    }
    
    private List<CocinaDTO> listEntity2DetailDTO(List<CocinaEntity> entityList) {
        List<CocinaDTO> list = new ArrayList<>();
        for (CocinaEntity entity : entityList) {
            list.add(new CocinaDTO(entity));
        }
        return list;
    }
    
    
     
    @PUT
    @Path("{cocinasId: \\d+}")
    public CocinaDTO updateCocina(@PathParam("cocinasId") Long cocinasId, CocinaDTO cocina){
        cocina.setId(cocinasId);
        if (cocinaLogic.getCocina(cocinasId) == null) {
            throw new WebApplicationException("El recurso /cocina/" + cocinasId + " no existe.", 404);
        }
        CocinaDTO cocinaDTO = new CocinaDTO(cocinaLogic.updateCocina(cocinasId, cocina.toEntity()));
        return cocinaDTO;
    }
    
    
    @DELETE
    @Path("{cocinasId: \\d+}")
    public void deleteCocina(@PathParam("cocinasId") Long cocinasId)throws BusinessLogicException{
        if (cocinaLogic.getCocina(cocinasId) == null) {
            throw new WebApplicationException("El recurso /cocinas/" + cocinasId + " no existe.", 404);
        }
        cocinaLogic.deleteCocina(cocinasId);
    }
    
}
