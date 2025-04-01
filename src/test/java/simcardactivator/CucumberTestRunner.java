// File: src/test/java/simcardactivator/CucumberTestRunner.java
package simcardactivator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTestRunner {
    // This class is empty, it's just used as a runner
}