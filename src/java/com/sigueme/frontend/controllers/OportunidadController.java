/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controllers;

import com.sigueme.backend.entities.EstadoOportunidad;
import com.sigueme.backend.entities.OportunidadDeAprendizaje;
import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.EstadoOportunidadFacadeLocal;
import com.sigueme.backend.model.OportunidadDeAprendizajeFacadeLocal;
import com.sigueme.backend.model.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Santi
 */
@ManagedBean
@SessionScoped
public class OportunidadController {
    
    @EJB
    private OportunidadDeAprendizajeFacadeLocal oportunidadFacadeLocal;
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    private EstadoOportunidadFacadeLocal estadoOportunidadFacadeLocal;
    
    private OportunidadDeAprendizaje oportunidad;
    private Usuario agenteOportunidad;
    private EstadoOportunidad estadoOportunidad;
    
    private List<OportunidadDeAprendizaje> oportunidades;
    private List<Usuario> agentesOportunidad;
    private List<EstadoOportunidad> estadosOportuniad;

    public OportunidadController() {
    }
    
    @PostConstruct
    public void init(){
        oportunidad = new OportunidadDeAprendizaje();
        agenteOportunidad = new Usuario();
        estadoOportunidad = new EstadoOportunidad();
        
    }

    public List<OportunidadDeAprendizaje> listarOportunidades(){
        return this.oportunidadFacadeLocal.findAll();
    }
    
    public String registrarOportunidad(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "createOportunity";
        
        try{
            //estadoOportunidad = estadoOportunidadFacadeLocal.find(1);
            this.oportunidadFacadeLocal.create(oportunidad);
                       
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La incidencia se ha registrado correctamente"));
        
            redirect = "principalOportunity";
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo registrar la incidencia"));
        }
        return redirect;
        
    }
    
    public void eliminarOportunidad(OportunidadDeAprendizaje oportunidad){
        FacesContext context = FacesContext.getCurrentInstance();
        this.oportunidad = oportunidad;
        try{
            this.oportunidadFacadeLocal.remove(this.oportunidad);
                      
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La oportunidad se ha eliminado correctamente"));
        
            }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo eliminar la oportunidad"));
        }
      
    }
    
    public String editarOportunidad(OportunidadDeAprendizaje oportunidad){
        this.oportunidad = oportunidad;
        return "editOportunity";
    }
    
    public String editarOportunidad(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "editOportunity";
        try{
            this.oportunidadFacadeLocal.edit(this.oportunidad);
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La oportunidad se ha modificado correctamente") );
            redirect = "principalOportunity";
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La oportunidad no se pudo modificar") );
        }
        return redirect;
       
    }
    
    public OportunidadDeAprendizaje getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(OportunidadDeAprendizaje oportunidad) {
        this.oportunidad = oportunidad;
    }

    public Usuario getAgenteOportunidad() {
        return agenteOportunidad;
    }

    public void setAgenteOportunidad(Usuario agenteOportunidad) {
        this.agenteOportunidad = agenteOportunidad;
    }

    public List<EstadoOportunidad> getEstadosOportuniad() {
        estadosOportuniad = estadoOportunidadFacadeLocal.findAll();
        return estadosOportuniad;
    }

    public void setEstadosOportuniad(List<EstadoOportunidad> estadosOportuniad) {
        this.estadosOportuniad = estadosOportuniad;
    }
    
    public EstadoOportunidad getEstadoOportunidad() {
        return estadoOportunidad;
    }

    public void setEstadoOportunidad(EstadoOportunidad estadoOportunidad) {
        this.estadoOportunidad = estadoOportunidad;
    }
    
    public List<OportunidadDeAprendizaje> getOportunidades() {
        oportunidades = oportunidadFacadeLocal.findAll();
        return oportunidades;
    }

    public void setOportunidades(List<OportunidadDeAprendizaje> oportunidades) {
        this.oportunidades = oportunidades;
    }

    public List<Usuario> getAgentesOportunidad() {
        agentesOportunidad = usuarioFacadeLocal.findAll();
        return agentesOportunidad;
    }

    public void setAgentesOportunidad(List<Usuario> agentesOportunidad) {
        this.agentesOportunidad = agentesOportunidad;
    }
       
}
