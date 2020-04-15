package dtu.planning.domain;

public class RegularActivityRegister implements RegularActivityBehavior {
    @Override
    public void register(UserInfo userInfo, TypeRegularActivity type, Date date) {
        for (Integer week : date.getWeeks()) {
            userInfo.regularActivityByWeekNumber.put(week, type);
        }
    }
}
