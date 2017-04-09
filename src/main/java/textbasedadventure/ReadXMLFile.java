package textbasedadventure;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

import java.io.File;

/**
 * Created by Aenaos on 1/4/2017.
 */
public class ReadXMLFile {

    public void translate() {
        try {

            File fXmlFile = new File("Config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("----------------------------");
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            System.out.println("----------------------------");

            NodeList nList = doc.getDocumentElement().getChildNodes();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("\nname : " + eElement.getAttribute("name"));
                    System.out.println("tag : " + eElement.getTagName());
                    //System.out.println("value : " + eElement.getNodeValue());

                    NodeList roomsList = eElement.getElementsByTagName("adjacentRoom");

                    for (int roomsIndex = 0; roomsIndex < roomsList.getLength(); roomsIndex++) {

                        Node roomNode = roomsList.item(roomsIndex);
                        if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element roomElement = (Element) roomNode;
                            System.out.println("\nchild name : " + roomElement.getAttribute("name"));
                            System.out.println("child tag : " + roomElement.getTagName());
                            System.out.println("child value : " + roomElement.getFirstChild().getTextContent());
                        }
                    }
                }

            }
            System.out.println("");
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
    }
}
