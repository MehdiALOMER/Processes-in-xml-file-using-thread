
package com.tutorialspoint.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class write extends Thread {
    String Dad;String ss;
        write(String Dad){
            this.Dad=Dad;
        }
     public void run(){
          Random rasgele = new Random();
       
       int sayi;
       int[] sayilar = new int[100000];
       for(int d =1;d<100000;d++){
    	   sayi = rasgele.nextInt(1000000);
    	   sayilar[d] = sayi;
       }
     
       ArrayList list = new ArrayList();
        
        for (int i = 0; i < 100000; i++) {
            list.add(sayilar[i]);
        }
     try {
           
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            // root element
            Element root = document.createElement("sayilar");
            document.appendChild(root);
 
            // employee element
            //Element employee = document.createElement("sayilar");
 
            //root.appendChild(employee);
            for (int i = 0; i < 100000; i++) {
                 
            Element firstName = document.createElement("sayi");
            firstName.appendChild(document.createTextNode(String.valueOf(list.get(i))));  
            root.appendChild(firstName);
            
            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(Dad));
 
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

   
    
}
