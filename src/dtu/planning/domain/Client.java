package dtu.planning.domain;

public class Client extends User {

    public Client(String uID) {
        super(uID);
        regularActivityBehavior = new RegularActivityNoRegister();

        System.out.println("Client created with uID: " + this.userInfo.uID);
    }
}
