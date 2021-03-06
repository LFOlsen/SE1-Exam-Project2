package dtu.planning.acceptance_tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases",
        plugin = { "html:target/cucumber/wikipedia.html"},
        monochrome=true,
        snippets = SnippetType.CAMELCASE,
        glue = { "dtu.planning.acceptance_tests"},
        strict = true)
public class AcceptanceTest {

}