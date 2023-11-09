/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author oscar
 */
public class Deposito_Retiro {
    private String user;
    private int cantidad;

    public Deposito_Retiro() {
    }

    public Deposito_Retiro(String user, int cantidad) {
        this.user = user;
        this.cantidad = cantidad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
