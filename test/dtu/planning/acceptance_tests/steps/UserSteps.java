package dtu.planning.acceptance_tests.steps;

import dtu.planning.acceptance_tests.helper.*;
import dtu.planning.application.PlanningTool;
import dtu.planning.domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserSteps {
    private PlanningTool planningTool;
    private User user;
    private ErrorMessageHolder errorMessageHolder;

    public UserSteps(PlanningTool planningTool, ErrorMessageHolder errorMessageHolder) {
        this.planningTool = planningTool;
        this.errorMessageHolder = errorMessageHolder;
    }

    @Given("the registered user is a developer")
    public void theRegisteredUserIsADeveloper() {
        user = new Developer("test");
    }

    @Given("the registered user is a client")
    public void theRegisteredUserIsAClient() {
        user = new Client("test");
    }

    @Given("the user has no activities from {string} to {string}")
    public void theUserHasNoActivitiesFromTo(String dateStart, String dateEnd) {
        DateField period = new DateField(dateStart, dateEnd);
        assertFalse(user.hasAnyActivitiesWithinPeriod(period));
    }

    @When("the user registers vacation from {string} to {string}")
    public void theUserRegistersVacationFromTo(String dateStart, String dateEnd) {
        try {
            user.registerRegularActivity(new RegularActivity(TypeRegularActivity.VACATION, new DateField(dateStart, dateEnd)));
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("vacation is registered in the planningTool from {string} to {string}")
    public void vacationIsRegisteredInThePlanningToolFromTo(String dateStart, String dateEnd) {
        RegularActivity r = new RegularActivity(TypeRegularActivity.VACATION, new DateField(dateStart, dateEnd));
        assertTrue(user.containsRegularActivity(r));
    }

    @Then("the user is unavailable from {string} to {string}")
    public void theUserIsUnavailableFromTo(String dateStart, String dateEnd) {
        assertTrue(user.isUnAvailable(new DateField(dateStart, dateEnd)));
    }


    @Given("the user has one activity from {string} to {string}")
    public void theUserHasOneActivityFromTo(String dateStart, String dateEnd) throws OperationNotAllowedException {
        /**
         * Change this so the developer has one PROJECT-activity, not a regular activity...
         */
        RegularActivity activity = new RegularActivity(TypeRegularActivity.VACATION, new DateField(dateStart, dateEnd));
        user.registerRegularActivity(activity);
        assertTrue(user.containsRegularActivity(activity));
    }

    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String errorMessage) {
        assertEquals(errorMessage, this.errorMessageHolder.getErrorMessage());
    }

    @When("the user registers sickness from {string} to {string}")
    public void theUserRegistersSicknessFromTo(String dateStart, String dateEnd) throws OperationNotAllowedException {
        RegularActivity activity = new RegularActivity(TypeRegularActivity.SICKNESS, new DateField(dateStart, dateEnd));
        user.registerRegularActivity(activity);
        assertTrue(user.containsRegularActivity(activity));
    }

    @Then("sickness is registered in the planningTool from {string} to {string}")
    public void sicknessIsRegisteredInThePlanningToolFromTo(String dateStart, String dateEnd) {
        /**
         * Can we use enums in cucumber?
         */
        RegularActivity r = new RegularActivity(TypeRegularActivity.SICKNESS, new DateField(dateStart, dateEnd));
        assertTrue(user.containsRegularActivity(r));
    }
}
