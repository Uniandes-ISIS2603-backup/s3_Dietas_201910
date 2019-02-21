/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.DiaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Path("dia")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DiaResource {
    private static final Logger LOGGER =Logger.getLogger(SemanaResource.class.getName());
    
    @POST
    public DiaDTO crearDia(DiaDTO dia ){
        return dia;
    }
    
}