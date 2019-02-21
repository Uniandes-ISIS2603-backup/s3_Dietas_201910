/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PersonaDTO;
import co.edu.uniandes.csw.dietas.dtos.QuejaYReclamoDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
}