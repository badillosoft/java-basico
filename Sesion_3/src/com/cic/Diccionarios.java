/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

public class Diccionarios {
    public static void main(String[] args) {
        HashMap<String, String> palabras = new HashMap();
        
        palabras.put("flor", "Una flor es....");
        palabras.put("perro", "Un perro es...");
        
        System.out.println(palabras);
        
        if (!palabras.containsKey("abeja")) {
            System.out.println("No contiene <abeja>");
        }
        
        String desc_perro = palabras.get("perro");
        
        System.out.println(desc_perro);
    }
}
