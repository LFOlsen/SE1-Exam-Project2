package dtu.planning.domain;

public class RegularActivityNoRegister implements RegularActivityBehavior {
    @Override
    public void register(User user, RegularActivity regularActivity) throws OperationNotAllowedException {
        throw new OperationNotAllowedException("A client cannot register a regular activity");
    }
}
