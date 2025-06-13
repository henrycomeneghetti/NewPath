/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hmq48
 */
public class ConexaoBD {
    private static String USERNAME = "newpath";
    private static String PASSWORD = "1234";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_NOME = "newpath";
    private static String URL = "jdbc:mysql://localhost:3306/" + DB_NOME;
    
    static {
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306", USERNAME, PASSWORD); 
            Statement stmt = conexao.createStatement();
            var rs = stmt.executeQuery("SHOW DATABASES LIKE '" + DB_NOME + "'");

            if (rs.next()) {
                System.out.println("Banco de dados '" + DB_NOME + "' ja existe.");
            } 
            else {
                stmt.executeUpdate("CREATE DATABASE " + DB_NOME);
                System.out.println("Banco de dados '" + DB_NOME + "' criado com sucesso.");
        }
            rs.close();
            stmt.close();
            conexao.close();
            
          
                    
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao criar banco" + e.getMessage(), e);
        }
    }
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
            
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
      
}
