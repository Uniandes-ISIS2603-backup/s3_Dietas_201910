/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.FotoPersistence;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Espitia
 */
@Stateless
public class FotoDePersonaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(FotoDePersonaLogic.class.getName());

    @Inject
    private PersonaPersistence personaPersistence;

    @Inject
    private FotoPersistence fotoPersistence;
    
    /**
     * Asocia una persona existente a un hall
     *
     * @param hallId Identificador de la instancia de Dieta
     * @param personasId Identificador de la instancia de Suspension
     * @return Instancia de PersonaEntity que fue asociada a hall
     */
    public FotoEntity addFoto(Long personaId, Long fotoId) {
        FotoEntity fotoEntity = fotoPersistence.findById(fotoId);
        PersonaEntity personaEntity = personaPersistence.findById(personaId);
        
        personaEntity.addFoto(fotoEntity);     
        
        
        return fotoPersistence.findById(fotoId);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de Hall
     *
     * @param hallsId Identificador de la instancia de Dieta
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de Hall
     */
    public List<FotoEntity> getFotos(Long fotoId) {
        return personaPersistence.findById(fotoId).getFotos();
    }
    
    /**
     * Obtiene una instancia de FotoEntity asociada a una instancia de Dieta
     *
     * @param personasId Identificador de la instancia de Dieta
     * @param fotosId Identificador de la instancia de Foto
     * @return La entidad de la Foto asociada a la persona
     */
    public FotoEntity getFoto(Long personasId, Long fotosId) {
        List<FotoEntity> fotos = personaPersistence.findById(personasId).getFotos();
        FotoEntity fotoEntity = fotoPersistence.findById(fotosId);
        int index = fotos.indexOf(fotoEntity);
        if (index >= 0) {
            return fotos.get(index);
        }
        return null;
    }
}
