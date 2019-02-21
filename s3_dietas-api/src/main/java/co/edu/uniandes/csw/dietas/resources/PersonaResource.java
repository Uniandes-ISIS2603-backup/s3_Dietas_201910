/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    
    @POST
    public PersonaDTO createPersona(PersonaDTO personaParam){
       return personaParam; 
    }
    
    @GET
    public List<PersonaDTO> getDietas(){
        return null;
    }
    
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getPersona(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getTipo(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{name: [a-zA-Z][a-zA-Z]*}")
    public PersonaDTO getNombre(@PathParam("personaId") Long personaId){
        return null;
    }
   
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getFechaIngreso(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getObjetivos(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getTiempoEsperadoMejora(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getSolicitudEspecial(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDTO getTarjetaFidelidad(@PathParam("personaId") Long personaId){
        return null;
    }
        
    @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateObjetivos(@PathParam("personaId") Long personaId, String objetivos){
        return null;
    }
       @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateTiempoEsperadoMejora(@PathParam("personaId") Long personaId, int tiempo){
        return null;
    }
        @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateSolicitudEspecial(@PathParam("personaId") Long personaId, boolean variable ){
        return null;
    }
        @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateTarjetaFidelidad(@PathParam("personaId") Long personaId, boolean variable){
        return null;
    }
        @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateFotos(@PathParam("personaId") Long personaId, String fotos){
        return null;
    }
        @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateCalificaciones(@PathParam("personaId") Long personaId, Integer[] calificacion){
        return null;
    }
            @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateComentarios(@PathParam("personaId") Long personaId, String comentario){
        return null;
    }
            @PUT
    @Path("{personaId: \\d+}")
    public PersonaDTO updateQuejasYReclamos(@PathParam("personaId") Long personaId, String QuejaYReclamo){
        return null;
    }
    @DELETE
    @Path("{personId: \\d+}")
    public void deletepersona(@PathParam("personaId") Long personaId){
        
    }
    
}
