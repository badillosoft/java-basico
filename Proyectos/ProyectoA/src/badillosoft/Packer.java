package badillosoft;

import badillosoft.ui.PackerUI;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * @author Alan Badillo Salas badillo.soft@hotmail.com
 * @version 1.0
 * 
 * Esta clase se encarga de mezclar archivos
 * uniendo sus bytes en un sólo archivo.
 */
public class Packer implements Runnable {
    
    private PackerUI ui;
    private final ArrayList<File> files = new ArrayList();
    // TODO: Crea dos atributos de tipo String llamados pack_filename y meta_filename
    
    public void setPackerUI(PackerUI ui) {
        this.ui = ui;
    }
    
    public void setPackFilename(String value) {
        this.pack_filename = value;
        
        this.log("Set Pack filename: " + value);
    }

    public void setMetaFilename(String value) {
        this.meta_filename = value;
        
        this.log("Set Meta filename: " + value);
    }
    
    public void log(String message) {
        if (this.ui == null) {
            System.out.printf("%s%n", message);
            return;
        }
        
        ui.jTextArea1.append(String.format("%s%n", message));
    }
    
    public void error(String message) {
        if (this.ui == null) {
            System.out.println("-- error --");
            System.out.printf("Error: %s%n", message);
            System.out.println("--");
            return;
        }
        
        this.log("-- error --");
        this.log(message);
        this.log("--");
        
        ui.jLabel1.setText(String.format("Error: %s%n", message));
    }
    
    public void add(String filename) {
        // TODO: Descomenta la siguiente line de código
        //this.add(new File(filename));
    }
    
    public void add(File file) {
        this.files.add(file);
    }
    
    public void clear() {
        this.files.clear();
    }
    
    public void progress(String filename, long value, long total) {
        if (this.ui == null) {
            return;
        }
        
        // TODO: Crea la variable `int p` que contenga
        // el porcentaje de 0 a 100 utilizando las variables
        // value y total
        
        this.ui.jProgressBar1.setValue(p);
        this.ui.jLabel1.setText(String.format("%s (%d%%)", filename, p));
        
        if (p == 100) {
            this.ui.jProgressBar1.setValue(0);
            this.ui.jLabel1.setText("Listo");
        }
    }
    
    public void lock() {
        if (this.ui == null) {
            return;
        }
        
        this.ui.jMenuItem3.setEnabled(false);
    }
    
    public void unlock() {
        if (this.ui == null) {
            return;
        }
        
        this.ui.jMenuItem3.setEnabled(true);
        this.ui.jLabel1.setText("Listo");
    }
    
    public void pack() {
        this.lock();
        this.log("-- packer v1.0 --");
        
        if (this.files.size() <= 0) {
            this.log("Files not found");
            this.log("--");
            this.log("");
            this.unlock();
            return;
        }
        
        String uuid = UUID.randomUUID().toString();
        
        String pack_filename = this.pack_filename;
        String meta_filename = this.meta_filename;
        
        try {
            BufferedOutputStream pack_stream = new BufferedOutputStream(
                // TODO: Crea un FileOutputStream con this.pack_filename
            );
            
            this.log(String.format("Pack file: %s", pack_filename));
            this.log(String.format("Meta file: %s", meta_filename));
            
            File f_pack = new File(pack_filename);
            File f_meta = new File(meta_filename);
            
            if (this.ui != null && (f_pack.isFile() || f_meta.isFile())) {
                int result = JOptionPane.showConfirmDialog(this.ui.jMenuItem3,
                    "El archivo ya existe. ¿Desea reemplazarlo?", "El archivo ya existe", JOptionPane.WARNING_MESSAGE);
                
                if (result != JOptionPane.OK_OPTION) {
                    this.log("-- cancelado --");
                    this.log("");
                    this.unlock();
                    return;
                }
            }
            
            if (f_pack.isFile()) {
                this.log("Warning: Replace " + pack_filename);
            }
            
            if (f_meta.isFile()) {
                this.log("Warning: Replace " + meta_filename);
            }
            
            this.log("-- start --");
            
            // TODO: Crea meta_stream de tipo FileWriter con this.meta_filename de parámetro
            
            for (File f : this.files) {
                this.log(String.format("Adding: %s (%d bytes)", f.getAbsolutePath(), f.length()));
                
                String filename = f.getAbsolutePath();
                long total = f.length();
                
                meta_stream.write(String.format("%s#%d%n", f.getName(), total));
                
                BufferedInputStream file_stream = new BufferedInputStream(
                    new FileInputStream(f)
                );
                
                long count = 0;
                int b;
                while ((b = file_stream.read()) != -1) {
                    pack_stream.write(b);
                    this.progress(filename, ++count, total);
                }
                
                file_stream.close();
            }
            
            pack_stream.close();
            //this.log("-- close pack --");
            meta_stream.close();
            //this.log("-- close meta --");
        } catch(IOException e) {
            this.error(e.getMessage());
            this.log("");
            this.unlock();
            return;
        }
        
        File f = new File(pack_filename);
        
        this.log("-- finished --");
        this.log(String.format("Total Size: %d bytes", f.length()));
        this.log("--");
        this.log("");
        this.unlock();
    } 
    
    @Override
    public void run() {
        // TODO: LLama al método `pack` de esta clase
    }
    
    public static void main(String[] args) {
        Packer packer = new Packer();
        
        packer.setPackFilename("/badillosoft/output.pack");
        packer.setMetaFilename("/badillosoft/output.meta");
        
        packer.add("/badillosoft/a.jpg");
        packer.add("/badillosoft/b.pdf");
        packer.add("/badillosoft/c.rar");
        
        packer.pack();
    }
    
}
