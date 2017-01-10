/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.dao;

import com.mycompany.avenuecode.dto.Continent;
import com.mycompany.avenuecode.dto.ContinentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Julio Leme
 */
public class ContinentDAO {

    private EntityManager em;
   
    public ContinentDAO() {
    }

    public ContinentDAO(EntityManager em) {
        this.em = em;
    }

    public Continent salvar(Continent p) throws Exception {
        if (p.getId() == null) {
            em.persist(p);
        } else {
            if (!em.contains(p)) {
                if (em.find(Continent.class, p.getId()) == null) {
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

    public List<ContinentDTO> getAllContinents() {
        List<ContinentDTO> list = new ArrayList<ContinentDTO>();
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from continent");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ContinentDTO c = new ContinentDTO();
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                c.setPopulation(rs.getInt("POPULATION"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContinentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
}
