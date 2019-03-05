/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.FotoPersistence;
import static co.edu.uniandes.csw.dietas.persistence.SemanaPersistence.LOGGER;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author Louis Gualtero
 */
@Stateless
public class FotoLogic {
    
     @Inject
    private FotoPersistence persistence;
    
    /**
     * Crea una foto en la persistencia.
     *
     * @param foto La entidad que representa la foto a
     * persistir.
     * @return La entiddad de la foto luego de persistirla.
     * @throws BusinessLogicException Si la foto a persistir ya existe.
     */
    public FotoEntity createFoto(FotoEntity foto) throws BusinessLogicException{
        
         if (persistence.findByName(foto.getNombre()) != null)  {
            throw new BusinessLogicException("Ya existe una Foto con el name \"" + foto.getNombre() + "\"");
        }
         // Invoca la persistencia para crear la foto
        foto=persistence.create(foto);
        return foto;
    }
    
    public FotoEntity getFoto(Long fotoId){
        FotoEntity fotoE = persistence.findById(fotoId);
        if(fotoE == null){
            LOGGER.log(Level.SEVERE, "La foto con el id = {0} no existe", fotoId);
        }
        return fotoE;
    }
     
      public List<FotoEntity> getFotos() {
        List<FotoEntity> fotos = persistence.findAll();
        return fotos;
    }
      
      public FotoEntity updateFoto(Long fotoId, FotoEntity fotoEntity) {
        FotoEntity newFotoEntity = persistence.update(fotoEntity);
        return newFotoEntity;
    }
    
    public void deleteFoto(Long fotosId) throws BusinessLogicException {
        persistence.delete(fotosId);
    } 
}
