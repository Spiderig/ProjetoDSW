package br.com.senac.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igor
 */
public class Conexao {
    private final static String DB_URI = "jdbc:mysql://localhost:3306/produtobd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String DB_USER = "root";
    
    public static Connection getConnection() {
        Connection conexao = null;
        
        try {
            conexao = DriverManager.getConnection(DB_URI, DB_USER, "");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return conexao;
    }
}
