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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}
