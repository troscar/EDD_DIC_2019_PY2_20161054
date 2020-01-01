/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

import EDD.*;
import Graficas.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author tracs
 */
public class Proyecto2_EDD {

    /**
     * @param args the command line arguments
     */
    public static HashTable hash = new HashTable();
    public static void main(String[] args) {
        
        // TODO code application logic here
        

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("Usuarios.json"));
            JSONArray jsonA =(JSONArray)obj;
            JSONObject usuario;
            for(Object j: jsonA){
                usuario = (JSONObject) j;
                hash.Ingresar((String)usuario.get("Nombre"), (String)usuario.get("Apellido"), (String)usuario.get("Carnet"), (String)usuario.get("Password"));
//                System.out.println("--------------------------------------------------");
//                System.out.println("El nombre es: "+(String) usuario.get("Nombre"));
//                System.out.println("El apellido es: "+(String) usuario.get("Apellido"));
//                System.out.println("El carnet es: "+(String) usuario.get("Carnet"));
//                System.out.println("El password es: "+(String) usuario.get("Password"));
            }
        } catch (IOException | ParseException e) {
            
        }
        System.out.println("------------------------------------");
       hash.Ingresar("Colette", "Harly", "57-815-1498", "wmYOZ7");
        hash.Mostrar();
        Login login = new Login();
        login.setVisible (true);

    }
    
}
