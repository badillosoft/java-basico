package miaplicacion;

public class Calculadora {
    
    double ans;
    
    double suma(double a, double b) {
        ans = a + b;
        return ans;
    }
    
    double resta(double a, double b) {
        ans = a - b;
        return ans;
    }
    
    double multiplicacion(double a, double b) {
        ans = a * b;
        return ans;
    }
    
    double division(double a, double b) {
        ans = a / b;
        return ans;
    }
    
}
