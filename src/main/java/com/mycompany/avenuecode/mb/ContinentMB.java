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
import com.mycompany.avenuecode.dto.Continent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "continentMB")
@SessionScoped
public class ContinentMB implements Serializable {

//    private ContinentWEB c = new ContinentWEB();
    private List<Continent> listaContinents = new ArrayList<Continent>();
    private Client cli = Client.create();
    private Gson gson = new Gson();

    public ContinentMB() {
        recarregar();
    }

    public void recarregar() {
        WebResource wr = cli.resource(
                "http://localhost:8084/AvenueCode/recursos/continents");
        String json = wr.get(String.class);
        listaContinents = gson.fromJson(json, new TypeToken<List<Continent>>() {
        }.getType());
    }

//    public String salvar() {
//        WebResource wr = c.resource(
//          "http://localhost:8080/PalestraWSREST/recursos/palestra");
//        if(palestra.getId() == null) {
//            wr.type("application/json").accept("application/json")
//              .post(gson.toJson(palestra));
//        } else {
//            wr.type("application/json").accept("application/json")
//              .put(gson.toJson(palestra));
//        }
//        palestra = new Palestra();
//        recarregar();
//        return "index";
//    }
//    public void remover(Palestra p) {
//        WebResource wr = c.resource(
//          "http://localhost:8080/PalestraWSREST/recursos/palestra/"+p.getId());
//        wr.delete();
//        recarregar();
//    }
//    public void editar(ContinentWEB p) {
//        this.c = p;
//    }
//
//    public ContinentWEB getContinent() {
//        return c;
//    }
//
//    public void setContinent(ContinentWEB palestra) {
//        this.c = palestra;
//    }

    public List<Continent> getListaContinents() {
        return listaContinents;
    }

    public void setListaContinents(List<Continent> palestras) {
        this.listaContinents = palestras;
    }

}
