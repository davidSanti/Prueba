/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controllers;

import com.sigueme.backend.entities.Servicio;
import com.sigueme.backend.entities.Solucion;
import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.ServicioFacadeLocal;
import com.sigueme.backend.model.SolucionFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santi
 */
@ManagedBean
@SessionScoped
public class SolucionController {
    
    @EJB
    private SolucionFacadeLocal solucionFacadeLocal;
    private Solucion solucion;
    @EJB
    private ServicioFacadeLocal servicioFacadeLocal;
    private Servicio servicio;
    List<Servicio> servicios;
    
    public SolucionController() {
    }
    
    @PostConstruct
    public void iniciar(){
        solucion = new Solucion();
        servicio = new Servicio();
        servicios = servicioFacadeLocal.findAll();
    }
    
    public void registrarSolucion(){
        FacesContext ftx= FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario p = (Usuario) sesion.getAttribute("usuario");
        try{
            this.solucion.setCategoria(servicio);
            this.solucion.setAgente(p);
            this.solucionFacadeLocal.create(solucion);
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","La Solución se ha registrado correctamente"));
        }catch(Exception e){
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo registrar la solución"));
        }
    }

    public List<Solucion> listarSoluciones(){
        return this.solucionFacadeLocal.findAll();
    }
    
    public void eliminarSolucion(Solucion solucion){
        this.solucion = solucion;
        this.solucionFacadeLocal.remove(this.solucion);
    }
    public String editarSolucion(Solucion solucion){
        this.solucion = solucion;
        return "editSolution";
    }
    
    public String editarSolucion(){
        FacesContext ftx= FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario p = (Usuario) sesion.getAttribute("usuario");
        String redirect = "editSolution";
        try{
            this.solucion.setAgente(p);
            //this.solucion.setCategoria(servicio);
            this.solucionFacadeLocal.edit(solucion);
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","La Solución se ha modificado correctamente"));
            redirect = "principalSolution";
        }catch(Exception e){
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo modificar la solución"));
        }
        return redirect;
    }
    
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Solucion getSolucion() {
        return solucion;
    }

    public void setSolucion(Solucion solucion) {
        this.solucion = solucion;
    }
    
}
