package cic;

import java.util.*;
import java.io.*;

public class LeerNumeros {
    
    ArrayList<Integer> numeros = new ArrayList();
    
    void cargar_archivo(String nombre) {
        try {
            
            // 1. Abrir el stream del archivo
            FileReader fr = new FileReader(nombre);
            
            // 2. Crear un scanner para el flujo del archivo
            Scanner sc = new Scanner(fr);
            
            /*int x = sc.nextInt();
            int y = sc.nextInt();
            
            System.out.printf("%d %d %n", x, y);*/
            
            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                
                numeros.add(x);
            }
            
        } catch(Exception err) {
            System.out.println(err.getMessage());
        }
    }
    
    public static void main(String[] args) {
        LeerNumeros ln = new LeerNumeros();
        
        ln.cargar_archivo("C:/archivos/numeros.txt");
        
        System.out.println(ln.numeros);
        
        ln.numeros.sort(new ComparadorNumeros());
        
        System.out.println(ln.numeros);
    }
    
}
