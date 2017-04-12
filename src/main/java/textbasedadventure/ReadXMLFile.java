package textbasedadventure;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


class ReadXMLFile {
    private File fXmlFile;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;

    /**
     * Method that maps the user given attributes to game contextual objects depending on the current room
     *
     * @param currentRoom The room currently at
     * @param attributes  The command attributes that have been parsed
     */
    void translate(String currentRoom, List<String> attributes) {
        try {
            fXmlFile = new File("Map.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            List<Element> elementList = new ArrayList<>();
            List<Element> parentList = toElementList(doc.getDocumentElement().getChildNodes());
            for (Element parent : parentList) {
                List<Element> childList = toElementList(parent.getChildNodes());
                elementList.addAll(childList);
            }

            for (Element element : elementList) {
                Element parent = (Element) element.getParentNode();
                if (parent.getAttribute("name").equals(currentRoom)) {
                    for (String attr : attributes) {
                        if (element.getAttribute("name").equals(attr)) {
                            attributes.set(attributes.indexOf(attr), element.getFirstChild().getTextContent());
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Element> toElementList(NodeList nodeList) {
        List<Element> elementList = new ArrayList<>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
                elementList.add((Element) nodeList.item(index));
            }
        }
        return elementList;
    }
}
