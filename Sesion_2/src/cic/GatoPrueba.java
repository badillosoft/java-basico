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
public class GatoPrueba {
    public static void main(String[] args) {
        Gato gato = new Gato();
        
        System.out.println(gato.Tablero());
        
        gato.setCasilla(4, 'o');
        System.out.println(gato.Tablero());
        
        gato.setCasilla(2, 'x');
        System.out.println(gato.Tablero());
        
        gato.setCasilla(2, 'o');
        System.out.println(gato.Tablero());
        
        gato.setCasilla(5, 'o');
        System.out.println(gato.Tablero());
        
        gato.setCasilla(1, 'x');
        System.out.println(gato.Tablero());
        
        gato.setCasilla(3, 'o');
        System.out.println(gato.Tablero());
    }
}
