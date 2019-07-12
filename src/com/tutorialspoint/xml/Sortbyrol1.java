
package com.tutorialspoint.xml;

import java.util.Comparator;

public class Sortbyrol1 implements Comparator <sayilar> {

   
    public int compare(sayilar t1, sayilar t2) {
        return t2.getTekrarSayi() - t1.getTekrarSayi();
    }
    
}
