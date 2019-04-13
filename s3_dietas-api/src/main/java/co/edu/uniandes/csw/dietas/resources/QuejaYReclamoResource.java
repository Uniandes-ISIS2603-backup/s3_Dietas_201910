/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.QuejaYReclamoDTO;
import co.edu.uniandes.csw.dietas.ejb.QuejaYReclamoLogic;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
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
 * @author Daniel Espitia
 */
@Path("quejasYReclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejaYReclamoResource {
    private static final Logger LOGGER = Logger.getLogger(PersonaResource.class.getName());
  
    @Inject
    
    private QuejaYReclamoLogic logica;
    
    //hola mundo
    
    @POST
    public QuejaYReclamoDTO createQuejaYReclamo(QuejaYReclamoDTO queja)throws BusinessLogicException{
        QuejaYReclamoEntity quejaEntity = queja.toEntity();
        quejaEntity = logica.createQuejaYReclamo(quejaEntity);
       return new QuejaYReclamoDTO(quejaEntity); 
    }
      @GET
    public List<QuejaYReclamoDTO> getQuejasYReclamos(){
        List<QuejaYReclamoDTO> listaQuejas = listEntity2DetailDTO(logica.getQuejasYReclamos());
        return listaQuejas;
    }
    
    @GET
    @Path("{quejasId: \\d+}")
    public QuejaYReclamoDTO getQuejaYReclamo(@PathParam("quejasId") Long quejasId){
        QuejaYReclamoEntity queja = logica.getQuejaYReclamo(quejasId);
        if(queja == null){
            throw new WebApplicationException("El recurso /quejas/"+quejasId+" no existe.", 404);
        }
        return new QuejaYReclamoDTO(queja);
    }
    
 
    
    @PUT
    @Path("{quejasId: \\d+}")
    public QuejaYReclamoDTO updateQuejaYReclamo(@PathParam("quejasId") Long quejasId, QuejaYReclamoDTO queja){
        queja.setId(quejasId);
        if (logica.getQuejaYReclamo(quejasId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejasId + " no existe.", 404);
        }
        QuejaYReclamoDTO quejaDTO = new QuejaYReclamoDTO(logica.updateQuejaYReclamo(quejasId, queja.toEntity()));
        return quejaDTO;
    }
    
    @DELETE
    @Path("{pagosId: \\d+}")
    public void deleteQuejaYReclamo(@PathParam("quejasId") Long quejasId)throws BusinessLogicException{
        if (logica.getQuejaYReclamo(quejasId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejasId + " no existe.", 404);
        }
        logica.deleteQuejaYReclamo(quejasId);
    }
    
    private List<QuejaYReclamoDTO> listEntity2DetailDTO(List<QuejaYReclamoEntity> entityList) {
        List<QuejaYReclamoDTO> list = new ArrayList<>();
        for (QuejaYReclamoEntity entity : entityList) {
            list.add(new QuejaYReclamoDTO(entity));
        }
        return list;
    }
}