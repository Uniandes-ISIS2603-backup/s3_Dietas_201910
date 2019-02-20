/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.persistence;


import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Montoya Serje
 */
@Stateless
public class CalificacionYComentarioPersistence 
{
    @PersistenceContext(unitName="dietasPU")
    protected EntityManager em;
    public CalificacionYComentarioEntity create(CalificacionYComentarioEntity calificacionYcomentariParam)
    {
        em.persist(calificacionYcomentariParam);
        return calificacionYcomentariParam;
    }
}
