
package com.tutorialspoint.xml;

import java.io.File;
import java.util.ArrayList;
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

public class Sonuc  {
           ArrayList<sayilar> list = new ArrayList();
           
    Sonuc(ArrayList<sayilar> list){
         
        try{
            sayilar list1 = new sayilar();
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            
            Element root = document.createElement("sayilar");
            document.appendChild(root);
 
         
            for (int i = 0; i < list.size(); i++) {
                
            /*Element firstName = document.createElement("sayi");
            firstName.appendChild(document.createTextNode(String.valueOf(list.get(i))));  
            root.appendChild(firstName);*/
            
             Element carname = document.createElement("sayi");
             Attr attrType = document.createAttribute("TekrarSayisi");
             attrType.setValue(String.valueOf(list.get(i).getTekrarSayi()));
             carname.setAttributeNode(attrType);
             carname.appendChild(document.createTextNode(String.valueOf(list.get(i).getSayi())));
             root.appendChild(carname);
            }
           
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("sayilar.xml"));
 
         
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
             } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
