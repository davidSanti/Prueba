/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.OportunidadDeAprendizaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface OportunidadDeAprendizajeFacadeLocal {

    void create(OportunidadDeAprendizaje oportunidadDeAprendizaje);

    void edit(OportunidadDeAprendizaje oportunidadDeAprendizaje);

    void remove(OportunidadDeAprendizaje oportunidadDeAprendizaje);

    OportunidadDeAprendizaje find(Object id);

    List<OportunidadDeAprendizaje> findAll();

    List<OportunidadDeAprendizaje> findRange(int[] range);

    int count();
    
}
