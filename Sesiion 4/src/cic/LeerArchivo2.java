package cic;

import java.util.Scanner;
import java.io.*;

public class LeerArchivo2 {
    
    public static void main(String[] args) 
            throws FileNotFoundException, IOException {
        
        FileInputStream fin = new FileInputStream("C:/archivos/datos.txt");
        
        Scanner sc = new Scanner(fin);
        
        while (sc.hasNext()) {
            String linea = sc.nextLine();
            
            System.out.print(linea);
            System.out.print(" : ");
            System.out.println(linea.length());
        }
        
        fin.close();
        
    }
    
}
