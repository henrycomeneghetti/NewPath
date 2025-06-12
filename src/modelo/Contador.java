/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author hmq48
 */
public class Contador {
    private String login;
    private Date dataEntrada;
    private Date dataAtual;
    private String vicio;
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String usuarioLogin) {
        this.login = usuarioLogin;
    }
    
    public Date getDataEntrada() {
        return dataEntrada;
    }
    
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    public Date getDataAtual() {
        return dataAtual;
    }
    
    public void setDataAtual(Date dataAtual){
        this.dataAtual = dataAtual;
    }
    
    public String getVicio() {
        return vicio;
    }
    
    public void setVicio(String vicio) {
        this.vicio = vicio;
    }
    
    
    
   
}
