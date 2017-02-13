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
public class TestPersona {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.Nombre = "Pepe";
        p.Edad = 18;
        
        Estudiante q = new Estudiante();
        q.Nombre = "Paco";
        q.Edad = 19;
        q.Matricula = "ABC123";
        
        p.Saludar();
        q.Saludar();
        
        q.otro();
    }
}
