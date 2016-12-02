/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Santi
 */
@FacesConverter(value = "usuarioConverter")
@SessionScoped
public class UsuarioConverter implements Converter{

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Usuario> usuarios = this.usuarioFacadeLocal.findAll();
        for (Usuario objeto : usuarios) {
            if (objeto.getCedula().equals(value)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        if (objeto != null) {
            return ((Usuario) objeto).getCedula();
        } else {
            return "";
        }
    }
    
}
