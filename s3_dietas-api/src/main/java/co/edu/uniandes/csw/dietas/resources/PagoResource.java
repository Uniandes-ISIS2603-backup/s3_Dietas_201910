/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.resources;

import co.edu.uniandes.csw.dietas.dtos.PagoDTO;
import co.edu.uniandes.csw.dietas.ejb.PagoLogic;
import co.edu.uniandes.csw.dietas.entities.PagoEntity;
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
 * @author Alejandra Bravo
 */
@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
    private static final Logger LOGGER = Logger.getLogger(PagoResource.class.getName());
    
    @Inject
    private PagoLogic logica;
    
    @POST
    public PagoDTO createPago(PagoDTO pago)throws BusinessLogicException{
        PagoEntity pagoEntity = pago.toEntity();
        pagoEntity = logica.createPago(pagoEntity);
       return new PagoDTO(pagoEntity); 
    }
    
    @GET
    @Path("{pagosId: \\d+}")
    public PagoDTO getPago(@PathParam("id") Long pagosId){
        PagoEntity pago = logica.getPago(pagosId);
        if(pago == null){
            throw new WebApplicationException("El recurso /pagos/"+pagosId+" no existe.", 404);
        }
        return new PagoDTO(pago);
    }
    
    @GET
    public List<PagoDTO> getPagos(){
        List<PagoDTO> listaPagos = listEntity2DetailDTO(logica.getPagos());
        return listaPagos;
    }
    
//    @PUT
//    @Path("{pagosId: \\d+}")
//    public PagoDTO updatePago(@PathParam("pagosId") Long pagosId, PagoDTO pago){
//        return null;
//    }
//    
//    @DELETE
//    @Path("{pagosId: \\d+}")
//    public void deletePago(@PathParam("pagosId") Long pagosId){
//        
//    }
    
    private List<PagoDTO> listEntity2DetailDTO(List<PagoEntity> entityList) {
        List<PagoDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDTO(entity));
        }
        return list;
    }
}
