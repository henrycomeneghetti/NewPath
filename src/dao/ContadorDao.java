/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Contador;
/**
 *
 * @author hmq48
 */
public class ContadorDao {
    private final Connection conexao;
     public ContadorDao() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
     public Contador getDataAtualByLogin (String loginUsuario) {
        Contador contador = new Contador();
        String sql = "Select * FROM Contato WHERE login = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, loginUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                contador.setDataAtual(rs.getDate("dataAtual"));
                contador.setVicio(rs.getString("vicio"));
                }
            rs.close();
            ps.close();
            return contador;
            }
        catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
    
     
     
    
    
    
    
     
   
     
}
