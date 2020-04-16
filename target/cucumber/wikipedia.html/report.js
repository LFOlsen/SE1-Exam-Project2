$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/add_project.feature");
formatter.feature({
  "name": "Create project",
  "description": "  Description: Client creates a new internal or external project\n  Actors: Client",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create internal project as a client",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the client is registered with the planningTool",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.planning.acceptance_tests.steps.ListSteps.theClientIsRegisteredWithThePlanningTool()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\n\tat dtu.planning.acceptance_tests.steps.ListSteps.theClientIsRegisteredWithThePlanningTool(ListSteps.java:18)\n\tat ✽.the client is registered with the planningTool(file:///home/chrjlmn/IdeaProjects/SE1-02161-Exam/use_cases/add_project.feature:6)\n",
  "status": "pending"
});
formatter.step({
  "name": "the client requests to create an internal project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.planning.acceptance_tests.steps.ListSteps.theClientRequestsToCreateAnInternalProject()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the client provides the project with name \"p1\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.planning.acceptance_tests.steps.ListSteps.theClientProvidesTheProjectWithName(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the planningTool creates an empty project",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.planning.acceptance_tests.steps.ListSteps.thePlanningToolCreatesAnEmptyProject()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project is named \"p1\", has a project number and is internal",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.planning.acceptance_tests.steps.ListSteps.theProjectIsNamedHasAProjectNumberAndIsInternal(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
});