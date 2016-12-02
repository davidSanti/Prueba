/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controllers;

import com.sigueme.backend.entities.ErrorFrecuente;
import com.sigueme.backend.entities.Incidencia;
import com.sigueme.backend.entities.Servicio;
import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.ErrorFrecuenteFacadeLocal;
import com.sigueme.backend.model.IncidenciaFacadeLocal;
import com.sigueme.backend.model.ServicioFacadeLocal;
import com.sigueme.backend.model.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Santi
 */
@ManagedBean
@RequestScoped
public class IncidenciaController {
    
    @EJB
    private IncidenciaFacadeLocal incidenciaFacadeLocal;
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB 
    private ServicioFacadeLocal ServicioFacadeLocal;
    @EJB
    private ErrorFrecuenteFacadeLocal errorFrecuenteFacadeLocal;
    
    private Usuario usuario;
    private Servicio servicio;
    private Incidencia incidencia;
    private ErrorFrecuente errorFrecuente;
    
    private List<Usuario> usuarios;
    private List<Servicio> servicios;
    private List<Incidencia> incidencias;
    private List<ErrorFrecuente> errores;

    public IncidenciaController() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        servicio = new Servicio();
        incidencia = new Incidencia();
        errorFrecuente = new ErrorFrecuente();
        
    }
    
    public List<Incidencia> listarIncidencia(){
        return this.incidenciaFacadeLocal.findAll();
    }
    
    public String registrarIncidencia(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "createIncident";
        try{
            this.incidencia.setAgente(usuario);
            this.incidencia.setIdCategoria(servicio);
            this.incidenciaFacadeLocal.create(incidencia);
                       
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La incidencia se ha registrado correctamente"));
        
            redirect = "principalIncident";
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo registrar la incidencia"));
        }
        return redirect;
        
    }
    
    public void eliminarIncidencia(Incidencia incidencia){
        FacesContext context = FacesContext.getCurrentInstance();
        this.incidencia = incidencia;
        try{
            this.incidenciaFacadeLocal.remove(this.incidencia);
                      
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La incidencia se ha eliminado correctamente"));
        
            }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo eliminar la incidencia"));
        }
        
    }

    public String editarIncidencia(Incidencia incidencia){
        this.incidencia = incidencia;
        return "editlIncident";
        
    }
    
    public String editarIncidencia(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "editlIncident";
        try{
            this.incidenciaFacadeLocal.edit(this.incidencia);
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La incidencia se ha modificado correctamente") );
            redirect = "principalIncident";
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La incidencia no se pudo modificar") );
        }
        return redirect;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public ErrorFrecuente getErrorFrecuente() {
        return errorFrecuente;
    }

    public void setErrorFrecuente(ErrorFrecuente errorFrecuente) {
        this.errorFrecuente = errorFrecuente;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioFacadeLocal.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Servicio> getServicios() {
        servicios = ServicioFacadeLocal.findAll();
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Incidencia> getIncidencias() {
        incidencias = incidenciaFacadeLocal.findAll();
        return incidencias;
    }

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public List<ErrorFrecuente> getErrores() {
        errores = errorFrecuenteFacadeLocal.findAll();
        return errores;
    }

    public void setErrores(List<ErrorFrecuente> errores) {
        this.errores = errores;
    }
    
    
}
