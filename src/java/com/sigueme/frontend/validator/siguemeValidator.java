/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.validator;

import com.sigueme.backend.entities.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Santi
 */
@ManagedBean
@ViewScoped
public class siguemeValidator implements Serializable{
    
    public void verificarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
           Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
           
           if(usuario == null){
               context.getExternalContext().redirect("index.xhtml");
           }
        }catch(Exception e){
            //Log para guardar codigo de error
        }
    }
    
}
