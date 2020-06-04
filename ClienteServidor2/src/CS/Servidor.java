package CS;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    
    public static void main(String[] args){
        
        //Definición de número de puerto y Socket del cliente
        final int PUERTO = 5000;
        Socket socket = null;
        
        //Definición de un flujo de entrada y uno de salida
        DataInputStream messIn;
        DataOutputStream messOut;
        
        //Escaner para envío de datos por el teclado
        Scanner scan = new Scanner(System.in);
        boolean cond = true;
        String salida = "";
        String mensaje = "";
        
        //Servidor en espera de clientes
        try{
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("*Servidor iniciado, el cliente inicia la conversación*");
            
            while(cond){
                
                socket = servidor.accept();
                messIn = new DataInputStream(socket.getInputStream());
                messOut = new DataOutputStream(socket.getOutputStream());
                mensaje = messIn.readUTF();
                
                if(mensaje.equalsIgnoreCase("chau")){
                    System.out.println(mensaje);
                    cond = false;
                    socket.close();
                }else{
                    System.out.println(mensaje);
                    salida = scan.nextLine();
                    messOut.writeUTF(salida);
                }
                
            }
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
