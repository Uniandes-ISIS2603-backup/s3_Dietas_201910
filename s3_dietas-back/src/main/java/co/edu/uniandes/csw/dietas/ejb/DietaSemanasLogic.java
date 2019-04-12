/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.SemanaEntity;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import co.edu.uniandes.csw.dietas.persistence.SemanaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Alejandra Bravoa
 */
@Stateless
public class DietaSemanasLogic {
    private static final Logger LOGGER = Logger.getLogger(DietaSemanasLogic.class.getName());

    @Inject
    private DietaPersistence dietaPersistence;

    @Inject
    private SemanaPersistence semanaPersistence;

    /**
     * Asocia una Semana existente a una Dieta
     *
     * @param dietaId Identificador de la instancia de Dieta
     * @param semanaId Identificador de la instancia de Semana
     * @return Instancia de SemanaEntity que fue asociada a la Dieta
     */
    public SemanaEntity addSemana(Long dietaId, Long semanaId) {
        SemanaEntity semanaEntity = semanaPersistence.find(semanaId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietaId);
        dietaEntity.getSemanas().add(semanaEntity);
        return semanaPersistence.find(semanaId);
    }

    /**
     * Obtiene una colección de instancias de SemanaEntity asociadas a una
     * instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @return Colección de instancias de SemanaEntity asociadas a la instancia
     * de Dieta
     */
    public List<SemanaEntity> getSemanas(Long dietasId) {
        return dietaPersistence.findByID(dietasId).getSemanas();
    }

    /**
     * Obtiene una instancia de SemanaEntity asociada a una instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param semanasId Identificador de la instancia de Semana
     * @return La entidad de la Semana asociada a la dieta
     */
    public SemanaEntity getSemana(Long dietasId, Long semanasId) {
        List<SemanaEntity> semanas = dietaPersistence.findByID(dietasId).getSemanas();
        SemanaEntity semanaEntity = semanaPersistence.find(semanasId);
        int index = semanas.indexOf(semanaEntity);
        if (index >= 0) {
            return semanas.get(index);
        }
        return null;
    }

    /**
     * Remplaza las instancias de Semana asociadas a una instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param list Colección de instancias de SemanaEntity a asociar a instancia
     * de Dieta
     * @return Nueva colección de SemanaEntity asociada a la instancia de Dieta
     */
    public List<SemanaEntity> replaceSemanas(Long dietasId, List<SemanaEntity> list) {
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.setSemanas(list);
        return dietaPersistence.findByID(dietasId).getSemanas();
    }

    /**
     * Desasocia una Semana existente de una Dieta existente
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param semanasId Identificador de la instancia de Semana
     */
    public void removeSemana(Long dietasId, Long semanasId) {
        SemanaEntity semanaEntity = semanaPersistence.find(semanasId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.getSemanas().remove(semanaEntity);
    }
}
