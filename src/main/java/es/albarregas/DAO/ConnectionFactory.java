/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FranciscoAntonio
 */
public class ConnectionFactory {
    private static final String USERNAME = "java2019";
    private static final String PASSWORD = "2019";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/EuiposDept";
    
    public static Connection conectar() throws ClassNotFoundException{
	Connection con = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
	    System.out.println("Connected");
	}catch (SQLException e){
	System.err.println(e);
	}
	return con;
    }
}
