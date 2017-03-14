package cic;

import java.util.*;
import java.io.*;

public class EscribirNumeros {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("C:/archivos/numeros_2.txt");
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < 1000; i++) {
                int x = i * i - 2 * i + 8;
                
                sb.append(i);
                
                sb.append(": ");
                
                sb.append(x);
                
                sb.append(", ");
                
                // fw.write(String.format("%d: %d, ", i, x));
            }
            
            fw.write(sb.toString());
            
            fw.close();
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
