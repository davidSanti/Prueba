/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.Procedimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface ProcedimientoFacadeLocal {

    void create(Procedimiento procedimiento);

    void edit(Procedimiento procedimiento);

    void remove(Procedimiento procedimiento);

    Procedimiento find(Object id);

    List<Procedimiento> findAll();

    List<Procedimiento> findRange(int[] range);

    int count();
    
}
