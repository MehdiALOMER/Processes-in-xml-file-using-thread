
package com.tutorialspoint.xml;

import java.util.ArrayList;

public class SelectionSort{
    
    
    public void sort(ArrayList<sayilar> list){ 
        int n = list.size(); 
        
        for (int i = 0; i < n-1; i++) {           
            int min_idx = i; 
            
            for (int j = i+1; j < n; j++)
                
              //if (arr[j] < arr[min_idx])
                if(list.get(j).getSayi() < list.get(min_idx).getSayi())
                    min_idx = j; 
  
            //int temp = arr[min_idx];
            int temp = list.get(min_idx).getSayi();
            //arr[min_idx] = arr[i]; 
            list.get(min_idx).setSayi(list.get(i).getSayi());
            //arr[i] = temp;
            list.get(i).setSayi(temp);
        } 
         PrintList(list);
    } 
    
       public void PrintList(ArrayList<sayilar> list){
       System.out.println("----------------------Selection Sort----------------------");
       for (int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i).getSayi());
       }
   }
}