/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.dto;

import java.util.List;

/**
 *
 * @author Julio Leme
 */
public class CountryDTO {

    private Long id;
    private String name;
    private Long population;
    private List<CityDTO> listCities;

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

    public List<CityDTO> getListCities() {
        return listCities;
    }

    public void setListCities(List<CityDTO> listCities) {
        this.listCities = listCities;
    }

}
