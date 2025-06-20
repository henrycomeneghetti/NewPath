/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConexaoBD;
import modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


/**
 *
 * @author hmq48
 */
public class ContatoDao {
    private final Connection conexao;
    
    public ContatoDao() {
        this.conexao = new ConexaoBD().getConnection();
            
        try{
           
            Statement stmt = conexao.createStatement();
            conexao.setCatalog("newpath");
            String sqlContato = "CREATE TABLE IF NOT EXISTS contato (" +
            "id INT PRIMARY KEY auto_increment," +
            "nome varchar (30)," +
            "sobrenome varchar(50), " +
            "telefone varchar (15)," +
            "email varchar(40)," +
            "dataNascimento DATE not null," +
            "login varchar(50) not null UNIQUE," +
            "senha varchar(30) not null," +
            "dataAtual DATE not null, "+
            "vicio varchar(50) not null"+
            ");" ;
             stmt.execute(sqlContato);
            String sqlNotas = "CREATE TABLE IF NOT EXISTS notas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "login VARCHAR(50)," +
            "titulo varchar(50)," +
            "descricao text," +
            "dataRegistro DATE," +
            "FOREIGN KEY (login) REFERENCES contato(login)" +
            "ON DELETE CASCADE" +
            ");";
            stmt.execute(sqlNotas);
            String sqlHumor = "CREATE TABLE IF NOT EXISTS humorusuario ("+
            "login VARCHAR(50)," +
            "dataHumor date not null,"+
            "valor int not null," +
            "FOREIGN KEY (login) REFERENCES contato(login)" +
            "ON DELETE CASCADE" +
            ");";
            stmt.execute(sqlHumor);
            
        }
        catch (SQLException e) {
        e.printStackTrace(); 
    }
    
           
           
    }
    
    
   


    
    public void adicionaContato(Contato contato) {
        
        String sql = "INSERT INTO contato (nome, sobrenome, telefone, email, dataNascimento, login, senha, dataAtual, vicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getSobrenome());
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getEmail());
            ps.setDate(5, contato.getDataNascimento());
            ps.setString(6, contato.getLogin());
            ps.setString(7, contato.getSenha());
            ps.setDate(8, contato.getDataAtual());  
            ps.setString(9, contato.getVicio());
            ps.execute();
            ps.close();
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Sobrenome: " + contato.getSobrenome());
            
        }
        
        catch(SQLException e) {
            throw new RuntimeException(e);
            
        }
    }
    
    public boolean login (String login, String senha) {
       try {
  // define o schema

    String sql = "SELECT * FROM Contato WHERE login = ? AND SENHA = ?";
    PreparedStatement ps = conexao.prepareStatement(sql);
    ps.setString(1, login);
    ps.setString(2, senha);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        return true;
    } else {
        return false;
    }

} catch(SQLException e) {
    throw new RuntimeException(e);
}

    }
    
    



    
    public List<Contato> listaContatos() {
        List<Contato> listaContatos = new ArrayList();
        String sql = "SELECT * FROM Contato";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setSobrenome(rs.getString("sobrenome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contato.setDataNascimento(rs.getDate("dataNascimento"));
                contato.setLogin(rs.getString("login"));
                contato.setSenha(rs.getString("senha"));
                contato.setDataAtual(rs.getDate("dataAtual"));
                contato.setVicio(rs.getString("vicio"));
                listaContatos.add(contato);
            }
            return listaContatos;
            
        }
        
        
        catch (SQLException e) {
                throw new RuntimeException(e);
                }
        
    }
    
     public Contato getContatoById(int id) {
        Contato contato = new Contato();
        String sql = "SELECT * FROM Contato WHERE id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setSobrenome(rs.getString("sobrenome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contato.setDataNascimento(rs.getDate("dataNascimento"));
                contato.setLogin(rs.getString("login"));
                contato.setSenha(rs.getString("senha"));
                contato.setVicio(rs.getString("vicio"));
                
                
            }
            rs.close();
            ps.close();
            return contato;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     
     
    
      public void atualizaContato(Contato contato) {
        String sql = "UPDATE Contato SET nome = ?, sobrenome = ?, telefone = ?, email = ?, dataNascimento = ?,"
                + "login = ?,senha = ?, vicio = ? WHERE id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getSobrenome());
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getEmail());
            ps.setDate(5, contato.getDataNascimento());
            ps.setString(6, contato.getLogin());
            ps.setString(7, contato.getSenha());
            ps.setString(8, contato.getVicio());
            ps.setInt(9, contato.getId());
            
            ps.execute();
            ps.close();
        }
         catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
     
     public void removeContato(Integer id) {
        String sql = "DELETE FROM Contato WHERE id=?";
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
    
    public void atualizaData(Contato contato){
        String sql = "UPDATE Contato SET dataAtual = ? WHERE login = ? ";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setDate(1, contato.getDataAtual());
            ps.setString(2, contato.getLogin());
    
            
            ps.execute();
            ps.close();
        }
         catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
    
    public Contato getContatoByLogin(String loginUsuario) {
        Contato contato = new Contato();
        String sql = "SELECT * FROM Contato WHERE login = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, loginUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 contato.setNome(rs.getString("nome"));
                 System.out.println("Nome encontrado: " + contato.getNome());
            } 
            else {
                 System.out.println("Nenhum contato encontrado com esse login.");
            }
            rs.close();
            ps.close();
            return contato;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
