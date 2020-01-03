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
 * @author Oscar
 */
public class Proyecto2_EDD {

    /**
     * @param args the command line arguments
     */
    // ESTRUCTURAS A UTILIZAR EN LA APLICACION 
    public static HashTable hash = new HashTable();
    
    
    public static void main(String[] args) throws IOException {
        //System.out.println("Hola Mundo");
        
        // TODO code application logic here
        Login login = new Login();
        login.setVisible (true);
        //hash.graficar();

    }
    
}
