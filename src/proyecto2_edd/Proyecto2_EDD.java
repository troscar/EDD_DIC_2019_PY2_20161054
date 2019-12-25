/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tracs
 */
public class Proyecto2_EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("myJson.json"));
            JSONObject jsonObj =(JSONObject)obj;
            String name = (String)jsonObj.get("Name");
            System.out.println("Name is: "+name);
            
            String location = (String)jsonObj.get("Localitazion");
            System.out.println("Name is: "+location);
            
            JSONArray cousesa = (JSONArray)jsonObj.get("Lenguajes");
            Iterator<String> iterator = cousesa.iterator();
            while(iterator.hasNext())
            {
                System.out.println("Lenguajes: "+iterator.next());
            }
        } catch (Exception e) {
        }
        
    }
    
}
