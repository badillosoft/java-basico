package miaplicacion;

public class Reloj {
    
    int minutos;
    
    int segundos;
    
    void incrementar() {
        segundos = segundos + 1;
        
        if (segundos == 60) {
            segundos = 0;
            minutos = minutos + 1;
        }
    }
    
    String imprimir() {
        String ss = "" + segundos;
        String mm = "" + minutos;
        
        if (segundos < 10) {
            ss = "0" + ss;
        }
        
        if (minutos < 10) {
            mm = "0" + mm;
        }
        
        return String.format(
            "%s:%s", mm, ss
        );
    }
    
}
