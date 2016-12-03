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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByPermisoID", query = "SELECT p FROM Permiso p WHERE p.permisoID = :permisoID")
    , @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permiso.findByTipo", query = "SELECT p FROM Permiso p WHERE p.tipo = :tipo")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PermisoID")
    private Integer permisoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo")
    private boolean tipo;
    @OneToMany(mappedBy = "dependencia")
    private List<Permiso> permisoList;
    @JoinColumn(name = "Dependencia", referencedColumnName = "PermisoID")
    @ManyToOne
    private Permiso dependencia;
    
    @ManyToMany(mappedBy = "permisoList")
    private List<Rol> rolEntityList;

    public Permiso() {
    }

    public Permiso(Integer permisoID) {
        this.permisoID = permisoID;
    }

    public Permiso(Integer permisoID, String nombre, boolean tipo) {
        this.permisoID = permisoID;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getPermisoID() {
        return permisoID;
    }

    public void setPermisoID(Integer permisoID) {
        this.permisoID = permisoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getDependencia() {
        return dependencia;
    }

    public void setDependencia(Permiso dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisoID != null ? permisoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permisoID == null && other.permisoID != null) || (this.permisoID != null && !this.permisoID.equals(other.permisoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.Permiso[ permisoID=" + permisoID + " ]";
    }
    
}
