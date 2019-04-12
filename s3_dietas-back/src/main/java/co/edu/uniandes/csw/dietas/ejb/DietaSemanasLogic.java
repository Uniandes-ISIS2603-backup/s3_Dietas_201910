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
     * Asocia un Dieta existente a un Semana
     *
     * @param semanasId Identificador de la instancia de Semana
     * @param dietaId Identificador de la instancia de Dieta
     * @return Instancia de DietaEntity que fue asociada a Semana
     */
    public DietaEntity addDieta(Long semanasId, Long dietaId) {
        DietaEntity dietaEntity = dietaPersistence.findByID(dietaId);
        SemanaEntity semanaEntity = semanaPersistence.findId(semanasId);
        semanaEntity.setDieta(dietaEntity);
        return dietaPersistence.findByID(dietaId);
    }

    /**
     * Obtiene una colección de instancias de DietaEntity asociadas a una
     * instancia de Semana
     *
     * @param semanasId Identificador de la instancia de Semana
     * @return Colección de instancias de DietaEntity asociadas a la instancia
     * de Semana
     */
    public List<SemanaEntity> getSemanas(Long dietasId) {
        return dietaPersistence.findByID(dietasId).getSemanas();
    }

    /**
     * Obtiene una instancia de DietaEntity asociada a una instancia de Semana
     *
     * @param semanasId Identificador de la instancia de Semana
     * @param authorsId Identificador de la instancia de Dieta
     * @return La entidad del Autor asociada al libro
     */
    public SemanaEntity getSemana(Long semanasId, Long dietaId) {
        List<SemanaEntity> semanas = dietaPersistence.findByID(semanasId).getSemanas();
        SemanaEntity semanaEntity = semanaPersistence.findId(semanasId);
        int index = semanas.indexOf(semanaEntity);
        if (index >= 0) {
            return semanas.get(index);
        }
        return null;
    }

    /**
     * Remplaza las instancias de Dieta asociadas a una instancia de Semana
     *
     * @param semanasId Identificador de la instancia de Semana
     * @param list Colección de instancias de DietaEntity a asociar a instancia
     * de Semana
     * @return Nueva colección de SemanaEntity asociada a la instancia de Semana
     */
    public List<SemanaEntity> replaceSemanas(Long dietasId, List<SemanaEntity> list) {
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.setSemanas(list);
        return dietaPersistence.findByID(dietasId).getSemanas();
    }

    /**
     * Desasocia un Dieta existente de un Semana existente
     *
     * @param semanaId Identificador de la instancia de Semana
     * @param dietasId Identificador de la instancia de Dieta
     */
    public void removeDieta(Long dietasId, Long semanaId) {
        SemanaEntity semanaEntity = semanaPersistence.findId(semanaId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.getSemanas().remove(semanaEntity);
        semanaPersistence.delete(semanaId);
    }
}
