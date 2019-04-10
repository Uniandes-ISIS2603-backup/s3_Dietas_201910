/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.PersonaDetailDTO;
import co.edu.uniandes.csw.dietas.ejb.PersonaLogic;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
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
    private PersonaLogic personaLogica;
   
    
    @POST
    public PersonaDTO createPersona(PersonaDTO persona)throws BusinessLogicException{
        PersonaEntity personaEntity = persona.toEntity();
        //personaEntity = personaLogica.createPersona(personaEntity);
       return new PersonaDTO(personaEntity);
    }
    
    @GET
    public List<PersonaDetailDTO> getPersonas(){
        //List<PersonaDetailDTO> listaDietas = listEntity2DTO(personaLogica.getPersonas());
        //return listaDietas;
        return null;
    }
    
    @GET
    
    @Path("{dietasId: \\d+}")
   
    public PersonaDetailDTO getPersona( @PathParam("PersonasId")Long personaId){
        PersonaEntity entidad = personaLogica.getPersona(personaId);
        if(entidad == null){
            throw new WebApplicationException("El recurso /personas/"+personaId+" no existe.", 404);
        }
        return new PersonaDetailDTO(entidad);    
    }
    
    @PUT
    @Path("{dietasId: \\d+}")
    public PersonaDetailDTO updatePersona(@PathParam("dietasId") Long personaId, PersonaDetailDTO persona) throws BusinessLogicException{
        persona.setId(personaId);
        if (personaLogica.getPersona(personaId) == null) {
            throw new WebApplicationException("El recurso /personas/" + personaId + " no existe.", 404);
        }
        PersonaDetailDTO detailDTO = new PersonaDetailDTO(personaLogica.updatePersona(personaId, persona.toEntity()));
        return detailDTO;
    }
    
    @DELETE
    @Path("{dietasId: \\d+}")
    public void deletePersona(@PathParam("dietasId") Long dietasId) throws BusinessLogicException{
        if (personaLogica.getPersona(dietasId) == null) {
            throw new WebApplicationException("El recurso /dietas/" + dietasId + " no existe.", 404);
        }
        personaLogica.deletePersona(dietasId);
    }
    
    private List<PersonaDetailDTO> listEntity2DTO(List<PersonaEntity> entityList) {
        List<PersonaDetailDTO> list = new ArrayList<>();
        for (PersonaEntity entity : entityList) {
            list.add(new PersonaDetailDTO(entity));
        }
        return list;
    }
}