package textbasedadventure.webapp.game.parsing;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONParser {

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
