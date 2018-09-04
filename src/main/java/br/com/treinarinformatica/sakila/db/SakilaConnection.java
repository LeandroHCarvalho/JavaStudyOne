/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakila.db;

import br.com.treinarinformatica.sakila.exceptions.DatabaseConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Treinar
 */
public class SakilaConnection {
    private static Connection connection;
    
    public static Connection getConnection() throws DatabaseConnectionException {
        try {
            if (connection == null) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String user = "root";
                String password = "1q2w3e4r";
                String dbName = "sakila";
                String host = "172.16.99.117";
                String url = String.format("jdbc:mysql://%1$s/%2$s",host,dbName);
                connection = DriverManager.getConnection(url, user, password);
            }
            
            return connection;
        } catch (Exception ex) {
            throw new DatabaseConnectionException(ex);
        }
        
        
    }
}
