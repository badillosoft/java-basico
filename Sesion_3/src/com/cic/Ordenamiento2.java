/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.ArrayList;

/**
 *
 * @author Aula E2
 */
public class Ordenamiento2 {
    
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList();
        
        for (String fruta : new String[] {"Manzana", "Naranja", "naranja", "Oco", "Ñu", "Pera", "Mango", "Arandano"}) {
            A.add(fruta);
        }
        
        System.out.println("List A:");
        System.out.println(A);
        
        ArrayList<String> B = new ArrayList();
        
        while (!A.isEmpty()) {
            String menor = A.get(0);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).compareTo(menor) < 0) {
                    menor = A.get(i);
                }
            }
            
            A.remove(menor);
            
            B.add(menor);
        }
        
        System.out.println("List B:");
        System.out.println(B);
        
    }
    
}
