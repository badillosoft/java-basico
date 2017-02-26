package cic;

import java.io.File;

public class InfoArchivo {
    
    public static void main(String[] args) {
        File f = new File("C:/archivos/foo");
  
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        
        f.mkdir();
    }
    
}
