package com.autotrader.utilities.JSON;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSONElement {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private JSONValue value;

    //~ Methods --------------------------------------------------------------------------------------------------------

    public boolean isTypeObject() {
        return value.isTypeObject();
    }

    public JSONValue getValue() {
        return value;
    }

    public void setValue(JSONValue value) {
        this.value = value;
    }
}
