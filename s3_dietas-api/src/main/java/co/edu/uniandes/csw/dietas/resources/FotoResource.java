/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.FotoDTO;
import co.edu.uniandes.csw.dietas.ejb.FotoLogic;
import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
 * @author Louis Gualtero
 */

@Path("fotos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class FotoResource {
     private static final Logger LOGGER = Logger.getLogger(FotoResource.class.getName());
     
    @Inject
    private FotoLogic fotoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
     
     @POST
     public FotoDTO crearFoto(FotoDTO foto) throws BusinessLogicException{
          LOGGER.log(Level.INFO, "FotoResource createFoto: input: {0}", foto);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        FotoEntity fotoEntity = foto.toEntity();
        // Invoca la lógica para crear la foto nueva
        FotoEntity nuevoFotoEntity = fotoLogic.createFoto(fotoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        FotoDTO nuevoFotoDTO = new FotoDTO(nuevoFotoEntity);
        LOGGER.log(Level.INFO, "FotoResource createFoto: output: {0}", nuevoFotoDTO);
        return nuevoFotoDTO;
     }
     
     @GET
    @Path("{fotosId: \\d+}")
    public FotoDTO getFoto(@PathParam("fotosId") Long fotosId){
        FotoEntity foto = fotoLogic.getFoto(fotosId);
        if(foto == null){
            throw new WebApplicationException("El recurso /fotos/"+fotosId+" no existe.", 404);
        }
        return new FotoDTO(foto);
    }
    
    
    @GET
    public List<FotoDTO> getFotos(){
        List<FotoDTO> listaFotos = listEntity2DetailDTO(fotoLogic.getFotos());
        return listaFotos;
    }
    
    @PUT
    @Path("{fotosId: \\d+}")
    public FotoDTO updateFoto(@PathParam("fotosId") Long fotosId, FotoDTO foto){
        foto.setId(fotosId);
        if (fotoLogic.getFoto(fotosId) == null) {
            throw new WebApplicationException("El recurso /fotos/" + fotosId + " no existe.", 404);
        }
        FotoDTO fotoDTO = new FotoDTO(fotoLogic.updateFoto(fotosId, foto.toEntity()));
        return fotoDTO;
    }
    
    @DELETE
    @Path("{fotosId: \\d+}")
    public void deleteFoto(@PathParam("fotosId") Long fotosId)throws BusinessLogicException{
        if (fotoLogic.getFoto(fotosId) == null) {
            throw new WebApplicationException("El recurso /fotos/" + fotosId + " no existe.", 404);
        }
        fotoLogic.deleteFoto(fotosId);
    }
    
    private List<FotoDTO> listEntity2DetailDTO(List<FotoEntity> entityList) {
        List<FotoDTO> list = new ArrayList<>();
        for (FotoEntity entity : entityList) {
            list.add(new FotoDTO(entity));
        }
        return list;
    }
}
