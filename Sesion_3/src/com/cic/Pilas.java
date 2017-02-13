/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

public class Pilas {
    public static void main(String[] args) {
        Stack<String> canasta = new Stack();
        
        canasta.push("Manzana");
        canasta.push("Pera");
        canasta.push("Mango");
        
        System.out.println(canasta);
        
        String mango = canasta.pop();
        String pera = canasta.pop();
        canasta.push(mango);
        canasta.push(pera);
        
        System.out.println(canasta);
    }
}
