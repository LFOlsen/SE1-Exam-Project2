package dtu.planning.domain;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {

    String uID;
    Map<Integer, Integer> numberOfProjectActivitiesByWeekNumber;
    Map<Integer, TypeRegularActivity> regularActivityByWeekNumber;

    public UserInfo(String uID) {
        this.uID = uID;
        this.numberOfProjectActivitiesByWeekNumber = new HashMap<>();
        this.regularActivityByWeekNumber = new HashMap<>();
    }
}
