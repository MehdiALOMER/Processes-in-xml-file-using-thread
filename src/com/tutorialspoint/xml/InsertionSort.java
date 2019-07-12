
package com.tutorialspoint.xml;

import java.util.ArrayList;

public class InsertionSort{
   public void sort(ArrayList<sayilar> list){ 
        int n = list.size(); 
        for (int i = 1; i < n; ++i) { 
            int key = list.get(i).getSayi(); 
            int j = i - 1; 
  
            while (j >= 0 && list.get(j).getSayi() > key) { 
                //arr[j + 1] = arr[j]; 
                list.get(j+1).setSayi(list.get(j).getSayi());
                j = j - 1; 
            } 
            //arr[j + 1] = key; 
            list.get(j+1).setSayi(key);
        } 
        PrintList(list);
    } 
   public void PrintList(ArrayList<sayilar> list){
       System.out.println("----------------------Insertion Sort----------------------");
       for (int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i).getSayi());
       }
   }
}