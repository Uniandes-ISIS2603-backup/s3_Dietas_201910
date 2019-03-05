/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.FotoEntity;

/**
 *
 * @author Louis Gualtero
 */
public class FotoDTO {
    
    private Long id;
    private String nombre;
    private String url;
    
    public FotoDTO (){
        
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param fotoEntity: Es la entidad que se va a convertir a DTO
     */
    public FotoDTO(FotoEntity fotoEntity) {
        if (fotoEntity != null) {
            this.nombre = fotoEntity.getNombre();
            this.url = fotoEntity.getUrl();
            this.id=fotoEntity.getId();
        }
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public FotoEntity toEntity() {
        FotoEntity fotoEntity = new FotoEntity();
        fotoEntity.setNombre(this.nombre);
        fotoEntity.setUrl(this.url);
        fotoEntity.setId(this.id);
        return fotoEntity;
   
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
