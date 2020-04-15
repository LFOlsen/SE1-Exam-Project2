package dtu.planning.domain;

public class Developer extends User {

    public Developer(String uID) {
        super(uID);
        regularActivityBehavior = new RegularActivityRegister();

        System.out.println("Developer created with uID: " + this.userInfo.uID);
    }
}
