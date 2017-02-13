package miaplicacion;

public class MiAplicacion {

    public static void main(String[] args) {
        
        Calculadora calc = new Calculadora();
        
        double r1 = calc.suma(4, 5);
        double r2 = calc.resta(6, 3);
        double r3 = calc.multiplicacion(4, 5);
        double r4 = calc.division(8, 3);
        
        System.out.printf("%.2f %.2f %.2f %.2f", r1, r2, r3, r4);
        
    }
    
}
