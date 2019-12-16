/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author José M. Miranda V. <miranda_manuel97 at gmail.com>
 */
public class ClienteImpl extends UnicastRemoteObject implements ClienteInterface{
    
    private String nombre;

    public ClienteImpl(String nombre) throws RemoteException {
        super();
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public void recibirMensaje(Mensaje mensaje) throws RemoteException {
        if (!nombre.equals(mensaje.getSender())) {
            System.out.println(mensaje);
        }
    }

}
