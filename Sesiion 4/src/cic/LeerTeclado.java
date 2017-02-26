package cic;

import java.util.Scanner;

public class LeerTeclado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Dame tu edad: ");
        
        int edad = sc.nextInt();
        
        System.out.printf("Tienes %d años\n", edad);
    }
}
