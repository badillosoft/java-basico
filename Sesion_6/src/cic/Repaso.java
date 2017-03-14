package cic;

import java.util.*;

public class Repaso {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> numeros = new ArrayList();
        
        int n;
        
        System.out.print("¿Cuantos números? ");
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            System.out.printf("Dame el número %d: ", i);
            int x = sc.nextInt();
            numeros.add(x);
        }
        
        System.out.println(numeros);
    }
    
}
