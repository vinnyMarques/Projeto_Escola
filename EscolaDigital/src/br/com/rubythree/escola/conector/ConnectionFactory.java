package br.com.rubythree.escola.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	  private static final String DB_URL = "jdbc:mysql://localhost:3306/escola";
	  private static final String DB_USER = "root";
	  private static final String DB_PASS = "123";
	  
    public Connection getConnection() {
//        System.out.println("Conectando ao banco de dados");
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}