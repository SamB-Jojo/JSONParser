package com.autotrader.utilities.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSON {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private List<JSONArray> jsonArrays;
    private List<JSONObject> jsonObjects;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new JSON object.
     */
    public JSON() {
        jsonArrays = new ArrayList<JSONArray>();
        jsonObjects = new ArrayList<JSONObject>();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public List<JSONArray> getJsonArrays() {
        return jsonArrays;
    }

    public List<JSONObject> getJsonObjects() {
        return jsonObjects;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param jsonArray in value
     */
    public void addJsonArray(JSONArray jsonArray) {
        this.jsonArrays.add(jsonArray);
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param jsonObject in value
     */
    public void addJsonObject(JSONObject jsonObject) {
        this.jsonObjects.add(jsonObject);
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param key in value
     *
     * @return out value
     */
    public JSONValue findValue(String key) {
        JSONValue foundValue = null;
        for (int i = 0; i < jsonObjects.size(); i++) {
            if (jsonObjects.get(i).findValue(key) != null) {
                foundValue = jsonObjects.get(i).findValue(key);
            }
        }
        for (int k = 0; k < jsonArrays.size(); k++) {
            if (jsonArrays.get(k).findValue(key) != null) {
                foundValue = jsonArrays.get(k).findValue(key);
            }
        }
        return foundValue;
    }
}
