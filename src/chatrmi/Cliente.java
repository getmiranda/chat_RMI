/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * 
 * @author José M. Miranda V. <miranda_manuel97 at gmail.com>
 */
public class Cliente {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
            ServidorInterface servidorInterface = (ServidorInterface) Naming.lookup("rmi://localhost/chat");
            
            System.out.print("Para participar en la sala de chat ingrese su nickname.\n"
                    + "Para salir de la sala presiona [...]\n"
                    + "Nickname: ");
            String nombre = sc.nextLine();
            
            ClienteInterface clienteImplementacion = new ClienteImpl(nombre);
            servidorInterface.registrarCliente(clienteImplementacion);
            Mensaje mensaje = new Mensaje(nombre, "");
            System.out.println("Bienvenido al chat.");
            
            while (true) { 
                mensaje.setMensaje(sc.nextLine());
                servidorInterface.trasmitirMensaje(mensaje);
                
                if (mensaje.getMensaje().equals("...")) {
                    break;
                }
            }
            
            servidorInterface.desconectarCliente(clienteImplementacion);
            System.exit(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
