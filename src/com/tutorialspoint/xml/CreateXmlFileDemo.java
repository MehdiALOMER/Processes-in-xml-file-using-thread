
package com.tutorialspoint.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.xml.transform.TransformerException;
      

public class CreateXmlFileDemo implements Serializable{

   public static void main(String[] args) throws TransformerException  {
            try{   
           /* Runnable counters1[] = {new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k1.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k2.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k3.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k4.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k5.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k6.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k7.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k8.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k9.xml"),
                                    new write("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k10.xml")};
              ExecutorService executor1 = Executors.newFixedThreadPool(10);
        
        for (Runnable counter1 : counters1){
         executor1.execute(counter1);
        }
      executor1.shutdown();*/
           
           ArrayList<sayilar> list = new ArrayList<sayilar>();
                for (int i = 1; i < 11; i++) {
                    
           read r1 = new read("C:\\Users\\abdullah\\Documents\\XmlDene\\dosyalar\\k"+i+".xml",list);
           r1.run();
       
                }
    
             ArrayList<sayilar> list1 = new ArrayList<sayilar>();
            System.out.println("kkkk");
             
              for (int i = 0; i <list.size() ; i++) {
                  // System.out.println(list.get(i).getSayi()+"            "+list.get(i).getTekrarSayi());
              
           int deger=list.get(i).getSayi();    
         sayilar a =null;
         a=list1.stream().filter(x->x.getSayi()==deger).findAny().orElse(null);
          if (a!=null) {
             int b= list1.indexOf(a);
             list1.get(b).setTekrarSayi(list1.get(b).getTekrarSayi()+1);
          }
          else{
              a=new sayilar();
              a.setSayi(deger);
             list1.add(a);
          }
 
      
               }
           
      
         System.out.println("kkkk");
               for (int i = 0; i <list.size() ; i++) {
                   System.out.println(list.get(i).getSayi()+"            "+list.get(i).getTekrarSayi());
               }
               
            Collections.sort(list, new Sortbyrol());
             
               for (int i = 0; i <list.size(); i++) {
                   System.out.println(list.get(i).getSayi());
               }
               System.out.println("TekrarSayisi");
               Collections.sort(list, new Sortbyrol1());
             
               for (int i = 0; i <list.size(); i++) {
                   System.out.println(list.get(i).getTekrarSayi());   
               }
            InsertionSort ins = new InsertionSort();
            ins.sort(list);
            
            Sonuc sonuc=new Sonuc(list);
              
        }catch(Exception e){ System.out.println(e);  }
     
   }
   } 
