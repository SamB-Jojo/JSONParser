package com.autotrader.utilities.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jsbeal on 5/25/2016.
 */

public class JSONMember {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Map<String, JSONValue> pairs;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new JSONMember object.
     */
    public JSONMember() {
        pairs = new HashMap<String, JSONValue>();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public Map<String, JSONValue> getPairs() {
        return pairs;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param key in value
     * @param value in value
     */
    public void addPairs(String key, JSONValue value) {
        this.pairs.put(key, value);
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param key in value
     *
     * @return out value
     */
    public JSONValue findValue(String key) {
        return pairs.get(key);
    }
}
