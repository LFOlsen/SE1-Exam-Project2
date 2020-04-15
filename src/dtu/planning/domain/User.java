package dtu.planning.domain;

public abstract class User {

    UserInfo userInfo;
    RegularActivityBehavior regularActivityBehavior;
    private static final int MAX_WEEKLY_PROJECT_ACTIVITIES = 20;


    public User(String uID) {
        userInfo = new UserInfo(uID);
    }

    private boolean hasProjectActivitiesInWeek(int week) {
        return userInfo.numberOfProjectActivitiesByWeekNumber.containsKey(week);
    }

    private boolean hasMaxProjectActivitiesInWeek(int week) {
        if (userInfo.numberOfProjectActivitiesByWeekNumber.containsKey(week)) {
            return (userInfo.numberOfProjectActivitiesByWeekNumber.get(week) > MAX_WEEKLY_PROJECT_ACTIVITIES);
        }
        return false;
    }

    private boolean hasRegularActivityInWeek(int week) {
        return userInfo.regularActivityByWeekNumber.containsKey(week);
    }

    private boolean hasRegularActivityTypeInWeek(TypeRegularActivity type, int week) {
        return (userInfo.regularActivityByWeekNumber.get(week) == type);
    }

    public boolean hasAnyActivitiesInPeriod(Date date) {
        for (Integer week : date.getWeeks()) {
            if (hasProjectActivitiesInWeek(week) || hasRegularActivityInWeek(week)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRegularActivityTypeInPeriod(TypeRegularActivity type, Date date) {
        for (Integer week : date.getWeeks()) {
            if (!hasRegularActivityTypeInWeek(type, week)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnAvailable(Date date) {
        for (Integer week : date.getWeeks()) {
            if (!(hasRegularActivityInWeek(week) | hasMaxProjectActivitiesInWeek(week))) {
                return false;
            }
        }
        return true;
    }

    public void registerRegularActivity(TypeRegularActivity type, Date date) {
        regularActivityBehavior.register(userInfo, type, date);
    }

}
