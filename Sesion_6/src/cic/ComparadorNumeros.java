package cic;

import java.util.Comparator;

public class ComparadorNumeros implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
    
   
    
}
