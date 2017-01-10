/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.main;

import com.mycompany.avenuecode.dto.Continent;
import com.mycompany.avenuecode.dto.ContinentDTO;
import com.mycompany.avenuecode.mb.ContinentMB;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Julio Leme
 */
@Path("/exemplo")
public class ExemploRest {

    private List<String> list = new ArrayList<String>();
    private List<Continent> listaContinents = new ArrayList<Continent>();
    private List<ContinentDTO> listaContinentDTOs;
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista")
    public List<String> hello() {
        list.add("Julio");
        list.add("Romao");
        list.add("Guerreiro");
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public List<Continent> getAll() {
        return listaContinents;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllContinents")
    public List<ContinentDTO> getAllContinents() {
        ContinentMB mb = new ContinentMB();
        listaContinentDTOs = mb.getListaContinentDTOs();
        return listaContinentDTOs;
    }
}
