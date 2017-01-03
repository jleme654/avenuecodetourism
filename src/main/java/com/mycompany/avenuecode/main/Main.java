/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.main;

import com.mycompany.avenuecode.business.ContinentBBean;
import com.mycompany.avenuecode.dao.Conexao;
import com.mycompany.avenuecode.dao.ContinentDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Leme
 */
public class Main {

    public static void main(String[] args) {
        ContinentBBean c = new ContinentBBean();
        System.out.println(c.getAllContinents());
//        Conexao con = new Conexao();
//        try {
//            System.out.println(con.getConnection());
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
