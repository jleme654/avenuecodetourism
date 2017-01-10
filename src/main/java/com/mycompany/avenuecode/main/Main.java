/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.main;

import com.mycompany.avenuecode.business.ContinentBBean;
import com.mycompany.avenuecode.dao.Conexao;
import com.mycompany.avenuecode.dao.ContinentDAO;
import com.mycompany.avenuecode.dto.Continent;
import com.mycompany.avenuecode.dto.ContinentDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Leme
 */
public class Main {

    public static void main(String[] args) {
        ContinentDAO dao = new ContinentDAO();
        
        List<ContinentDTO> lista = dao.getAllContinents();
        for (ContinentDTO continent : lista) {
            System.out.println(continent);
        }
//        Conexao con = new Conexao();
//        try {
//            System.out.println(con.getConnection());
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
