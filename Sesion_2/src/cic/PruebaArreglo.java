/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

/**
 *
 * @author Aula E2
 */
public class PruebaArreglo {
    
    public static void main(String[] args) {
        int[] numeros = new int[10];
        
        for (int i = 0; i < 10; i = i + 2) {
            numeros[i] = -1;
        }
        
        System.out.println(numeros[1]);
    }
    
}
