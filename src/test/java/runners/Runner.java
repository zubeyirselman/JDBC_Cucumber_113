package runners;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utilities.JDBCReusableMethods;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources",
        glue = {"stepDefinitions"},
        tags = "@t113",
        dryRun =false
)
public class Runner {

}

/*
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/zubeyirselman/JDBC_Cucumber_113.git
git push -u origin main
 */