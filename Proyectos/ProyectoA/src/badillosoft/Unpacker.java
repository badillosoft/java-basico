package badillosoft;

import badillosoft.ui.UnpackerUI;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

/**
 * @author Alan Badillo Salas badillo.soft@hotmail.com
 * @version 1.0
 *
 * Esta clase se encarga de extraer archivos empaquetados por la clase Packer.
 *
 * @see badillosoft.Packer
 */
public class Unpacker implements Runnable {

    private UnpackerUI ui;
    private final ArrayList<ArrayList<Byte>> streams = new ArrayList();
    private final ArrayList<String> files = new ArrayList();
    private String pack_filename = "";
    private String meta_filename = "";
    private String output_path = "";
    private String command = "unpack";
    private int index = 0;

    public void setUnpackerUI(UnpackerUI ui) {
        this.ui = ui;
    }

    public String getOutputPath() {
        return this.output_path;
    }

    public void setOutputPath(String value) {
        this.output_path = value;
    }

    public void setPackFilename(String value) {
        this.pack_filename = value;

        this.log("Loaded Pack filename: " + value);
    }

    public void setMetaFilename(String value) {
        this.meta_filename = value;

        this.log("Loaded Meta filename: " + value);
    }

    public void commandUnpack() {
        this.command = "unpack";
    }

    public void commandSaveAll() {
        this.command = "saveAll";
    }

    public void commandSave(int index) {
        this.command = "save";
        this.index = index;
    }
    
    public void remove(int index) {
        this.log("Removed: " + this.files.get(index));
        
        this.files.remove(index);
        this.streams.remove(index);
    }
    
    public void clear() {
        this.log("Clear all files");
        
        this.files.clear();
        this.streams.clear();
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

    public void lock() {
        if (this.ui == null) {
            return;
        }

        //this.ui.jMenuItem3.setEnabled(false);
    }

    public void unlock() {
        if (this.ui == null) {
            return;
        }

        //this.ui.jMenuItem3.setEnabled(true);
    }

    public void add(String filename, ArrayList<Byte> stream) {
        this.files.add(filename);
        this.streams.add(stream);

        this.log(String.format("Unpacked: %s (%d bytes)", filename, stream.size()));

        if (this.ui == null) {
            return;
        }

        ((DefaultListModel<String>) this.ui.jList1.getModel()).addElement(
                String.format("%s (%d bytes)", filename, stream.size())
        );
    }

    public int size() {
        // TODO: Regresa el número de elementos de this.files
    }

    public boolean saveAll() {
        boolean flag = false;
        for (int i = 0; i < this.size(); i++) {
            flag = this.save(i) || flag;
        }
        return flag;
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

    public boolean save(int index) {
        this.lock();
        this.log("-- unpacker v1.0 --");

        if (index < 0 || index >= this.files.size()) {
            this.error(String.format("Index error: %d", index));
            this.log("");
            this.unlock();
            return false;
        }

        this.log(String.format("Saving: %s (%d bytes)", this.files.get(index), this.streams.get(index).size()));
        this.log("Output path: " + output_path);

        // TODO: Crea la variable filename de tipo String
        // compuesta de la concatenación de output_path y this.files.get(index)

        try {
            File f = new File(filename);

            if (f.isFile()) {
                this.log(String.format("File exists: %s", filename));
                if (this.ui != null) {
                    String result = JOptionPane.showInputDialog(this.ui,
                            String.format("El archivo %s ya existe. Escriba un nuevo nombre:", f.getAbsolutePath()),
                            f.getName());

                    if (result == null || result == "") {
                        this.log(String.format("Skip: %s", filename));
                        return false;
                    }
                    
                    filename = output_path + "/" + result;
                } else {
                    this.log(String.format("Skip: %s", filename));
                    return false;
                }
            }

            BufferedOutputStream out = new BufferedOutputStream(
                    // TODO: Crea un FileOutputStream con filename como parámetro
            );

            int count = 0;
            for (byte b : this.streams.get(index)) {
                // TODO: Escribe el byte `b` en `out` (hint: out.write)
                this.progress(filename, ++count, this.streams.get(index).size());
            }

            this.log(String.format("Saved: %s", filename));

            out.close();
        } catch (IOException e) {
            this.error(e.getMessage());
            this.log("");
            this.unlock();
            return false;
        }

        this.log("-- finished --");
        this.log("");
        this.unlock();

        return true;
    }

    public void unpack() {
        this.lock();
        this.log("-- unpacker v1.0 --");

        try {
            BufferedInputStream pack_stream = new BufferedInputStream(
                    // TODO: Crea un FileInputStream con this.pack_filename como parámetro
            );

            // TODO: Crea meta_stream de tipo FileReader con this.meta_filename de parámetro

            Scanner sc = new Scanner(meta_stream);

            String pattern = "(.*)#(\\d+)";

            while ((sc.hasNext(pattern))) {
                String line = sc.nextLine();

                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(line);

                if (m.find()) {
                    String filename = m.group(1);
                    long size = Long.parseLong(m.group(2));

                    //this.log(String.format("Reading: %s (%d bytes)", filename, size));
                    ArrayList<Byte> stream = new ArrayList();

                    for (long i = 0; i < size; i++) {
                        stream.add((byte) pack_stream.read());
                    }

                    // TODO: Llama al método `add` de esta clase con filename y stream como parámetros
                }
            }

            pack_stream.close();
            meta_stream.close();
        } catch (IOException e) {
            this.error(e.getMessage());
            this.log("");
            this.unlock();
            return;
        }

        this.log("-- finished --");
        //this.log(String.format("Total Size: %d bytes", f.length()));
        this.log("--");
        this.log("");
        this.unlock();
    }

    @Override
    public void run() {
        switch (command) {
            case "saveAll":
                this.saveAll();
                break;
            case "save":
                this.save(this.index);
                break;
            default:
                this.unpack();
                break;
        }
    }

    public static void main(String[] args) {
        Unpacker unpacker = new Unpacker();

        unpacker.setPackFilename("/badillosoft/output.pack");
        unpacker.setMetaFilename("/badillosoft/output.meta");

        unpacker.setOutputPath("/badillosoft/unpack");

        unpacker.unpack();

        unpacker.saveAll();
    }

}
