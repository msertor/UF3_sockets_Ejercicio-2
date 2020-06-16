
package uf3_sockets_ejercicio.pkg2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    
       public static void main(String[] args) throws IOException {
  
   ServerSocket servidor = new ServerSocket(9999);
   Socket misocket=servidor.accept();
   
   DataInputStream flujo_entrada=new DataInputStream(misocket.getInputStream());
   boolean repetir = true;//variable para terminar el loop
   
   while (repetir){//loop para que vaya leyendo lo que le envía el cliente hasta que se despida
    String mensaje_texto = flujo_entrada.readUTF();   
       if (mensaje_texto.matches(".*[h|H]ola.*|.*[h|H]ello.*")){//regex para jugar con diferentes posibilidades
                  System.out.println("Hola, soy un bot");  
        }

        else if (mensaje_texto.matches(".*[A|a]di[o|ó]s.*|.*[B|b]ye.*|.*[H|h]asta luego.*")){
                  System.out.println("Adiós, encantado de conocerte");
                  repetir=false;
        }

         else if (mensaje_texto.contains("llamas")){
                  System.out.println("Me llamo Jorge");  
        }
       
        else if (mensaje_texto.matches(".*edad.*|.*años.*")){
                  System.out.println("No tengo edad, soy un bot");  
        }
       
        else if (mensaje_texto.contains("color")){
                  System.out.println("Mi color favorito es el verde");  
        }
       
       else if (mensaje_texto.matches(".*comida.*|.*plato.*")){
                  System.out.println("Mi comida favorita es la pizza");  
        }
   } 
 
    flujo_entrada.close();
    misocket.close();
        
    }
}
