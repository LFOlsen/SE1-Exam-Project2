package dtu.planning.domain;

public abstract class User {

    UserInfo userInfo;
    RegularActivityBehavior regularActivityBehavior;

    public User(String uID) {
        userInfo = new UserInfo(uID);
    }

    private boolean hasRegularActivitiesWithinPeriod(DateField period) {
        return userInfo.regularActivities.stream().anyMatch(r -> r.isWithin(period));
    }

    public boolean hasAnyActivitiesWithinPeriod(DateField period) {
        /**
         * Add check for project-activities within period when that bit is implemented
         */
        return hasRegularActivitiesWithinPeriod(period);
    }

    public boolean containsRegularActivity(RegularActivity regularActivity) {
        return userInfo.regularActivities.stream().anyMatch(r -> r.equals(regularActivity));
    }

    public boolean isUnAvailable(DateField period) {
        /**
         * Add check for > 20 project-activities as well when that bit is implemented
         */
        return hasRegularActivitiesWithinPeriod(period);
    }

    public void registerRegularActivity(RegularActivity regularActivity) throws OperationNotAllowedException {
        regularActivityBehavior.register(this, regularActivity);
    }
}
