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
public class Gato {

    char[] casillas;

    public Gato() {
        this.casillas = new char[9];

        for (int i = 0; i < this.casillas.length; i++) {
            this.casillas[i] = '-';
        }
    }

    String Tablero(int fila) {
        char a = this.casillas[0 + 3 * fila];
        char b = this.casillas[1 + 3 * fila];
        char c = this.casillas[2 + 3 * fila];
        
        return String.format(" %c | %c | %c ", a, b, c);
    }
    
    String Tablero() {
        return String.format(" %c | %c | %c\n - + - + -\n %c | %c | %c\n - + - + -\n %c | %c | %c\n",
                this.casillas[0], this.casillas[1], this.casillas[2],
                this.casillas[3], this.casillas[4], this.casillas[5],
                this.casillas[6], this.casillas[7], this.casillas[8]
        );
    }

    boolean setCasilla(int pos, char c) {
        if (c != 'x' && c != 'o') {
            return false;
        }
        // la c es 'x' o 'o'
        if (pos < 0 || pos >= this.casillas.length) {
            return false;
        }
        // pos es válida
        if (this.casillas[pos] != '-') {
            return false;
        }
        // la casilla está libre

        this.casillas[pos] = c;

        return true;
    }

}
