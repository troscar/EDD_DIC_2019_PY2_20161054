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
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        //System.out.println("Hola Mundo");
        
        // TODO code application logic here
        Login login = new Login();
        login.setVisible (true);
        
////        
//        Integer elemento1 = new Integer("1");
//        Integer elemento2 = new Integer("2");
//        Integer elemento3 = new Integer("3");
//        Integer elemento4 = new Integer("4");
//        Integer elemento5 = new Integer("5");
//        Integer elemento6 = new Integer("6");
//        Integer elemento7 = new Integer("7");
//        Integer elemento8 = new Integer("15");
//        Integer elemento9 = new Integer("14");
//        Integer elemento10 = new Integer("13");
//
//        arbolAVL.insertar(elemento1);
//        arbolAVL.insertar(elemento2);
//        arbolAVL.insertar(elemento3);
//        arbolAVL.graficarArbol("2",1);
//        System.out.println("1");
//        Thread.sleep(10000);
//        arbolAVL.insertar(elemento4);
//        System.out.println("2");
//        Thread.sleep(10000);
//        System.out.println("3");
//        arbolAVL.graficarArbol("1",0);
//        System.out.println("4");
//        String ruta = "C:\\Users\\tracs\\Documents\\NetBeansProjects\\Proyecto2_EDD\\Arbols.json";
//        JSONParser parser = new JSONParser();
//        try {
//            if(!"".equals(ruta)){
//                Object obj = parser.parse(new FileReader(ruta));
//                JSONObject arbol=(JSONObject) obj;
//                JSONArray jsonA =(JSONArray)arbol.get("Input");
//                //System.out.println(jsonA.size());
//                JSONObject usuario;
//                System.out.println(jsonA.get(0));
//                int num;
//                for(Object j: jsonA){
//                    usuario = (JSONObject) j;
//                    System.out.println(usuario.get("num"));
//                    num = (int)(long)usuario.get("num");
//                }
//                                
//            }
//        } catch (IOException | ParseException e) {
//            
//        }
    }
    
}
