package dtu.planning.domain;

public abstract class User {

    UserInfo userInfo;
    RegularActivityBehavior regularActivityBehavior;
    private static final int MAX_WEEKLY_PROJECT_ACTIVITIES = 20;


    public User(String uID) {
        userInfo = new UserInfo(uID);
    }

    private boolean hasProjectActivitiesInWeek(int week) {
        return userInfo.numberOfProjectActivitiesByWeekNumber.getOrDefault(week, 0) > 0;
    }

    private boolean hasMaxProjectActivitiesInWeek(int week) {
        return userInfo.numberOfProjectActivitiesByWeekNumber.getOrDefault(week, 0) > MAX_WEEKLY_PROJECT_ACTIVITIES;
    }

    private boolean hasRegularActivityInWeek(int week) {
        return userInfo.regularActivityByWeekNumber.containsKey(week);
    }

    private boolean hasRegularActivityTypeInWeek(TypeRegularActivity type, int week) {
        return (userInfo.regularActivityByWeekNumber.get(week) == type);
    }

    public void addProjectActivity(Date date) {
        for (Integer week : date.getWeeks()) {
            int count = userInfo.numberOfProjectActivitiesByWeekNumber.getOrDefault(week, 0);
            userInfo.numberOfProjectActivitiesByWeekNumber.put(week, count + 1);
        }
    }

    private boolean hasProjectActivitiesInPeriod(Date date) {
        for (Integer week : date.getWeeks()) {
            if (hasProjectActivitiesInWeek(week)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRegularActivitiesInPeriod(Date date) {
        for (Integer week : date.getWeeks()) {
            if (hasRegularActivityInWeek(week)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyActivitiesInPeriod(Date date) {
        return (hasProjectActivitiesInPeriod(date) || hasRegularActivitiesInPeriod(date));
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

    public void registerRegularActivity(TypeRegularActivity type, Date date) throws OperationNotAllowedException {
        if(!hasAnyActivitiesInPeriod(date))
            regularActivityBehavior.register(userInfo, type, date);
        else
            throw new OperationNotAllowedException("Vacation/seminar cannot be registered as you have project-activities in those weeks");
    }
}
