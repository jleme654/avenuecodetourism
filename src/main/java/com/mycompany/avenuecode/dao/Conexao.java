package com.mycompany.avenuecode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Julio Leme
 */
public class Conexao {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");  //driver para h2 db
            //jdbc:h2:file:C:\H2\bin [h2 em PUBLIC]
            return DriverManager.getConnection("jdbc:h2:file:C://H2/bin", "h2", "h2");  //retorna conexao h2 db
            //return DriverManager.getConnection("jdbc:h2:tcp://localhost:9001/db/meudb", "sa", "123");  //retorna conexao h2 db
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new SQLException();
        }
    }

}
