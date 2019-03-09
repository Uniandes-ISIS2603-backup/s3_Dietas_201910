/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

/**
 *
 * @author estudiante
 */
import co.edu.uniandes.csw.dietas.dtos.TipoDietaDTO;
import co.edu.uniandes.csw.dietas.ejb.TipoDietaLogic;
import co.edu.uniandes.csw.dietas.entities.TipoDietaEntity;
    import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Juan Antonio Restrepo
 */
@Path("tipoDieta")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class TipoDietaResource {
    private static final Logger LOGGER =Logger.getLogger(TipoDietaResource.class.getName());
    
    @Inject
    private TipoDietaLogic tipoDietaLogic;
            
    @POST
    public TipoDietaDTO crearSemana(TipoDietaDTO tipoDietaDTO){
        TipoDietaEntity entidad = tipoDietaDTO.toEntity();
        return tipoDietaDTO;
    }
}
