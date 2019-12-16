/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author José M. Miranda V. <miranda_manuel97 at gmail.com>
 */
public class ServidorImpl extends UnicastRemoteObject implements ServidorInterface{
    
    private final ArrayList<ClienteInterface> clientes;

    public ServidorImpl() throws RemoteException {
        super();
        clientes = new ArrayList<>();
    }

    @Override
    public synchronized void registrarCliente(ClienteInterface cliente) throws RemoteException {
        this.clientes.add(cliente);
        Mensaje mensaje = new Mensaje(cliente.getNombre(), "Se ha conectado.");
        this.trasmitirMensaje(mensaje);
    }
    
    @Override
    public synchronized void desconectarCliente(ClienteInterface cliente) throws RemoteException {
        this.clientes.remove(cliente);
        Mensaje mensaje = new Mensaje(cliente.getNombre(),"Se ha desconectado.");
        this.trasmitirMensaje(mensaje);
    }

    @Override
    public synchronized void trasmitirMensaje(Mensaje mensaje) throws RemoteException {
        Iterator<ClienteInterface> iterator = clientes.iterator();
        while(iterator.hasNext()){
            iterator.next().recibirMensaje(mensaje);
        }
        
    }

}
