/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.mb;

/**
 *
 * @author Julio Leme
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.avenuecode.dao.ContinentDAO;
import com.mycompany.avenuecode.dto.ContinentDTO;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ManagedBean(name = "continentMB")
@SessionScoped
public class ContinentMB implements Serializable {

    private List<ContinentDTO> listaContinentDTOs;
    private List<ContinentDTO> lista;
    private ContinentDAO dao;
    private Client cli = Client.create();
    private Gson gson = new Gson();
    
    public ContinentMB(){
        listaContinentDTOs = getListaContinentDTOs();
    }

    public void recarregar() {
        WebResource wr = cli.resource(
                "http://localhost:8084/AvenueCode/rest/exemplo/lista");
        String json = wr.get(String.class);
        listaContinentDTOs = gson.fromJson(json, new TypeToken<List<ContinentDTO>>() {
        }.getType());
    }

    public void setListaContinentDTOs(List<ContinentDTO> palestras) {
        this.listaContinentDTOs = palestras;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllContinents")
    public List<ContinentDTO> getListaContinentDTOs() {
        ContinentDAO dao = new ContinentDAO();
        listaContinentDTOs = dao.getAllContinents();
        System.out.println(listaContinentDTOs);
        return listaContinentDTOs;
    }

    public List<ContinentDTO> getLista() {
        lista = listaContinentDTOs;
        System.out.println("Lista: "+lista);
        for (ContinentDTO c : listaContinentDTOs) {
            ContinentDTO c2 = new ContinentDTO();
            c2.setName(c.getName());
            c2.setPopulation(c.getPopulation());
            lista.add(c2);
        }
        return lista;
    }

    public void setLista(List<ContinentDTO> lista) {
        this.lista = lista;
    }

}
