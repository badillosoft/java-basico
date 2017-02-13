package miaplicacion;

public class Robot {
    
    double x;
    double y;
    double a;
    
    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void imprimir() {
        System.out.printf("x: %.2f, y: %.2f, amgulo: %.2f%n", x, y, a);
    }
    
}
