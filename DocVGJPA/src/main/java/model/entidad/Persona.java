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
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdper", query = "SELECT p FROM Persona p WHERE p.idper = :idper")
    , @NamedQuery(name = "Persona.findByNomper", query = "SELECT p FROM Persona p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Persona.findByApeper", query = "SELECT p FROM Persona p WHERE p.apeper = :apeper")
    , @NamedQuery(name = "Persona.findByCelper", query = "SELECT p FROM Persona p WHERE p.celper = :celper")
    , @NamedQuery(name = "Persona.findByCorper", query = "SELECT p FROM Persona p WHERE p.corper = :corper")
    , @NamedQuery(name = "Persona.findByDniper", query = "SELECT p FROM Persona p WHERE p.dniper = :dniper")
    , @NamedQuery(name = "Persona.findByTipper", query = "SELECT p FROM Persona p WHERE p.tipper = :tipper")
    , @NamedQuery(name = "Persona.findByEstper", query = "SELECT p FROM Persona p WHERE p.estper = :estper")
    , @NamedQuery(name = "Persona.findByDirper", query = "SELECT p FROM Persona p WHERE p.dirper = :dirper")
    , @NamedQuery(name = "Persona.findByCodubi", query = "SELECT p FROM Persona p WHERE p.codubi = :codubi")
    , @NamedQuery(name = "Persona.findByNacper", query = "SELECT p FROM Persona p WHERE p.nacper = :nacper")
    , @NamedQuery(name = "Persona.findByTitper", query = "SELECT p FROM Persona p WHERE p.titper = :titper")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idper;
    @Size(max = 40)
    @Column(length = 40)
    private String nomper;
    @Size(max = 60)
    @Column(length = 60)
    private String apeper;
    @Size(max = 20)
    @Column(length = 20)
    private String celper;
    @Size(max = 40)
    @Column(length = 40)
    private String corper;
    @Size(max = 8)
    @Column(length = 8)
    private String dniper;
    private Character tipper;
    private Character estper;
    @Size(max = 50)
    @Column(length = 50)
    private String dirper;
    @Size(max = 6)
    @Column(length = 6)
    private String codubi;
    @Temporal(TemporalType.DATE)
    private Date nacper;
    @Size(max = 4)
    @Column(length = 4)
    private String titper;

    public Persona() {
    }

    public Persona(Integer idper) {
        this.idper = idper;
    }

    public Integer getIdper() {
        return idper;
    }

    public void setIdper(Integer idper) {
        this.idper = idper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getCelper() {
        return celper;
    }

    public void setCelper(String celper) {
        this.celper = celper;
    }

    public String getCorper() {
        return corper;
    }

    public void setCorper(String corper) {
        this.corper = corper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public Character getTipper() {
        return tipper;
    }

    public void setTipper(Character tipper) {
        this.tipper = tipper;
    }

    public Character getEstper() {
        return estper;
    }

    public void setEstper(Character estper) {
        this.estper = estper;
    }

    public String getDirper() {
        return dirper;
    }

    public void setDirper(String dirper) {
        this.dirper = dirper;
    }

    public String getCodubi() {
        return codubi;
    }

    public void setCodubi(String codubi) {
        this.codubi = codubi;
    }

    public Date getNacper() {
        return nacper;
    }

    public void setNacper(Date nacper) {
        this.nacper = nacper;
    }

    public String getTitper() {
        return titper;
    }

    public void setTitper(String titper) {
        this.titper = titper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idper != null ? idper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idper == null && other.idper != null) || (this.idper != null && !this.idper.equals(other.idper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entidad.Persona[ idper=" + idper + " ]";
    }
    
}
