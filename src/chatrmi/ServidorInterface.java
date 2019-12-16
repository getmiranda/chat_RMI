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
public interface ServidorInterface extends Remote{
    
    public void registrarCliente(ClienteInterface cliente) throws RemoteException;
    public void trasmitirMensaje(Mensaje mensaje) throws RemoteException;
    public void desconectarCliente(ClienteInterface cliente) throws RemoteException;
    
}
