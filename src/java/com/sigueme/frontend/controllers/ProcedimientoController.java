/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controllers;

import com.sigueme.backend.entities.Procedimiento;
import com.sigueme.backend.entities.Servicio;
import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.ProcedimientoFacadeLocal;
import com.sigueme.backend.model.ServicioFacadeLocal;
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
public class ProcedimientoController {
    
    @EJB
    private ProcedimientoFacadeLocal procedimientoFacadeLocal;
    @EJB
    
    private ServicioFacadeLocal servicioFacadeLocal;
    private Procedimiento procedimiento;
    private Servicio servicio;
    List<Servicio> servicios;

    public ProcedimientoController() {
    }

    @PostConstruct
    public void init(){
        procedimiento = new Procedimiento();
        servicio = new Servicio();
        servicios = servicioFacadeLocal.findAll();
    }
    
    public String registrarProcedimiento(){
        FacesContext ftx= FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario p = (Usuario) sesion.getAttribute("usuario");
        String redirect = "createProcedure";
        try{
            this.procedimiento.setAgente(p);
            this.procedimientoFacadeLocal.create(procedimiento);
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El precedimiento se ha registrado correctamente"));
            redirect = "principalProcedure";
        }catch(Exception e){
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo registrar el procedimiento"));
        }
        return redirect;
    }

    public List<Procedimiento> listarprocedimientos(){
        return this.procedimientoFacadeLocal.findAll();
    }
    
    public void eliminarProcedimiento(Procedimiento procedimiento){
        FacesContext ftx= FacesContext.getCurrentInstance();
         try{
             this.procedimiento = procedimiento;
             this.procedimientoFacadeLocal.remove(this.procedimiento);
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El procedimiento se ha eliminado correctamente"));
        }catch(Exception e){
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo eliminado el procedimiento"));
        }
         
       
    }
    
    public String editarProcedimiento(Procedimiento procedimiento){
        this.procedimiento = procedimiento;
        return "editProcedure";
    }
    
    public String editarProcedimiento(){
        FacesContext ftx= FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Usuario p = (Usuario) sesion.getAttribute("usuario");
        String redirect = "editProcedure";
        try{
            this.procedimiento.setAgente(p);
            this.procedimientoFacadeLocal.edit(procedimiento);
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El procedimiento se ha modificado correctamente"));
            redirect = "principalProcedure";
        }catch(Exception e){
            ftx.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo modificar el procedimiento"));
        }
        return redirect;
    }
    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
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
    
}
