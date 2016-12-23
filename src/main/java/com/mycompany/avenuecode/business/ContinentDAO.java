/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.business;

import com.mycompany.avenuecode.dto.ContinentDTO;
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
    
    public ContinentDTO salvar(ContinentDTO p) throws Exception {
        if(p.getId() == null) {
            em.persist(p);
        } else {
            if(!em.contains(p)) {
                if(em.find(ContinentDTO.class, p.getId()) == null) {
                    throw new Exception("Error!");
                }
            }
            p = em.merge(p);
        }

        return p;
    }

    public void remove(Long id) {
        ContinentDTO p = em.find(ContinentDTO.class, id);
        em.remove(p);
    }

    public ContinentDTO consultById(Long id) {
        return em.find(ContinentDTO.class, id);
    }

    public List<ContinentDTO> getAll() {
        Query q = em.createNamedQuery("Continent.getAll");
        return q.getResultList();
    }
}
