/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.PersonaDetail;
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

@Path("persona")
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
    public List<PersonaDetail> getDietas(){
        return null;
    }
    
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getPersona(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getTipo(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{name: [a-zA-Z][a-zA-Z]*}")
    public PersonaDetail getNombre(@PathParam("personaId") Long personaId){
        return null;
    }
   
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getFechaIngreso(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getObjetivos(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getTiempoEsperadoMejora(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getSolicitudEspecial(@PathParam("personaId") Long personaId){
        return null;
    }
    @GET
    @Path("{personaId: \\d+}")
    public PersonaDetail getTarjetaFidelidad(@PathParam("personaId") Long personaId){
        return null;
    }
    
    @GET
    @Path("{name: [a-zA-Z][a-zA-Z]*}")
    public PersonaDetail getObjetivos(@PathParam("personaId") String personaObejtivos){
        return null;
    }
    
//    @PUT
//    @Path("{dietasId: \\d+}")
//    public DietaDetailDTO updateDieta(@PathParam("dietasId") Long dietasId, DietaDTO dieta){
//        return null;
//    }
    
    @DELETE
    @Path("{dietasId: \\d+}")
    public void deletepersona(@PathParam("personaId") Long dietasId){
        
    }
    
}
