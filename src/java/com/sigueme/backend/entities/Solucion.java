/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "Soluciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solucion.findAll", query = "SELECT s FROM Solucion s")
    , @NamedQuery(name = "Solucion.findBySolucionID", query = "SELECT s FROM Solucion s WHERE s.solucionID = :solucionID")
    , @NamedQuery(name = "Solucion.findByNombre", query = "SELECT s FROM Solucion s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Solucion.findByFecha", query = "SELECT s FROM Solucion s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Solucion.findByEstado", query = "SELECT s FROM Solucion s WHERE s.estado = :estado")})
public class Solucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SolucionID")
    private Integer solucionID;
    
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado", insertable = false)
    private boolean estado;

    @JoinColumn(name = "Categoria", referencedColumnName = "ServicioID")
    @ManyToOne(optional = false)
    private Servicio categoria;
    
    @JoinColumn(name = "Agente", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Usuario agente;
    
    public Solucion() {
    }

    public Solucion(Integer solucionID) {
        this.solucionID = solucionID;
    }

    public Solucion(Integer solucionID, String descripcion, Date fecha, boolean estado) {
        this.solucionID = solucionID;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getSolucionID() {
        return solucionID;
    }

    public void setSolucionID(Integer solucionID) {
        this.solucionID = solucionID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Servicio getCategoria() {
        return categoria;
    }

    public void setCategoria(Servicio categoria) {
        this.categoria = categoria;
    }

    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solucionID != null ? solucionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solucion)) {
            return false;
        }
        Solucion other = (Solucion) object;
        if ((this.solucionID == null && other.solucionID != null) || (this.solucionID != null && !this.solucionID.equals(other.solucionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nSolucionID: " + solucionID;
    }
    
}
