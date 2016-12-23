/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.dto;

import java.util.List;
import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Julio Leme
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Continent.getAll",
            query = "SELECT p FROM Cotinent p ORDER BY p.name")
})
@SequenceGenerator(name = "continent_seq", sequenceName = "continent_seq",
        allocationSize = 1, initialValue = 1)
public class ContinentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "continent_seq")
    private Long id;
    private String name;
    private Long population;
    private Map<Long, CountryDTO> mapCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Map<Long, CountryDTO> getMapCountry() {
        return mapCountry;
    }

    public void setMapCountry(Map<Long, CountryDTO> mapCountry) {
        this.mapCountry = mapCountry;
    }

}
