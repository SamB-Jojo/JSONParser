package com.autotrader.utilities.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsbeal on 5/25/2016.
 */
public class JSONObject {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private List<JSONMember> myJSONMembers;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new JSONObject object.
     */
    public JSONObject() {
        myJSONMembers = new ArrayList<JSONMember>();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public List<JSONMember> getMyJSONMembers() {
        return myJSONMembers;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param newMember in value
     */
    public void addMyJSONMember(JSONMember newMember) {
        this.myJSONMembers.add(newMember);
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
        for (int i = 0; i < myJSONMembers.size(); i++) {
            if (myJSONMembers.get(i).findValue(key) != null) {
                foundValue = myJSONMembers.get(i).findValue(key);
            }
        }
        return foundValue;
    }
}
