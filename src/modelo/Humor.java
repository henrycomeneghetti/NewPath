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
public class Humor {
    private int valor;
    private Date dataHumor;
    private String loginUsuario;
    
    public String getLogin() {
        return loginUsuario;
    }

    public void setLogin(String loginUsuario) {
        this.loginUsuario = loginUsuario;
        
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public java.sql.Date getDataHumor() {
        return dataHumor;
    }

    public void setDataHumor(java.sql.Date dataHumor) {
        this.dataHumor = dataHumor;
    }

    
}
