/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

/**
 *
 * @author Aula E2
 */
public class Ordenamiento {
    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList();
        
        for (int x : new int[] {8, 5, 4, 1, 2, 6, 3}) {
            A.add(x);
        }
        
        System.out.println("List A:");
        System.out.println(A);
        
        ArrayList<Integer> B = new ArrayList();
        
        while (!A.isEmpty()) {
            int menor = A.get(0);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) < menor) {
                    menor = A.get(i);
                }
            }
            
            A.remove(new Integer(menor));
            
            B.add(menor);
        }
        
        System.out.println("List B:");
        System.out.println(B);
        
    }
    
}
