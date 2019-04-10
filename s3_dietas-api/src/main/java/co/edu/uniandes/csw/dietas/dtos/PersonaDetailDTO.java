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
                { calificacionesYComentarios.add(new CalificacionYComentarioDTO(calificacionYComentarioEntity));
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
            if(calificacionesYComentarios!=null)
            {
                List<CalificacionYComentarioEntity> calificaciones=new ArrayList<>();
                for(CalificacionYComentarioDTO calificacionYComentarioDTO:calificacionesYComentarios )
                { calificaciones.add(calificacionYComentarioDTO.toEntity());
                
                }
                 entity.setCalificacionesYComentarios(calificaciones);
            }
            if(fotos!=null)
            {
                List<FotoEntity> fotosEntitys=new ArrayList<>();
                for(FotoDTO foto: fotos)
                {
                    fotosEntitys.add(foto.toEntity());
                }               
            }
            if(quejasYReclamos!=null)
            {
                List<QuejaYReclamoEntity> quejas=new ArrayList<>();
                for(QuejaYReclamoDTO queja:quejasYReclamos)
                {
                    quejas.add(queja.toEntity());
                }
            }
            if(dietas!=null)
            {
                List<DietaEntity> dietasss=new ArrayList<>();
                for(DietaDTO diet: dietas)
                {
                    dietasss.add(diet.toEntity());
                }
            }

            if(pagos!=null)
            {
                List<PagoEntity> pagoss=new ArrayList<>();
                for(PagoDTO pagoD: pagos)
                {
                    pagoss.add(pagoD.toEntity());
                }
            }
        return entity;
    }
}