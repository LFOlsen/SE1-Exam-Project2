package dtu.planning.domain;

public class RegularActivityRegister implements RegularActivityBehavior {
    @Override
    public void register(User user, RegularActivity regularActivity) throws OperationNotAllowedException {

        if (!user.hasAnyActivitiesWithinPeriod(regularActivity.getPeriod()) | (regularActivity.isCritical())){
            user.userInfo.regularActivities.add(regularActivity);
        }
        else
            throw new OperationNotAllowedException("Regular activity cannot be registered due to other activities occurring in that period");
    }
}
