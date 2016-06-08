package com.autotrader.utilities.JSON;

import java.io.*;

import java.net.URL;

import java.nio.charset.Charset;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSONParser {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Log logger = LogFactory.getLog(JSONParser.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    String jsonData;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new JSONParser object.
     */
    public JSONParser() {
        jsonData = null;
    }

    /**
     * Creates a new JSONParser object.
     *
     * @param data in value
     */
    public JSONParser(String data) {
        jsonData = data;
    }

    /**
     * Creates a new JSONParser object.
     *
     * @param fileName in value
     */
    public JSONParser(File fileName) {
        try {
            Scanner input = new Scanner(fileName);
            jsonData = "";
            while (input.hasNext()) {
                jsonData += input.next();
            }
        } catch (FileNotFoundException e) {
            logger.error("Unable to find file: " + fileName.getPath() + " JSON not parsed");
        }
    }

    /**
     * Creates a new JSONParser object.
     *
     * @param url in value
     */
    public JSONParser(URL url) {
        jsonData = "";
        InputStream is = null;
        try {
            is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line;
            while ((line = rd.readLine()) != null) {
                jsonData += line;
            }
            is.close();
        } catch (Exception e) {
            logger.error("Unable to find get data from url: " + url.getPath() + " JSON not parsed");
        }
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * TODO: Enter Javadoc
     *
     * @return out value
     */
    public JSON parse() {
        JSON myJSON = new JSON();
        while (!jsonData.isEmpty()) {
            switch (jsonData.charAt(0)) {
                case '{':
                    JSONObject myObject = new JSONObject();
                    myObject.addMyJSONMember(buildJSONMembers());
                    while (!jsonData.isEmpty() && jsonData.charAt(0) == ',') {
                        // Remove Comma From next Key
                        jsonData = jsonData.substring(1);
                        myObject.addMyJSONMember(buildJSONMembers());
                    }

                    // Remove Object Closing Bracket
                    if (!jsonData.isEmpty() && jsonData.charAt(0) == '}') {
                        jsonData = jsonData.substring(1);
                    }
                    myJSON.addJsonObject(myObject);
                    break;

                case '[':
                    JSONArray myJSONArray = new JSONArray();
                    myJSONArray.addArrayElement(buildJSONELement());
                    while (!jsonData.isEmpty() && jsonData.charAt(0) == ',') {
                        // Remove Comma From next Element
                        jsonData = jsonData.substring(1);
                        myJSONArray.addArrayElement(buildJSONELement());
                    }

                    // Remove Array Closing Bracket
                    if (!jsonData.isEmpty() && jsonData.charAt(0) == ']') {
                        jsonData = jsonData.substring(1);
                    }
                    myJSON.addJsonArray(myJSONArray);
                    break;

                default:
                    logger.error("Unable to get JSON from data");
                    return null;
            }
        }
        return myJSON;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @return out value
     */
    private JSONElement buildJSONELement() {
        JSONElement myElement = new JSONElement();

        // Remove Array Bracket
        if (!jsonData.isEmpty() && jsonData.charAt(0) == '[') {
            jsonData = jsonData.substring(1);
        }
        myElement.setValue(buildValue());
        return myElement;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @return out value
     */
    private JSONMember buildJSONMembers() {
        JSONMember member = new JSONMember();
        int colonIndex = jsonData.indexOf(":");
        String key = jsonData.substring(0, colonIndex).replace("{", "");
        jsonData = jsonData.substring(colonIndex + 1);
        JSONValue value = buildValue();
        member.addPairs(key, value);
        return member;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @return out value
     */
    private JSONValue buildValue() {
        JSONValue myValue = new JSONValue();
        switch (jsonData.charAt(0)) {
            case '{':
                JSONObject myObject = new JSONObject();
                myObject.addMyJSONMember(buildJSONMembers());
                while (!jsonData.isEmpty() && jsonData.charAt(0) == ',') {
                    // Remove Comma From next Key
                    jsonData = jsonData.substring(1);
                    myObject.addMyJSONMember(buildJSONMembers());
                }

                // Remove Object Closing Bracket
                if (!jsonData.isEmpty() && jsonData.charAt(0) == '}') {
                    jsonData = jsonData.substring(1);
                }
                myValue.setJsonObjectValue(myObject);
                break;

            case '[':
                JSONArray myJSONArray = new JSONArray();
                myJSONArray.addArrayElement(buildJSONELement());
                while (!jsonData.isEmpty() && jsonData.charAt(0) == ',') {
                    // Remove Comma From next Element
                    jsonData = jsonData.substring(1);
                    myJSONArray.addArrayElement(buildJSONELement());
                }

                // Remove Array Closing Bracket
                if (!jsonData.isEmpty() && jsonData.charAt(0) == ']') {
                    jsonData = jsonData.substring(1);
                }
                myValue.setJsonArrayValue(myJSONArray);
                break;

            default:
                if (!jsonData.isEmpty() && jsonData.contains("\",")) {
                    myValue.setValue(jsonData.substring(0, jsonData.indexOf("\",")));
                    jsonData = jsonData.substring(jsonData.indexOf("\",") + 1);
                    break;
                } else if (!jsonData.isEmpty() && jsonData.contains("]},")) {
                    myValue.setValue(jsonData.substring(0, jsonData.indexOf("]},")));
                    jsonData = jsonData.substring(jsonData.indexOf("]},"));
                    break;
                } else {
                    myValue.setValue(jsonData.replaceAll("}", ""));
                    jsonData = "";
                }
        }
        return myValue;
    }
}
