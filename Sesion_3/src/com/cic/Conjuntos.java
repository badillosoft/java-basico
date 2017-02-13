/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

public class Conjuntos {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList();
        
        for (String f : new String[] {"Manzana", "Manzana", "Pera", "Manzana", "Pera", "Pera", "Manzana", "Pera"}) {
            frutas.add(f);
        }
        
        System.out.println("Frutas");
        System.out.println(frutas);
        
        HashSet<String> tipo_frutas = new HashSet();
        
        tipo_frutas.addAll(frutas);
        
        System.out.println("Tipo Frutas");
        System.out.println(tipo_frutas);
        
        for (String fruta : frutas) {
            System.out.println(fruta);
        }
        
        ComparadorFrutas cf = new ComparadorFrutas();
        
        frutas.sort(cf);
        
        System.out.println("Frutas");
        System.out.println(frutas);
    }
}
