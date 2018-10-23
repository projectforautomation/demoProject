package com.skilrock.stepdefinitions.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(plugin={"pretty","json:target/cucumberreports.json"},
		features = "src/test/resources",
        glue = "com.skilrock.stepdefinitions",
        tags = {"@UI"}
        )

public class RunTest {

}
