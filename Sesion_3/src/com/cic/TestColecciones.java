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
public class TestColecciones {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList();
        
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Piña");
        
        frutas.add(1, "Mango");
        
        System.out.println(frutas);
        
        System.out.printf("Total: %d\n", frutas.size());
    }
}
