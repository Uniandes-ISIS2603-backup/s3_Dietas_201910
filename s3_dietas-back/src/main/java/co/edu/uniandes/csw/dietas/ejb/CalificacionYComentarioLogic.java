/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.dietas.persistence.CalificacionYComentarioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class CalificacionYComentarioLogic 
{
    @Inject
    private CalificacionYComentarioPersistence calificacionYcomentarioP;
    

    
    public CalificacionYComentarioEntity createCalificacionYComentario (CalificacionYComentarioEntity calificacionYcomentario) throws BusinessLogicException
    {
        if(calificacionYcomentarioP.findById( calificacionYcomentario.getId())!= null)
        {
            throw new BusinessLogicException("Ya existe una calificación y comentario con ese id");
        }
        calificacionYcomentarioP.create(calificacionYcomentario);
        return calificacionYcomentario;
    }
    
    
     public CalificacionYComentarioEntity getCalificacionYComentario(Long calificacionYcomentarioId) {
       CalificacionYComentarioEntity calificacionYcomentarioEntity = calificacionYcomentarioP.findById(calificacionYcomentarioId);
        if (calificacionYcomentarioEntity == null) {
//            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", calificacionycomentarioId);
        }
        return calificacionYcomentarioEntity;
    }
}
