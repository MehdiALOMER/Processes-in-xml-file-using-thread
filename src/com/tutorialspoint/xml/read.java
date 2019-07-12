
package com.tutorialspoint.xml;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

 public class read extends Thread implements Serializable{
    String Dad;
    String temp1;
  
         ArrayList<sayilar> list;
         
 
      read(String Dad,ArrayList<sayilar> list) {
         this.list=list;
         this.Dad=Dad; 
      }

    read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void run(){
      try {
        
         File inputFile = new File(Dad);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("sayi");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {  
            
            Node nNode = nList.item(temp);
            if(nNode.getNodeType()==Node.ELEMENT_NODE){
               Element eElement = (Element) nNode;
              //System.out.println(Integer.parseInt(eElement.getTextContent()));
              //yaz(Integer.parseInt(eElement.getTextContent())); 
              sayilar a= new sayilar();
              a.setSayi(Integer.parseInt(eElement.getTextContent()));
               list.add(a);
         }
        
         }
            
      
      } catch (Exception e) {
         e.printStackTrace();
      }
     
   }

     
   
}
