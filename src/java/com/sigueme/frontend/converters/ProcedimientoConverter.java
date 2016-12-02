/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

//import com.sigueme.backend.entities.Procedimiento;
//import com.sigueme.backend.model.ProcedimientoFacadeLocal;
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
@FacesConverter (value = "procedimientoConverter")
@ViewScoped
public class ProcedimientoConverter /*implements Converter*/{
    /*
    @EJB
    private ProcedimientoFacadeLocal procedimientoFrecuenteFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Procedimiento> procedimientos = this.procedimientoFrecuenteFacadeLocal.findAll();
        for (Procedimiento objeto : procedimientos) {
            if (objeto.getProcedimientoID() == Integer.parseInt(value)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        if (objeto != null) {
            return ((Procedimiento) objeto).getProcedimientoID().toString();
        } else {
            return "";
        }
    }*/
}
