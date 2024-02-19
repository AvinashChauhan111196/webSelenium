package runner;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 

@RunWith(Cucumber.class)
@CucumberOptions(features="WorkShop\\src\\test\\java\\feature\\Test2.feature",
glue={"stepdefinition"},
monochrome=true,
plugin={"pretty"}
)
public class Runner {

 

}