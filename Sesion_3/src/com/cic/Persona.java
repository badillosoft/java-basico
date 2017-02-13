/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

/**
 *
 * @author Aula E2
 */
public class Persona {
    String Nombre;
    int Edad;
    
    @Override
    public String toString() {
        return String.format("%s (%d)", Nombre, Edad);
    }
    
    void Saludar() {
        System.out.printf("Hola soy %s y tengo %d años", 
            this.Nombre, this.Edad);
    }
}