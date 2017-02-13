/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;

import java.util.*;

public class ComparadorPersonas implements Comparator<Persona> {

    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.Edad - p2.Edad;
    }
    
}
