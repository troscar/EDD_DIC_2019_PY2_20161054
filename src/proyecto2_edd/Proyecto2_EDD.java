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
    public static AVLTree arbolAVL = new AVLTree();
    
    
    public static void main(String[] args) throws NodoExcepciones  {
        //System.out.println("Hola Mundo");
        
        // TODO code application logic here
        Login login = new Login();
        login.setVisible (true);
        
//        ArbolB arbol= new ArbolB();
//        arbol.insertar(5);
//        arbol.insertar(6);
//        arbol.insertar(11);
//        arbol.insertar(10);
//        arbol.insertar(20);
//        arbol.insertar(7);
//        arbol.insertar(40);
//        arbol.insertar(55);
//        arbol.insertar(8);
//        arbol.insertar(60);
//         // arbol.insertar(70);
//        arbol.imprimir();
//        boolean resul=arbol.buscar(7);
//        System.out.println("el numero 7 se encuentra en el arbol? " + resul);
//        arbol.borrar(6);
//        arbol.imprimir();
//        System.out.println("-----------------");
//         arbol.borrar(6);
//        arbol.imprimir(); 
//        System.out.println("-----------------");
//        //arbol.borrar(6);
//        arbol.imprimir();
//        arbol.insertar(7);
//        arbol.insertar(8);
//        System.out.println("----------------");
//        arbol.imprimir();
//        
//        
////    Timer timer;
    

    
    }
    
}
