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
import modelo.Contato;
import modelo.Notas;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author hmq48
 */
public class NotasDao {
    private final Connection conexao;
    
     public NotasDao() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
 
      public List<Notas> buscarNotasPorUsuario (String loginUsuario) {
          List<Notas> listaNotas = new ArrayList<>();
          String sql = "Select * FROM Notas Where login = ?";
          
          try{
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, loginUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Notas notas = new Notas();
                notas.setId(rs.getInt("id"));
                notas.setLogin(rs.getString("login"));
                notas.setTitulo(rs.getString("titulo"));
                notas.setDescricao(rs.getString("descricao"));
                notas.setDataRegistro(rs.getDate("dataRegistro"));
                listaNotas.add(notas);
            }
            return listaNotas;
            
          }
          catch (SQLException e) {
                throw new RuntimeException(e);
                }
      }
      
      public void adicionaNota(Notas notas) {
          String sql = "INSERT INTO notas (login, titulo, descricao, dataRegistro) VALUES (?, ?, ?, ?)";
          
          try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, notas.getLogin());
            ps.setString(2, notas.getTitulo());
            ps.setString(3, notas.getDescricao());
            ps.setDate(4, new java.sql.Date(notas.getDataRegistro().getTime()));
            ps.execute();
            ps.close();
           
            
        }
        
        catch(SQLException e) {
            throw new RuntimeException(e);
            
        }
      }
      
       public Notas getNotaById (int id) {
        Notas notas = new Notas();
        String sql = "Select * FROM Notas WHERE id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                notas.setId(rs.getInt("id"));
                notas.setTitulo(rs.getString("titulo"));
                notas.setDescricao(rs.getString("descricao"));
                notas.setDataRegistro(rs.getDate("dataRegistro"));
                }
            rs.close();
            ps.close();
            return notas;
            }
        catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
      
        public void atualizaNota(Notas notas) {
        String sql = "UPDATE notas SET titulo = ?, descricao = ? WHERE id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, notas.getTitulo());
            ps.setString(2, notas.getDescricao());
            ps.setInt(3, notas.getId());
            ps.execute();
            ps.close();
        }
         catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
        
        public void removeNota(Integer id) {
        String sql = "DELETE FROM Notas WHERE id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}

