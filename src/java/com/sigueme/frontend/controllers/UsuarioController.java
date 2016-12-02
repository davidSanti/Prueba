/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controllers;

import com.sigueme.backend.entities.Rol;
import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.RolFacadeLocal;
import com.sigueme.backend.model.UsuarioFacadeLocal;
import java.io.Serializable;
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
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    private RolFacadeLocal rolFacadeLocal;
    
    private Usuario usuario;
    private Rol rol;
    private List<Rol> roles;
    

    public UsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        rol = new Rol();
    }
    
    public String iniciarSesion(){
        String redireccion = null;
        Usuario usuarioValidado;
        try{
           usuarioValidado =  usuarioFacadeLocal.iniciarSesion(this.usuario);
            if(usuarioValidado != null){
                //Almacenar los datos al obtener un inicio de sesión exitoso
                HttpSession sesion = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sesion.setAttribute("usuario", usuarioValidado);
                //sesion.setAttribute("usuario",new Usuario("1111111","Nombre","Apellido","email","contraseña",new Rol(1,"aalgo"),true) );
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioValidado);
                redireccion = "/sigueme?faces-redirect = true";                
            }else{
                FacesContext.getCurrentInstance().addMessage(
                    null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Error","datos incorrectos"));
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(
                    null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error: ", "datos incorrectos"));
        }
        return redireccion; 
    }


    public String registrarUsuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "createUser";
        try{
            this.usuario.setIdRol(rol);
            this.usuarioFacadeLocal.create(usuario);
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El usuario se ha registrado correctamente"));
        
            redirect = "principalUser";
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo registrar el usuario"));
        }
        return redirect;
    }
    
    public List<Usuario> listarUsuarios(){
        return this.usuarioFacadeLocal.findAll();
    }
    
    public void eliminarUsuario(Usuario usuario){
        FacesContext context = FacesContext.getCurrentInstance();
        this.usuario = usuario;
        try{
            this.usuarioFacadeLocal.remove(this.usuario);
            
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El usuario se ha eliminado correctamente"));
            
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se han eliminar el usuario"));
        }
        
    }
    
    public String editarUsuario(Usuario usuario){
        this.usuario = usuario;
        return "editUser";
    }
    
    public String editarUsuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        String redirect = "editUser";
        try{
            //this.usuario.setIdRol(rol);
            this.usuarioFacadeLocal.edit(this.usuario);
            redirect = "principalUser";
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Los datos se han modificado correctamente"));
            
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se han modificado los datos"));
        }
        return redirect;
    }
        
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        this.roles = rolFacadeLocal.findAll();
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
}
