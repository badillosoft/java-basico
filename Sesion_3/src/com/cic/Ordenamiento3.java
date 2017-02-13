/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

public class Ordenamiento3 {
    
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList();
    
        Random r = new Random();
        
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona();
            p.Nombre = String.format("Pepe00%d", r.nextInt(1000));
            p.Edad = r.nextInt(100 - 18) + 18;
            personas.add(p);
        }
        
        System.out.println(personas);
        
        ComparadorPersonas cp = new ComparadorPersonas();
        
        personas.sort(cp);
        
        System.out.println(personas);
    }
}
