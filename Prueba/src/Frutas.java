/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aula E2
 */
public class Frutas {
    
    ArrayList<String> frutas;
    HashSet<String> diferentes;
    DefaultListModel<String> r_frutas;
    DefaulListModel<String> r_diferentes;
    
    void add(String fruta) {
        frutas.add(fruta);
        boolean a = diferentes.add(frutas);
        r_frutas.add(fruta);
        if (a) {
            r_diferentes(a);
        }    
    }
    
}
