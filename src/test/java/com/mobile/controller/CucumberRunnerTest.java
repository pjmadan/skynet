package com.mobile.controller;

/**
 * Created by prajitmadan on 1/7/17.
 */

import com.controlcenter.manager.Embedder;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Embedder.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        tags = {"~@Ignore"},
        dryRun = false,
        glue = {"com.mobile.skynet.teststeps"},
        features = "src/test/resources/features/mobile-features/mobile-ios-features"
)
public class CucumberRunnerTest {

}


