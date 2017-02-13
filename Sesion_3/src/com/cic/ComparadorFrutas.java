/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic;


import java.util.*;

public class ComparadorFrutas implements Comparator<String> {
    
    @Override
    public int compare(String f1, String f2) {
        return f1.compareTo(f2);
    }

}
