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
public class Estudiante extends Persona {
    
    String Matricula;
    
    @Override
    void Saludar() {
        System.out.printf("Hola soy %s, tengo %d años y soy estudiante con matricula %s",
            this.Nombre, this.Edad, this.Matricula);
    }
    
    void otro() {
        System.out.println("Hola mundo");
    }
    
}
