/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wendellvalois
 */
public class ConnectionFactory {

    public static java.sql.Connection getConnection() {

        try {
            /* Obtém o driver de conexão com o banco de dados */
            Class.forName("com.mysql.jdbc.Driver");
            /* Configura os parâmetros da conexão */
           // String url = "jdbc:mysql:ip:porta/schema"; //mudar o nome do banco aqui ex 8080/cantinadb
            String url = "jdbc:mysql://localhost:3306/cantinadb"; 
            String username = "root";
            String password = "";      
            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            /* Caso a conexão ocorra com sucesso, a conexão é retornada */
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQLException em ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ClassNotFoundException em ConnectionFactory", ex);

        }
    }
}
