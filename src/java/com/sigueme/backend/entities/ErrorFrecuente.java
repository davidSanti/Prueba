/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "ErrorFrecuente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErrorFrecuente.findAll", query = "SELECT e FROM ErrorFrecuente e")
    , @NamedQuery(name = "ErrorFrecuente.findByErrorID", query = "SELECT e FROM ErrorFrecuente e WHERE e.errorID = :errorID")
    , @NamedQuery(name = "ErrorFrecuente.findByDescripcion", query = "SELECT e FROM ErrorFrecuente e WHERE e.descripcion = :descripcion")})
public class ErrorFrecuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ErrorID")
    private Integer errorID;
    
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @ManyToMany(mappedBy = "erroresFrescuentes")
    private List<Incidencia> incidenciasError;

    public ErrorFrecuente() {
    }

    public ErrorFrecuente(Integer errorID) {
        this.errorID = errorID;
    }

    public Integer getErrorID() {
        return errorID;
    }

    public void setErrorID(Integer errorID) {
        this.errorID = errorID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Incidencia> getIncidenciasError() {
        return incidenciasError;
    }

    public void setIncidenciasError(List<Incidencia> incidenciasError) {
        this.incidenciasError = incidenciasError;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorID != null ? errorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorFrecuente)) {
            return false;
        }
        ErrorFrecuente other = (ErrorFrecuente) object;
        if ((this.errorID == null && other.errorID != null) || (this.errorID != null && !this.errorID.equals(other.errorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nErrorID: " + errorID + 
                "Descripción:" + descripcion;
    }
    
}
