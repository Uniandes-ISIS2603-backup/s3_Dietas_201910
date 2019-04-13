/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;
import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.persistence.CalificacionYComentarioPersistence;
import co.edu.uniandes.csw.dietas.persistence.PersonaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrea Montoya
 */
@Stateless
public class CalificacionYComentarioDePersonaLogic {
    
    
         private static final Logger LOGGER = Logger.getLogger(CalificacionYComentarioDePersonaLogic.class.getName());

    @Inject
    private PersonaPersistence personaPersistence;

    @Inject
    private CalificacionYComentarioPersistence calificacionycomentarioPersistence;
    
    /**
     * Asocia una persona existente a una CalificacionYComentario
     *
     * @param CalificacionYComentario Identificador de la instancia de cyc
     * @param personasId Identificador de la instancia de persona
     * @return Instancia de PersonaEntity que fue asociada a CalificacionYComentario
     */
    public CalificacionYComentarioEntity addCalificacionYComentario(Long personaId, Long cycId) {
        CalificacionYComentarioEntity calificacionYcomentarioEntity = calificacionycomentarioPersistence.findById(cycId);
        PersonaEntity personaEntity = personaPersistence.findById(personaId);
        
        personaEntity.addCalificacionYComentario(calificacionYcomentarioEntity);     
        
        
        return calificacionycomentarioPersistence.findById(cycId);
    }
    
    /**
     * Obtiene una colección de instancias de PersonaEntity asociadas a una
     * instancia de CalificacionYComentario
     *
     * @param calificacionYcomentarioId Identificador de la instancia deCalificacionYComentario
     * @return Colección de instancias de PersonaEntity asociadas a la instancia
     * de CalificacionYComentario
     */
    public List<CalificacionYComentarioEntity> getCalificacionesYComentarios(Long calificacionycomentarioId) {
        return personaPersistence.findById(calificacionycomentarioId).getCalificacionesYComentarios();
    }
    
    
    
}
