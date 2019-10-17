/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Giancarlo
 */
@Entity
@Table(catalog = "DocVG", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEmpresa.findAll", query = "SELECT d FROM DetEmpresa d")
    , @NamedQuery(name = "DetEmpresa.findByIdDEMP", query = "SELECT d FROM DetEmpresa d WHERE d.idDEMP = :idDEMP")
    , @NamedQuery(name = "DetEmpresa.findByIdemp", query = "SELECT d FROM DetEmpresa d WHERE d.idemp = :idemp")
    , @NamedQuery(name = "DetEmpresa.findByIdper", query = "SELECT d FROM DetEmpresa d WHERE d.idper = :idper")
    , @NamedQuery(name = "DetEmpresa.findByCarper", query = "SELECT d FROM DetEmpresa d WHERE d.carper = :carper")
    , @NamedQuery(name = "DetEmpresa.findByEstasi", query = "SELECT d FROM DetEmpresa d WHERE d.estasi = :estasi")
    , @NamedQuery(name = "DetEmpresa.findByFecasi", query = "SELECT d FROM DetEmpresa d WHERE d.fecasi = :fecasi")})
public class DetEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idDEMP;
    private Integer idemp;
    private Integer idper;
    @Size(max = 40)
    @Column(length = 40)
    private String carper;
    private Character estasi;
    @Temporal(TemporalType.DATE)
    private Date fecasi;

    public DetEmpresa() {
    }

    public DetEmpresa(Integer idDEMP) {
        this.idDEMP = idDEMP;
    }

    public Integer getIdDEMP() {
        return idDEMP;
    }

    public void setIdDEMP(Integer idDEMP) {
        this.idDEMP = idDEMP;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }

    public Integer getIdper() {
        return idper;
    }

    public void setIdper(Integer idper) {
        this.idper = idper;
    }

    public String getCarper() {
        return carper;
    }

    public void setCarper(String carper) {
        this.carper = carper;
    }

    public Character getEstasi() {
        return estasi;
    }

    public void setEstasi(Character estasi) {
        this.estasi = estasi;
    }

    public Date getFecasi() {
        return fecasi;
    }

    public void setFecasi(Date fecasi) {
        this.fecasi = fecasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDEMP != null ? idDEMP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEmpresa)) {
            return false;
        }
        DetEmpresa other = (DetEmpresa) object;
        if ((this.idDEMP == null && other.idDEMP != null) || (this.idDEMP != null && !this.idDEMP.equals(other.idDEMP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entidad.DetEmpresa[ idDEMP=" + idDEMP + " ]";
    }
    
}
