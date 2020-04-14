package dtu.planning.acceptance_tests.steps;

import dtu.planning.application.PlanningTool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {
    private PlanningTool planningTool;

    public UserSteps(PlanningTool planningTool) {
        this.planningTool = planningTool;
    }

    @Given("the client is registered with the planningTool")
    public void theClientIsRegisteredWithThePlanningTool() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the client requests to create an internal project")
    public void theClientRequestsToCreateAnInternalProject() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("the client provides the project with name {string}")
    public void theClientProvidesTheProjectWithName(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the planningTool creates an empty project")
    public void thePlanningToolCreatesAnEmptyProject() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("the project is named {string}, has a project number and is internal")
    public void theProjectIsNamedHasAProjectNumberAndIsInternal(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
