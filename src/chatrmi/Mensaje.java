/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi;

import java.io.Serializable;

/**
 *
 * @author Miranda
 */
public class Mensaje implements Serializable{
    private String sender;
    private String mensaje;

    public Mensaje(String sender, String message) {
        this.sender = sender;
        this.mensaje = message;
    }
    
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
     
    @Override
    public String toString() {
        return "chat> " + this.sender + ": " + this.mensaje;
    }
}
