/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Leme
 */
@Entity
@Table(name = "CONTINENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continent.findAll", query = "SELECT c FROM Continent c"),
    @NamedQuery(name = "Continent.findById", query = "SELECT c FROM Continent c WHERE c.id = :id"),
    @NamedQuery(name = "Continent.findByName", query = "SELECT c FROM Continent c WHERE c.name = :name"),
    @NamedQuery(name = "Continent.findByPopulation", query = "SELECT c FROM Continent c WHERE c.population = :population")})
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "POPULATION")
    private Integer population;

    public Continent() {
    }

    public Continent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continent)) {
            return false;
        }
        Continent other = (Continent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.avenuecode.dto.Continent[ id=" + id + " ]";
    }
    
}
