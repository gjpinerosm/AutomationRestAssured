package options;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
/**@CucumberOptions(
		plugin = {"pretty"},
		glue = {"stepdefs"},
		features = {"src/test/features"}) **/
@ExtendedCucumberOptions(jsonReport = "json:Folder_Name/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        //coverageReport = true,
        jsonUsageReport = "json:Folder_Name/cucumber.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target")
@CucumberOptions(
		plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
        //plugin = {"pretty", "html:Folder_Name"},
		//plugin =  {"pretty","json:Folder_Name/cucumber.json"},
		glue = {"stepdefs"},
		features = {"src/test/features"})

public class CucumberTests {}
