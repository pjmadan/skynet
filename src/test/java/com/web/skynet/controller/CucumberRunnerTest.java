package com.web.skynet.controller;

import com.controlcenter.skynet.controller.manager.Embedder;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Embedder.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        tags = {"~@Ignore"},
        dryRun = false,
        glue = { "com.web.skynet.teststeps" },
        features = "src/test/resources/features/web-features/"
)
public class CucumberRunnerTest
{

}


