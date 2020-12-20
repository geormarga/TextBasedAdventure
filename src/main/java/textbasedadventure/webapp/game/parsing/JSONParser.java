package textbasedadventure.webapp.game.parsing;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JSONParser {


    /**
     * Method that takes a NodeList and keeps only the nodes of type ELEMENT
     *
     * @param nodeList the NodeList given
     * @return Cleared out element list
     */
    public static List<Element> toElementList(NodeList nodeList) {
        List<Element> elementList = new ArrayList<>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
                elementList.add((Element) nodeList.item(index));
            }
        }
        return elementList;
    }

    /**
     * Method that parses the a json File to a json array
     *
     * @param pathName Json file path
     * @return JsonArray from json file
     */
    public static JSONArray toJsonArray(String pathName, String rootKey) {
        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        JSONArray jsonArray = null;
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(pathName));
            jsonArray = (JSONArray) jsonObject.get(rootKey);
        } catch (IOException | org.json.simple.parser.ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return jsonArray;
    }
}
