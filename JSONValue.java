package com.autotrader.utilities.JSON;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSONValue {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    JSONArray jsonArrayValue;
    JSONObject jsonObjectValue;

    String value;

    //~ Methods --------------------------------------------------------------------------------------------------------

    public JSONArray getJsonArrayValue() {
        return jsonArrayValue;
    }

    public void setJsonArrayValue(JSONArray jsonArray) {
        this.jsonArrayValue = jsonArray;
    }

    public JSONObject getJsonObjectValue() {
        return jsonObjectValue;
    }

    public void setJsonObjectValue(JSONObject jsonObjectValue) {
        this.jsonObjectValue = jsonObjectValue;
    }

    public String getOtherValue() {
        return value;
    }

    public boolean isTypeObject() {
        return jsonObjectValue != null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isTypeArray() {
        return jsonArrayValue != null;
    }
}
