/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

import com.sigueme.backend.entities.Servicio;
import com.sigueme.backend.model.ServicioFacadeLocal;
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
@FacesConverter(value = "servicioConverter")
@SessionScoped
public class ServicioConverter implements Converter {
    
    @EJB
    private ServicioFacadeLocal servicioFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Servicio> servicios = this.servicioFacadeLocal.findAll();
        for (Servicio objeto : servicios) {
            if (objeto.getServicioID() == Integer.parseInt(value)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        if (objeto != null) {
            return ((Servicio) objeto).getServicioID().toString();
        } else {
            return "";
        }
    }
    
    
}
