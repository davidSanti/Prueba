/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

import com.sigueme.backend.entities.EstadoOportunidad;
import com.sigueme.backend.model.EstadoOportunidadFacadeLocal;
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
@FacesConverter(value = "estadoOportunidadConverter")
@SessionScoped
public class EstadoOportunidadConverter implements Converter{
    
    @EJB
    private EstadoOportunidadFacadeLocal estadoOportunidadFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<EstadoOportunidad> estados = this.estadoOportunidadFacadeLocal.findAll();
        for (EstadoOportunidad objeto : estados) {
            if (objeto.getEstadoID() == Integer.parseInt(value)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        if (objeto != null) {
            return ((EstadoOportunidad) objeto).getEstadoID().toString();
        } else {
            return "";
        }
    }
}
