/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        JSONObject obj = new JSONObject();
        obj.put("Name","MY namen :v");
        obj.put("Localitazion", "Guate");
        
        JSONArray list = new JSONArray();
        list.add("JAVA");
        list.add("C++");
        
        obj.put("Lenguajes",list);
        
        try  {
            FileWriter file = new FileWriter("myJson.json");
            file.write(obj.toString());
            file.flush();
        } catch (Exception e) {
        }
        System.out.println(obj);
        
        
    }
    
}
