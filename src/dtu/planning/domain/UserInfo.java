package dtu.planning.domain;

import java.util.ArrayList;

public class UserInfo {

    String uID;
    ArrayList<RegularActivity> regularActivities;

    public UserInfo(String uID) {
        this.uID = uID;
        this.regularActivities = new ArrayList<>();
    }
}
