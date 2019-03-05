/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.ComidaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import co.edu.uniandes.csw.dietas.ejb.ComidaLogic;
import co.edu.uniandes.csw.dietas.entities.ComidaEntity;
import javax.ws.rs.PathParam;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.ws.rs.GET;


/**
 *
 * @author Louis Gualtero
 */
@Path("comidas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ComidaResource {
    
    @Inject
    private ComidaLogic comidaLogic;
    
    private static final Logger LOGGER = Logger.getLogger(ComidaResource.class.getName());
     
    @POST
    public ComidaDTO crearComida(ComidaDTO comida) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "ComidaResource createComida: input: {0}", comida);
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ComidaEntity comidaEntity = comida.toEntity();
        // Invoca la lógica para crear la comida nueva
        ComidaEntity nuevoComidaEntity = comidaLogic.createComida(comidaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        ComidaDTO nuevoComidaDTO = new ComidaDTO(nuevoComidaEntity);
        LOGGER.log(Level.INFO, "ComidaResource createComida: output: {0}", nuevoComidaDTO);
        return nuevoComidaDTO;
    }
    }
