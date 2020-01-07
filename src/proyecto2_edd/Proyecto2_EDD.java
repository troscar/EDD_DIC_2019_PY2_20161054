/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

import EDD.*;
import Graficas.*;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TimerTask;
import javax.swing.Timer;
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
    public static  AVLTree arbolAVL = new AVLTree();
    public  static Graph graph ;
    public static ArbolB arbol= new ArbolB();
            
    
    public static void main(String[] args) throws NodoExcepciones  {
        //System.out.println("Hola Mundo");
        
        // TODO code application logic here
        Login login = new Login();
        login.setVisible (true);   
    }
    
}
