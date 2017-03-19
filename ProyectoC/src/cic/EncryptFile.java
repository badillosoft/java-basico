/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Aula E2
 */
public class EncryptFile {
    
    static int[] transform(int[] block, int k) {
        int n = block.length;
        
        int[] t_block = new int[n];
        
        for (int i = 0; i < n; i++) {
            t_block[i] = block[(i + k) % n];
        }
        
        return t_block;
    }
    
    static void encript(InputStream fin, OutputStream fout, int N, int L, int K) throws IOException {
        int m = (N / L);
        
        if (N % L != 0) {
            m += 1;
        }
        
        for (int b = 0; b < m; b++) {
            int[] block = new int[L];
            
            for (int l = 0; l < L; l++) {
                int bin = fin.read();
                
                /*if (bin < '0') {
                    bin = '?';
                }*/
                
                //System.out.printf("%c", (byte)bin);
                
                if (bin == -1) {
                    bin = 0;
                }
                
                block[l] = bin;
            }
            
            /*for (byte by : block) {
                System.out.printf("%c", by);
            }
            System.out.println();*/
            
            int[] t_block = EncryptFile.transform(block, K);
            
            for (int by : t_block) {
                //System.out.printf("%c", by);
                fout.write(by);
            }
            //System.out.println();
            
            /*byte[] o_block = Encrypt.transform(t_block, L - K);
            
            for (byte by : o_block) {
                System.out.printf("%c", by);
            }
            System.out.println();*/
        }
    }
    
    public static void main(String[] args) {
        
        try {
            FileInputStream fin = new FileInputStream("C:/archivos/dog_enc.jpg");
            
            int size = 0;
            while (fin.read() != -1) {
                size++;
            }
            
            System.out.println(size);
            
            fin = new FileInputStream("C:/archivos/dog_enc.jpg");
            FileOutputStream fout = new FileOutputStream("C:/archivos/dog_dec.jpg");
            
            EncryptFile.encript(fin, fout, size, 1024, 1024 - 127);
            
            fin.close();
            fout.close();
        } catch(Exception err) {
            
        }
    }
    
}
