package cic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {
    
    public static void main(String[] args) 
            throws FileNotFoundException, IOException {
        
        FileReader f = new FileReader("C:/archivos/datos.txt");
        
        /*
        int c = f.read();
        
        System.out.printf("%c\n",  c);
        */
        
        int c;
        
        while ((c = f.read()) != -1) {
            System.out.printf("%c", c);
        }
        
        f.close();
    }
    
}
