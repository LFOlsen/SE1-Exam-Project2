package dtu.planning.acceptance_tests.steps;

import dtu.planning.acceptance_tests.helper.*;
import dtu.planning.application.PlanningTool;
import dtu.planning.domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserSteps {
    private PlanningTool planningTool;
    private User user;
    private ErrorMessageHolder errorMessageHolder;

    public UserSteps(PlanningTool planningTool, ErrorMessageHolder errorMessageHolder) {
        this.planningTool = planningTool;
        this.errorMessageHolder = errorMessageHolder;
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
        try {
            user.registerRegularActivity(TypeRegularActivity.VACATION, new Date(fromWeek, toWeek));
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("vacation is registered in the planningTool from week {int} to {int}")
    public void vacationIsRegisteredInThePlanningToolFromWeekTo(int fromWeek, int toWeek) {
        assertTrue(user.hasRegularActivityTypeInPeriod(TypeRegularActivity.VACATION, new Date(fromWeek, toWeek)));
    }

    @Then("the developer is unavailable from week {int} to {int}")
    public void theDeveloperIsUnavailableFromWeekTo(int fromWeek, int toWeek) {
        assertTrue(user.isUnAvailable(new Date(fromWeek, toWeek)));
    }

    @Given("the developer has a project activity from week {int} to {int}")
    public void theDeveloperHasAProjectActivityFromWeekTo(int fromWeek, int toWeek) {
        user.addProjectActivity(new Date(fromWeek, toWeek));
    }

    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String errorMessage) {
        assertEquals(errorMessage, this.errorMessageHolder.getErrorMessage());
    }

}
