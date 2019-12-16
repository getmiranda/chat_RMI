/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author José M. Miranda V. <miranda_manuel97 at gmail.com>
 */
public class Server {
    public static void main(String[] args) {
        
        try {
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            ServidorImpl servidorImplementacion = new ServidorImpl();
            reg.rebind("chat", servidorImplementacion);
            System.out.println("Servidor Listo! :D");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
