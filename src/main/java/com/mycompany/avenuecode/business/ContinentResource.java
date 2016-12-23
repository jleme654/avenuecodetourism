/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.business;

import com.google.gson.Gson;
import com.mycompany.avenuecode.dto.ContinentDTO;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author Julio Leme REST Web Service
 */
@Path("continent")
public class ContinentResource {

    private Gson gson = new Gson();

    @EJB
    private ContinetRemote ejb;

    @GET
    @Produces("application/json")
    public String getContinents() {
        return gson.toJson(ejb.getAllContinents());
    }

    @Path("{id}")
    @GET
    @Produces("application/json")
    public String getContinent(@PathParam("id") String id) {
        return gson.toJson(ejb.consultById(Long.valueOf(id)));
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String saveContinent(String name) {
        try {
            ContinentDTO p = gson.fromJson(name, ContinentDTO.class);
            return gson.toJson(ejb.save(p));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DELETE
    @Path("/{id}")
    public void removeContinent(final @PathParam("id") String id) {
        ejb.remove(Long.valueOf(id));
    }

    @PUT
    @Consumes("application/json")
    public void putContinet(String name) {
        saveContinent(name);
    }
}
