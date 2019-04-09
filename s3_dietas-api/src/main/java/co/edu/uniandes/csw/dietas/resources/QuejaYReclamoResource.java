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
    
    @POST
    public QuejaYReclamoDTO createPersona(QuejaYReclamoDTO quejaParam){
       return quejaParam; 
    }
//    @DELETE
//    @Path("{quejaYReclamoId: \\d+}")
//    public void deletepersona(@PathParam("quejaYReclamoId") Long quejaYReclamoId){
//        
//    }
       
    
    @Inject
    private QuejaYReclamoLogic logica;
    
    @POST
    public QuejaYReclamoDTO createQuejaYReclamo(QuejaYReclamoDTO queja)throws BusinessLogicException{
        QuejaYReclamoEntity quejaEntity = queja.toEntity();
        quejaEntity = logica.createQuejaYReclamo(quejaEntity);
       return new QuejaYReclamoDTO(quejaEntity); 
    }
    
    @GET
    
    @Path("{quejaId: \\d+}")
    public QuejaYReclamoDTO getQuejaYReclamo(@PathParam("quejaId") Long quejaId){
        QuejaYReclamoEntity queja = logica.getQuejaYReclamo(quejaId);
        if(queja == null){
            throw new WebApplicationException("El recurso /quejas/"+quejaId+" no existe.", 404);
        }
        return new QuejaYReclamoDTO(queja);
    }
    
    @GET
    public List<QuejaYReclamoDTO> getQuejaYReclamo(){
        List<QuejaYReclamoDTO> listaQuejas = listEntity2DetailDTO(logica.getQuejaYReclamo());
        return listaQuejas;
    }
    
    @PUT
    @Path("{quejaId: \\d+}")
    public QuejaYReclamoDTO updateQuejaYReclamo(@PathParam("quejaId") Long quejaId, QuejaYReclamoDTO queja){
        queja.setId(quejaId);
        if (logica.getQuejaYReclamo(quejaId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejaId + " no existe.", 404);
        }
        QuejaYReclamoDTO quejaDTO = new QuejaYReclamoDTO(logica.updateQuejaYReclamo(quejaId, queja.toEntity()));
        return quejaDTO;
    }
    
    @DELETE
    @Path("{quejaId: \\d+}")
    public void deleteQuejaYReclamo(@PathParam("quejaId") Long quejaId)throws BusinessLogicException{
        if (logica.getQuejaYReclamo(quejaId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejaId + " no existe.", 404);
        }
        logica.deleteQuejaYReclamo(quejaId);
    }
    
    private List<QuejaYReclamoDTO> listEntity2DetailDTO(List<QuejaYReclamoEntity> entityList) {
        List<QuejaYReclamoDTO> list = new ArrayList<>();
        for (QuejaYReclamoEntity entity : entityList) {
            list.add(new QuejaYReclamoDTO(entity));
        }
        return list;
    }
}