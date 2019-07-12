
package com.tutorialspoint.xml;

import java.util.Comparator;

public class Sortbyrol implements Comparator <sayilar> {
    
    
    public int compare(sayilar t1, sayilar t2) {
        return t1.getSayi() - t2.getSayi();
    }

}
