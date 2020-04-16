package dtu.planning.domain;

public interface RegularActivityBehavior {
    void register(User user, RegularActivity regularActivity) throws OperationNotAllowedException;
}
