package CS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
    public static void main(String[] args){
        
        final String host = "localhost";
        final int puerto = 5000;
        Socket socket = null;
        DataInputStream messIn;
        DataOutputStream messOut;
        Scanner scan = new Scanner(System.in);
        String salida = "";
        String mensaje = "";
        boolean cond = true;
        
        try{
            
            while(cond){
                
                socket = new Socket(host, puerto);
                messIn = new DataInputStream(socket.getInputStream());
                messOut = new DataOutputStream(socket.getOutputStream());
                
                if(salida.equalsIgnoreCase("chau")){
                    cond = false;
                    socket.close();
                }else{
                    salida = scan.nextLine();
                    messOut.writeUTF(salida);
                    mensaje = messIn.readUTF();
                    System.out.println(mensaje);
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}