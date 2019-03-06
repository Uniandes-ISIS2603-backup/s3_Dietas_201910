/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.CocinaEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.CocinaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class CocinaLogic 
{
    @Inject
    private CocinaPersistence cocinaP;
    

    
    public CocinaEntity createCocina (CocinaEntity cocina) throws BusinessLogicException
    {
        if(cocinaP.findById( cocina.getId())!= null   ||  cocinaP.findByDirection(cocina.getDireccion()) != null )
        {
            throw new BusinessLogicException("Ya existe una cocina con ese id");
        }
        cocinaP.create(cocina);
        return cocina;
    }
    
    
    public CocinaEntity getCocina(Long cocinaId) {
        CocinaEntity cocinaEntity = cocinaP.findById(cocinaId);
        if (cocinaEntity == null) {
//            LOGGER.log(Level.SEVERE, "La cocina con el id = {0} no existe", cocinaId);
        }
        return cocinaEntity;
    }
    
    
    public List<CocinaEntity> getCocinas() {
        List<CocinaEntity> cocinas = cocinaP.findAll();
        return cocinas;
    }
 
     
     public void deleteCocina(Long cocinaId) throws BusinessLogicException {
        cocinaP.delete(cocinaId);
    }
    
}

