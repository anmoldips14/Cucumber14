package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Dell\\IdeaProjects\\CucumberPageObject\\src\\test\\resources\\Features\\Feature.feature",
glue = "StepDef",
        //dryRun = true;
    plugin={"pretty",
            "html:target/report.html/",
            "json:target/json/file.json"},
            publish=true,
    dryRun=false

)
public class Runner {
}
