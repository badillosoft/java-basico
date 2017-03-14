/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

import java.util.*;
import java.io.*;

public class Ej1 {

    public static void main(String[] args) {
        HashSet<Integer> numeros = new HashSet();
        
        try {
            FileReader fr = new FileReader("C:/archivos/numeros.txt");
            
            Scanner sc = new Scanner(fr);
            
            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                
                numeros.add(x);
            }
            
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(numeros);

    }

}
