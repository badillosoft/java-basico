/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

/**
 *
 * @author Aula E2
 */
public class Encrypt {
    
    static byte[] transform(byte[] block, int k) {
        int n = block.length;
        
        byte[] t_block = new byte[n];
        
        for (int i = 0; i < n; i++) {
            t_block[i] = block[(i + k) % n];
        }
        
        return t_block;
    } 
    
    public static void main(String[] args) {
        
        byte[] bytes = new byte[] {
            65, 66, 67, 68,
            // 65, 66, 67, 68
            // 66, 67, 68, 65
            // 67, 68, 65, 66
            // 68, 65, 66, 67
            69, 70, 71, 72,
            73, 74, 75, 76,
            77, 78, 79
        };
        
        int L = 7;
        
        int k = 3;
        
        int m = (bytes.length / L);
        
        if (bytes.length % L != 0) {
            m += 1;
        }
        
        for (int b = 0; b < m; b++) {
            byte[] block = new byte[L];
            
            for (int l = 0; l < L; l++) {
                int i = b * L + l;
                
                if (i >= bytes.length) {
                    block[l] = 64;
                    continue;
                }
                
                block[l] = bytes[i];
            }
            
            for (byte by : block) {
                System.out.printf("%c", by);
            }
            System.out.println();
            
            byte[] t_block = Encrypt.transform(block, k);
            
            for (byte by : t_block) {
                System.out.printf("%c", by);
            }
            System.out.println();
            
            byte[] o_block = Encrypt.transform(t_block, L - k);
            
            for (byte by : o_block) {
                System.out.printf("%c", by);
            }
            System.out.println();
        }
    }
    
}
