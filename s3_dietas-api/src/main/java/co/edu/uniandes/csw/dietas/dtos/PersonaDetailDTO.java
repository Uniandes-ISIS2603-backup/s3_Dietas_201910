/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.dietas.dtos;

import co.edu.uniandes.csw.dietas.entities.CalificacionYComentarioEntity;
import co.edu.uniandes.csw.dietas.entities.DietaEntity;
import co.edu.uniandes.csw.dietas.entities.FotoEntity;
import co.edu.uniandes.csw.dietas.entities.PagoEntity;
import co.edu.uniandes.csw.dietas.entities.PersonaEntity;
import co.edu.uniandes.csw.dietas.entities.QuejaYReclamoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Espitia
 */
public class PersonaDetailDTO extends PersonaDTO implements Serializable{
    
    private List<DietaDTO> dietas;
    private List<FotoDTO> fotos;
    private List<CalificacionYComentarioDTO> calificacionesYComentarios;
    private List<QuejaYReclamoDTO> quejasYReclamos;
    private List<PagoDTO> pagos;
    
    
    public PersonaDetailDTO(){
        super();
    }
    
    public PersonaDetailDTO(PersonaEntity personaEntity)
    {        
        super(personaEntity);
        if(personaEntity!=null)
        {
            if(personaEntity.getCalificacionesYComentarios()!=null)
            {
                calificacionesYComentarios=new ArrayList<CalificacionYComentarioDTO>();
                for(CalificacionYComentarioEntity calificacionYComentarioEntity: personaEntity.getCalificacionesYComentarios())
                {  calificacionesYComentarios.add(new CalificacionYComentarioDTO(calificacionYComentarioEntity));
                }
            }
            if(personaEntity.getFotos()!=null)
            {
                fotos= new ArrayList<FotoDTO>();
                for(FotoEntity fotoEntity: personaEntity.getFotos())
                {
                    fotos.add(new FotoDTO(fotoEntity));
                }
            }
           if(personaEntity.getQuejas()!=null)
            {
                quejasYReclamos= new ArrayList<QuejaYReclamoDTO>();
                for(QuejaYReclamoEntity quejaEntity: personaEntity.getQuejas())
                {
                   quejasYReclamos.add(new QuejaYReclamoDTO(quejaEntity));
                }
            }
        if(personaEntity.getDietas()!=null)
            {
                dietas= new ArrayList<DietaDTO>();
                for(DietaEntity dietaEntity: personaEntity.getDietas())
                {
                    dietas.add(new DietaDTO(dietaEntity));
                }
            }

            if(personaEntity.getPagos()!=null)
            {
                pagos= new ArrayList<PagoDTO>();
                for(PagoEntity pagoEntity: personaEntity.getPagos())
                {
                   pagos.add(new PagoDTO(pagoEntity));
                }
            }
        }
        
    }
        
    public PersonaEntity toEntity(){
        PersonaEntity entity = super.toEntity();
            if(getCalificacionesYComentarios()!=null)
            {
                List<CalificacionYComentarioEntity> calificaciones=new ArrayList<>();
                for(CalificacionYComentarioDTO calificacionYComentarioDTO:getCalificacionesYComentarios() )
                { calificaciones.add(calificacionYComentarioDTO.toEntity());
                
                }
                 entity.setCalificacionesYComentarios(calificaciones);
            }
            if(getFotos()!=null)
            {
                List<FotoEntity> fotosEntitys=new ArrayList<>();
                for(FotoDTO foto: getFotos())
                {
                    fotosEntitys.add(foto.toEntity());
                }               
            }
            if(getQuejasYReclamos()!=null)
            {
                List<QuejaYReclamoEntity> quejas=new ArrayList<>();
                for(QuejaYReclamoDTO queja:getQuejasYReclamos())
                {
                    quejas.add(queja.toEntity());
                }
            }
            if(getDietas()!=null)
            {
                List<DietaEntity> dietasss=new ArrayList<>();
                for(DietaDTO diet: getDietas())
                {
                    dietasss.add(diet.toEntity());
                }
            }

            if(getPagos()!=null)
            {
                List<PagoEntity> pagoss=new ArrayList<>();
                for(PagoDTO pagoD: getPagos())
                {
                    pagoss.add(pagoD.toEntity());
                }
            }
        return entity;
    }

    /**
     * @return the dietas
     */
    public List<DietaDTO> getDietas() {
        return dietas;
    }

    /**
     * @param dietas the dietas to set
     */
    public void setDietas(List<DietaDTO> dietas) {
        this.dietas = dietas;
    }

    /**
     * @return the fotos
     */
    public List<FotoDTO> getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(List<FotoDTO> fotos) {
        this.fotos = fotos;
    }

    /**
     * @return the calificacionesYComentarios
     */
    public List<CalificacionYComentarioDTO> getCalificacionesYComentarios() {
        return calificacionesYComentarios;
    }

    /**
     * @param calificacionesYComentarios the calificacionesYComentarios to set
     */
    public void setCalificacionesYComentarios(List<CalificacionYComentarioDTO> calificacionesYComentarios) {
        this.calificacionesYComentarios = calificacionesYComentarios;
    }

    /**
     * @return the quejasYReclamos
     */
    public List<QuejaYReclamoDTO> getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(List<QuejaYReclamoDTO> quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
    }

    /**
     * @return the pagos
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }
}