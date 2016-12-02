/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.Solucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface SolucionFacadeLocal {

    void create(Solucion solucion);

    void edit(Solucion solucion);

    void remove(Solucion solucion);

    Solucion find(Object id);

    List<Solucion> findAll();

    List<Solucion> findRange(int[] range);

    int count();
    
}
