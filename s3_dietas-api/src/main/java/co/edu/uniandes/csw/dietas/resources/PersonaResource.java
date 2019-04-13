/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.QuejaYReclamoDTO;
import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.ejb.QuejaYReclamoLogic;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
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
@Path("personas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PersonaResource {
    private static final Logger LOGGER = Logger.getLogger(PersonaResource.class.getName());
    
      @Inject
    
    private PersonaLogic logica;
    
    //hola mundo
    
    @POST
    public PersonaDTO createPersona(PersonaDTO persona)throws BusinessLogicException{
        PersonaEntity personaEntity = persona.toEntity();
        personaEntity = logica.createPersona(personaEntity);
       return new PersonaDTO(personaEntity); 
    }
      @GET
    public List<PersonaDTO> getPersonas(){
        List<PersonaDTO> listaPersonas = listEntity2DetailDTO(logica.getPersonas());
        return listaPersonas;
    }
    
    @GET
    @Path("{personasId: \\d+}")
    public PersonaDTO getPersona(@PathParam("personasId") Long personasId){
        PersonaEntity queja = logica.getPersona(personasId);
        if(queja == null){
            throw new WebApplicationException("El recurso /personas/"+personasId+" no existe.", 404);
        }
        return new PersonaDTO(queja);
    }
    
 
    
    @PUT
    @Path("{personasId: \\d+}")
    public PersonaDTO updatePersona(@PathParam("personasId") Long personasId, PersonaDTO queja){
        queja.setId(personasId);
        if (logica.getPersona(personasId) == null) {
            throw new WebApplicationException("El recurso /personas/" + personasId + " no existe.", 404);
        }
        PersonaDTO quejaDTO = new PersonaDTO(logica.updatePersona(personasId, queja.toEntity()));
        return quejaDTO;
    }
    
    @DELETE
    @Path("{personasId: \\d+}")
    public void deletePersona(@PathParam("personasId") Long personasId)throws BusinessLogicException{
        if (logica.getPersona(personasId) == null) {
            throw new WebApplicationException("El recurso /personas/" + personasId + " no existe.", 404);
        }
        logica.deletePersona(personasId);
    }
    
    private List<PersonaDTO> listEntity2DetailDTO(List<PersonaEntity> entityList) {
        List<PersonaDTO> list = new ArrayList<>();
        for (PersonaEntity entity : entityList) {
            list.add(new PersonaDTO(entity));
        }
        return list;
    }
}