/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.OportunidadDeAprendizaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santi
 */
@Stateless
public class OportunidadDeAprendizajeFacade extends AbstractFacade<OportunidadDeAprendizaje> implements OportunidadDeAprendizajeFacadeLocal {

    @PersistenceContext(unitName = "IncidenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OportunidadDeAprendizajeFacade() {
        super(OportunidadDeAprendizaje.class);
    }
    
}
