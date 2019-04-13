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
  
    @Inject
    
    private QuejaYReclamoLogic logica;
    
    
    /**
     * Crea un nuevo Q&R con la informacion que se recibe en el cuerpo de la
     * petición y se regresa un objeto identico con un id auto-generado por la
     * base de datos.
     *
     * @param persona {@link Q&RDTO } - EL Q&R que se desea guardar.
     * @return JSON {@link Q&RDTO} - El Q&R guardado con el atributo id
     * autogenerado.
     */
    @POST
    public QuejaYReclamoDTO createQuejaYReclamo(QuejaYReclamoDTO queja)throws BusinessLogicException{
        QuejaYReclamoEntity quejaEntity = queja.toEntity();
        quejaEntity = logica.createQuejaYReclamo(quejaEntity);
       return new QuejaYReclamoDTO(quejaEntity); 
    }
    /**
     * Busca y devuelve todos los Q&R que existen en la aplicacion.
     *
     * @return JSONArray {@link Q&RDTO} - Los Q&R encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
      @GET
    public List<QuejaYReclamoDTO> getQuejasYReclamos(){
        List<QuejaYReclamoDTO> listaQuejas = listEntity2DetailDTO(logica.getQuejasYReclamos());
        return listaQuejas;
    }
      /**
     * Busca y devuelve LA Q&R que existen en la aplicacion.
     *
     * @return JSON {@link Q&RDTO} - LA Q&R ENCONTRADA en la
     * aplicación. Si no hay ninguno retorna una  vacía.
     */
    @GET
    @Path("{quejasId: \\d+}")
    public QuejaYReclamoDTO getQuejaYReclamo(@PathParam("quejasId") Long quejasId){
        QuejaYReclamoEntity queja = logica.getQuejaYReclamo(quejasId);
        if(queja == null){
            throw new WebApplicationException("El recurso /quejas/"+quejasId+" no existe.", 404);
        }
        return new QuejaYReclamoDTO(queja);
    }
    
         /**
     * Actualiza el PERSONA con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param QYRID Identificador del autor que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param QUEJA {@link Q&RDTO} El Q&R que se desea guardar.
     * @return JSON {@link Q&RDTO} - El Q&R guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el autor a
     * actualizar.
     */
    
    @PUT
    @Path("{quejasId: \\d+}")
    public QuejaYReclamoDTO updateQuejaYReclamo(@PathParam("quejasId") Long quejasId, QuejaYReclamoDTO queja){
        queja.setId(quejasId);
        if (logica.getQuejaYReclamo(quejasId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejasId + " no existe.", 404);
        }
        QuejaYReclamoDTO quejaDTO = new QuejaYReclamoDTO(logica.updateQuejaYReclamo(quejasId, queja.toEntity()));
        return quejaDTO;
    }
    
           /**
     * Borra el Q&R con el id asociado recibido en la URL.
     *
     * @param Q&RID Identificador del Q&R que se desea borrar. Este debe
     * ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     * si el autor tiene libros asociados
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra el PERSONA a borrar.
     */
    @DELETE
    @Path("{pagosId: \\d+}")
    public void deleteQuejaYReclamo(@PathParam("quejasId") Long quejasId)throws BusinessLogicException{
        if (logica.getQuejaYReclamo(quejasId) == null) {
            throw new WebApplicationException("El recurso /quejas/" + quejasId + " no existe.", 404);
        }
        logica.deleteQuejaYReclamo(quejasId);
    }
    
    private List<QuejaYReclamoDTO> listEntity2DetailDTO(List<QuejaYReclamoEntity> entityList) {
        List<QuejaYReclamoDTO> list = new ArrayList<>();
        for (QuejaYReclamoEntity entity : entityList) {
            list.add(new QuejaYReclamoDTO(entity));
        }
        return list;
    }
}