/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

//import com.sigueme.backend.entities.Solucion;
//import com.sigueme.backend.model.SolucionFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Santi
 */
@FacesConverter(value = "solucionConverter")
@ViewScoped
public class SolucionConverter /*implements Converter*/{
    /* 
    @EJB
    private SolucionFacadeLocal solucionFrecuenteFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Solucion> soluciones = this.solucionFrecuenteFacadeLocal.findAll();
        for (Solucion objeto : soluciones) {
            if (objeto.getSolucionID() == Integer.parseInt(value)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        if (objeto != null) {
            return ((Solucion) objeto).getSolucionID().toString();
        } else {
            return "";
        }
    }*/
}
