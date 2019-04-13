/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.ejb;

import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.SuspensionEntity;
import co.edu.uniandes.csw.dietas.persistence.DietaPersistence;
import co.edu.uniandes.csw.dietas.persistence.SuspensionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alejandra Bravoa
 */
@Stateless
public class DietaSuspensionesLogic {
    private static final Logger LOGGER = Logger.getLogger(DietaSuspensionesLogic.class.getName());

    @Inject
    private DietaPersistence dietaPersistence;

    @Inject
    private SuspensionPersistence suspensionPersistence;

    /**
     * Asocia una Suspension existente a una Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param suspensionesId Identificador de la instancia de Suspension
     * @return Instancia de SuspensionEntity que fue asociada a Dieta
     */
    public SuspensionEntity addSuspension(Long dietasId, Long suspensionesId) {
        SuspensionEntity suspensionEntity = suspensionPersistence.findById(suspensionesId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.getSuspension().add(suspensionEntity);
        return suspensionPersistence.findById(suspensionesId);
    }

    /**
     * Obtiene una colección de instancias de SuspensionEntity asociadas a una
     * instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @return Colección de instancias de SuspensionEntity asociadas a la instancia
     * de Dieta
     */
    public List<SuspensionEntity> getSuspensiones(Long dietasId) {
        return dietaPersistence.findByID(dietasId).getSuspension();
    }

    /**
     * Obtiene una instancia de SuspensionEntity asociada a una instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param suspensionesId Identificador de la instancia de Suspension
     * @return La entidad del Suspension asociada a la Dieta
     */
    public SuspensionEntity getSuspension(Long dietasId, Long suspensionesId) {
        List<SuspensionEntity> suspensiones = dietaPersistence.findByID(dietasId).getSuspension();
        SuspensionEntity suspensionEntity = suspensionPersistence.findById(suspensionesId);
        int index = suspensiones.indexOf(suspensionEntity);
        if (index >= 0) {
            return suspensiones.get(index);
        }
        return null;
    }

    /**
     * Remplaza las instancias de Suspension asociadas a una instancia de Dieta
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param list Colección de instancias de SuspensionEntity a asociar a instancia
     * de Dieta
     * @return Nueva colección de SuspensionEntity asociada a la instancia de Dieta
     */
    public List<SuspensionEntity> replaceSuspensiones(Long dietasId, List<SuspensionEntity> list) {
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.setSuspension(list);
        return dietaPersistence.findByID(dietasId).getSuspension();
    }

    /**
     * Desasocia una Suspension existente de una Dieta existente
     *
     * @param dietasId Identificador de la instancia de Dieta
     * @param suspensionesId Identificador de la instancia de Suspension
     * al remover la suspension, esta se elimina
     */
    public void removeSuspension(Long dietasId, Long suspensionesId) {
        SuspensionEntity suspensionEntity = suspensionPersistence.findById(suspensionesId);
        DietaEntity dietaEntity = dietaPersistence.findByID(dietasId);
        dietaEntity.getSuspension().remove(suspensionEntity);
        suspensionPersistence.delete(suspensionesId);
    }
}
