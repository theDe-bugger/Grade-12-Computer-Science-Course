/**
 * This is a program which creates an xml file, edits it, and prints out its contents using JDOM.
 * 
 * date         20201029
 * @filename	XMLCreate.java
 * @author      jdalwadi
 * @version     1.0
 * @see         assignment 3.5.2 and 3.5.3
 */

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;

public class XMLCreate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // code for writing xml file through Java
        try {
        OutputStream fout= new FileOutputStream("./courses.xml");
        OutputStream bout= new BufferedOutputStream(fout);
        OutputStreamWriter out
         = new OutputStreamWriter(bout, "8859_1");

        out.write("<?xml version=\"1.0\" ");
        out.write("encoding=\"ISO-8859-1\"?>\r\n");
        out.write("<school>\r\n");
        
        out.write("<course>\r\n");
        out.write("<code>ICS4U</code>\r\n");
        out.write("<description> Computer Programming, Grade 12, University</description>\r\n");
        out.write("<teacher> Teacher A </teacher>\r\n");
        out.write("<fileType> Unmodified </fileType>\r\n");
        out.write("</course> \r\n");

        out.write("<course>\r\n");
        out.write("<code>MHF4U</code>\r\n");
        out.write("<description> Advanced Functions, Grade 12, University</description>\r\n");
        out.write("<teacher> Teacher A </teacher>\r\n");
        out.write("<fileType> Unmodified </fileType>\r\n");
        out.write("</course> \r\n");
        
        out.write("<course>\r\n");
        out.write("<code>ENG4U</code>\r\n");
        out.write("<description> English, Grade 12, University</description>\r\n");
        out.write("<teacher> Teacher A </teacher>\r\n");
        out.write("<fileType> Unmodified </fileType>\r\n");
        out.write("</course> \r\n");
        
        out.write("</school>\r\n");

        out.flush();  
        out.close();
      }
      catch (UnsupportedEncodingException e) {
        System.out.println(
         "This VM does not support the Latin-1 character set."
        );
      }
      catch (IOException e) {
        System.out.println(e.getMessage());
      }
        
      // code for modifications using JDOM
      try{
	 String filepath = "./courses.xml";
	 DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 Document doc = docBuilder.parse(filepath);

	 // Get the first code element
         Node Course = doc.getElementsByTagName("course").item(0);

	 // Append a new node: schoolBoard to first course
	 Element schoolBoard = doc.createElement("schoolBoard");
	 schoolBoard.appendChild(doc.createTextNode("Peel District School Board"));
         Course.appendChild(schoolBoard);

         // Get the second course element
         Course = doc.getElementsByTagName("course").item(1);
         // Append a new node: schoolBoard to second course
	 schoolBoard = doc.createElement("schoolBoard");
	 schoolBoard.appendChild(doc.createTextNode("Peel District School Board"));
         Course.appendChild(schoolBoard);
         
         // Get the third course element
         Course = doc.getElementsByTagName("course").item(2);
         // Append a new node: schoolBoard to third course
	 schoolBoard = doc.createElement("schoolBoard");
	 schoolBoard.appendChild(doc.createTextNode("Peel District School Board"));
         Course.appendChild(schoolBoard);
         

         // change the name of the first student
         Node a = doc.getElementsByTagName("teacher").item(0);
         a.setTextContent("Mr. So");
         
         // change the name of the second student
         a = doc.getElementsByTagName("teacher").item(1);
         a.setTextContent("Mr. Alves");
         
         // change the name of the third student
         a = doc.getElementsByTagName("teacher").item(2);
         a.setTextContent("Ms. Patel");


     //write the content into xml file
     TransformerFactory transformerFactory = TransformerFactory.newInstance();
     Transformer transformer = transformerFactory.newTransformer();
     DOMSource source = new DOMSource(doc);
     StreamResult result =  new StreamResult(new File(filepath));
     transformer.transform(source, result);

     System.out.println("Done");

   }catch(ParserConfigurationException pce){
	 pce.printStackTrace();
   }catch(TransformerException tfe){
	 tfe.printStackTrace();
   }catch(IOException ioe){
	 ioe.printStackTrace();
   }catch(SAXException sae){
	 sae.printStackTrace();
   }
    
      
    // code for reading and printing out xml file text using JDOM
    try{
	 String filepath = "./courses.xml";
	 DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 Document doc = docBuilder.parse(filepath);
         System.out.println("\nRoot element: " + doc.getDocumentElement().getNodeName());  
         
         // used https://www.javatpoint.com/how-to-read-xml-file-in-java for help
         NodeList nodeList = doc.getElementsByTagName("course");
         
         // goes through all the course elements in the file and prints information from each one
         for (int i = 0; i < nodeList.getLength();i++){
            Node Course = nodeList.item(i);
            System.out.println("\nNode Name: " + Course.getNodeName());
            System.out.println("Code: "+ doc.getElementsByTagName("code").item(i).getTextContent());  
            System.out.println("Description: "+ doc.getElementsByTagName("description").item(i).getTextContent());  
            System.out.println("Teacher: "+ doc.getElementsByTagName("teacher").item(i).getTextContent());  
            System.out.println("File type: "+ doc.getElementsByTagName("fileType").item(i).getTextContent());  
            System.out.println("School Board: "+ doc.getElementsByTagName("schoolBoard").item(i).getTextContent());  
         }
   }catch(ParserConfigurationException pce){
	 pce.printStackTrace();
   }catch(IOException ioe){
	 ioe.printStackTrace();
   }catch(SAXException sae){
	 sae.printStackTrace();
   }
  }  
}
