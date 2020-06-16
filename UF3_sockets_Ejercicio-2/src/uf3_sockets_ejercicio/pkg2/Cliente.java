
package uf3_sockets_ejercicio.pkg2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static Scanner scannerSTR = new Scanner(System.in, "ISO-8859-1");
//he añadido el cambio de codificación en System.in para que pueda interpretar la "ñ" de "años"
    public static void main(String[] args) throws Exception{    
        Socket misocket=new Socket ("localhost",9999);
        
        boolean repetir = true;//esta variable la uso para saber cuándo acaba el loop
        
        DataOutputStream flujo_salida=new DataOutputStream(misocket.getOutputStream());
    
        while (repetir){
        System.out.println("Realiza tu pregunta al bot:");
        String pregunta = scannerSTR.nextLine();
        flujo_salida.writeUTF(pregunta);
            if(pregunta.matches(".*[A|a]di[o|ó]s.*|.*[B|b]ye.*|.*[H|h]asta luego.*")){
        //con esta cadena interpreta toda frase que contenga Adios/adios/Adiós/adiós/Bye/bye/Hasta luego/hasta luego
            repetir=false;
            } 
        } 
        flujo_salida.close();
        misocket.close();
    }
}

