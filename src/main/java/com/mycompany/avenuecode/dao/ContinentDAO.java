/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.dao;

import com.mycompany.avenuecode.dto.Continent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Julio Leme
 */
public class ContinentDAO {

    private EntityManager em;

    public ContinentDAO(EntityManager em) {
        this.em = em;
    }
    
    public Continent salvar(Continent p) throws Exception {
        if(p.getId() == null) {
            em.persist(p);
        } else {
            if(!em.contains(p)) {
                if(em.find(Continent.class, p.getId()) == null) {
                    throw new Exception("Error!");
                }
            }
            p = em.merge(p);
        }

        return p;
    }

    public void remove(Long id) {
        Continent p = em.find(Continent.class, id);
        em.remove(p);
    }

    public Continent consultById(Long id) {
        return em.find(Continent.class, id);
    }

    public List<Continent> getAll() {
        Query q = em.createNamedQuery("Continent.findAll");
        return q.getResultList();
    }
}
