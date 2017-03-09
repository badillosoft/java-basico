package cic;

import java.util.*;
import java.io.*;

public class Packer implements Runnable {
    
    private ArrayList<File> files = new ArrayList();
    private String path = "/Users/alan";
    private String base_name = "my_file.pack";
    private String meta_name = "my_file.meta";
    
    private PackerUI ui;
    
    public Packer() { }
    
    public Packer(PackerUI ui) {
        this.ui = ui;
    }

    void console(String text) {
        if (this.ui == null) {
            return;
        }
        
        this.ui.jTextAreaConsole.append(text + "\r\n");
    }
    
    void progress(String filename, int percent) {
        if (this.ui == null) {
            return;
        }
        
        ui.jLabelState.setText(
                String.format("File: %s (%%%d)",
                filename, percent)
        );
        
        ui.jProgressBarState.setValue(percent);
        
        if (percent == 100) {
            ui.jLabelState.setText("Listo");
        }
    }
    
    void addFile(String filename) {
        files.add(new File(filename));
        
        console("Añadiendo: " + filename);
    }
    
    void addFile(File file) {
        files.add(file);
        
        console("Añadiendo: " + file.getAbsolutePath());
    }
    
    int sizeOfFile(File f) throws IOException {
        FileReader fr = new FileReader(f);
        
        int bytes = 0;
        
        while (fr.read() != -1) {
            bytes++;
        }
        
        fr.close();
        
        console(f.getName() + " " + bytes);
        
        return bytes;
    }
    
    @Override
    public void run() {
        try {
            this.pack();
        } catch(Exception err) {
            //
        }
    }
    
    void pack() throws IOException {
        String fnb = this.path + "/" + this.base_name;
        String fnm = this.path + "/" + this.meta_name;
        
        console("");
        console("Empaqutando...");
        console("Pack: " + fnb);
        console("Meta: " + fnm);
        
        BufferedOutputStream fwb = new BufferedOutputStream(
                new FileOutputStream(fnb));
        
        FileWriter fwm = new FileWriter(fnm);
        
        console("--------------------------");
        
        int total = 0;
        
        for (File f : this.files) {
            String name = f.getName();
            int size = this.sizeOfFile(f);
            total += size;
            
            fwm.write(String.format("%s %d%n", name, size));
            
            FileReader fr = new FileReader(f);
            
            int b, count = 0;
            
            while ((b = fr.read()) != -1) {
                fwb.write(b);
                count++;
                
                int percent = 100 * count / size;
                
                progress(f.getName(), percent);
            }
            
            fr.close();
            
            console("--------------------------");
        }
        
        fwb.close();
        fwm.close();
        
        console("Finish. Total bytes: " + total);
        console("**************************");
    }
    
    public static void main(String[] args) throws IOException {
        Packer packer = new Packer();
        
        packer.addFile("C:/msdia80.dll");
        packer.addFile("C:/archivos/datos.txt");
        packer.addFile("C:\\Users\\Aula E2\\Desktop\\sesion_1.zip");
        packer.addFile("C:\\Users\\Aula E2\\Desktop\\sesion_2.zip");
        packer.addFile("C:\\Users\\Aula E2\\Desktop\\sesion_3.zip");
        packer.addFile("C:\\Users\\Aula E2\\Desktop\\sesion_4.zip");
        
        packer.pack();
    }
}
