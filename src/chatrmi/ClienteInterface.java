/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author José M. Miranda V. <miranda_manuel97 at gmail.com>
 */
public interface ClienteInterface extends Remote{
    public void recibirMensaje(Mensaje mensaje) throws RemoteException;
    public String getNombre() throws RemoteException;
    
}
