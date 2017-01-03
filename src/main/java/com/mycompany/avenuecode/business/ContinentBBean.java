/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.business;

import com.mycompany.avenuecode.dao.ContinentDAO;
import com.mycompany.avenuecode.dto.Continent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julio Leme
 */
@Stateless
public class ContinentBBean implements ContinetRemote {

    @PersistenceContext(unitName = "Continent")
    private EntityManager em;

    @Override
    public Continent save(Continent c) throws Exception {
        ContinentDAO dao = new ContinentDAO(em);
        return dao.salvar(c);
    }

    @Override
    public void remove(Long id) {
        ContinentDAO dao = new ContinentDAO(em);
        dao.remove(id);
    }

    @Override
    public Continent consultById(Long id) {
        ContinentDAO dao = new ContinentDAO(em);
        return dao.consultById(id);
    }

    @Override
    public List<Continent> getAllContinents() {
        ContinentDAO dao = new ContinentDAO(em);
        return dao.getAll();
    }
}
