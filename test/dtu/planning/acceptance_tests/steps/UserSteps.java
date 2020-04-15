package dtu.planning.acceptance_tests.steps;

import dtu.planning.application.PlanningTool;
import dtu.planning.domain.Date;
import dtu.planning.domain.Developer;
import dtu.planning.domain.TypeRegularActivity;
import dtu.planning.domain.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserSteps {
    private PlanningTool planningTool;
    private User user;

    public UserSteps(PlanningTool planningTool) {
        this.planningTool = planningTool;
    }

    @Given("a developer is registered with the planningTool")
    public void aDeveloperIsRegisteredWithThePlanningTool() {
        user = new Developer("test");
    }

    @Given("the developer has no activities from week {int} to {int}")
    public void theDeveloperHasNoActivitiesFromWeekTo(int fromWeek, int toWeek) {
        assertFalse(user.hasAnyActivitiesInPeriod(new Date(fromWeek, toWeek)));
    }

    @When("the developer registers vacation from week {int} to {int}")
    public void theDeveloperRegistersVacationFromWeekTo(int fromWeek, int toWeek) {
        user.registerRegularActivity(TypeRegularActivity.VACATION, new Date(fromWeek, toWeek));
    }

    @Then("vacation is registered in the planningTool from week {int} to {int}")
    public void vacationIsRegisteredInThePlanningToolFromWeekTo(int fromWeek, int toWeek) {
        assertTrue(user.hasRegularActivityTypeInPeriod(TypeRegularActivity.VACATION, new Date(fromWeek, toWeek)));
    }

    @Then("the developer is unavailable from week {int} to {int}")
    public void theDeveloperIsUnavailableFromWeekTo(int fromWeek, int toWeek) {
        assertTrue(user.isUnAvailable(new Date(fromWeek, toWeek)));
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
