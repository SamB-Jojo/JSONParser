package com.autotrader.utilities.JSON;

import java.util.ArrayList;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSONArray {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    ArrayList<JSONElement> elements;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new JSONArray object.
     */
    public JSONArray() {
        elements = new ArrayList<JSONElement>();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public ArrayList<JSONElement> getArrayValue() {
        return elements;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param arrayElement in value
     */
    public void addArrayElement(JSONElement arrayElement) {
        this.elements.add(arrayElement);
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param key in value
     *
     * @return out value
     */
    public JSONValue findValue(String key) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isTypeObject()) {
                if (elements.get(i).getValue().jsonObjectValue.findValue(key) != null) {
                    return elements.get(i).getValue().jsonObjectValue.findValue(key);
                }
            }
        }
        return null;
    }
}
