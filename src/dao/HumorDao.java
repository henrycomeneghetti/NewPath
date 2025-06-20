/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConexaoBD;
import java.sql.Connection;
import modelo.Humor;
import bd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Contato;
import modelo.Notas;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author hmq48
 */
public class HumorDao {
    private final Connection conexao;
    public HumorDao() {
        this.conexao = new ConexaoBD().getConnection();
    }
    public void adicionaHumor(Humor humor) {
        
        String sql = "INSERT INTO humorusuario (login, dataHumor, valor) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, humor.getLogin());
            ps.setInt(3, humor.getValor());
            ps.setDate(2, humor.getDataHumor());
            ps.execute();
            ps.close();
            
        }
        
        catch(SQLException e) {
            throw new RuntimeException(e);
            
        }
    }
    
    public boolean verificaHumor(java.sql.Date dataEntrada, String loginUsuario){
        String sql = "SELECT * from humorusuario WHERE dataHumor = ? AND login = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDate(1, dataEntrada);
            ps.setString(2, loginUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
                }
            else {
                return false;
            
                
            }
            
            }
        catch(SQLException e)  {
            throw new RuntimeException(e);
        }
        
       }
    public List<Humor> getHumorByLogin (String loginUsuario) {
         List<Humor> listaHumor = new ArrayList<>();
        String sql = "Select * FROM humorusuario WHERE login = ? ORDER BY dataHumor DESC";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, loginUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Humor humor = new Humor();
                humor.setLogin(rs.getString("login"));
                humor.setDataHumor(rs.getDate("dataHumor"));
                humor.setValor(rs.getInt("valor"));
                listaHumor.add(humor);
                }
            ps.close();
            rs.close();
            return listaHumor;
            
            
           
            }
        catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    } 
}
