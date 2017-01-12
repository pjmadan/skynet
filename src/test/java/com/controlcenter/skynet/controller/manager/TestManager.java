package com.controlcenter.skynet.controller.manager;

import com.controlcenter.skynet.controller.config.Configuration;
import com.web.skynet.picocontainers.DriverContainer;

import java.io.*;
import java.util.Properties;

/**
 * Created by pmadan on 12/24/16.
 */
public class TestManager {

    private static Configuration configuration;

    public TestManager() {


    }

    public void configure() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            Boolean runOnJenkins;
            String browsersToTest;
            String apiEndPoint;
            String facadeType;
            String reportOutputDirectory;
            String projectName;
            String buildNumber;
            input = new FileInputStream("src/test/resources/configuration.properties");
            props.load(input);
            runOnJenkins = Boolean.getBoolean(props.getProperty("runOnJenkins"));
            browsersToTest = props.getProperty("browsersToTest");
            apiEndPoint = props.getProperty("apiEndPoint");
            facadeType = props.getProperty("facadeType");
            reportOutputDirectory = props.getProperty("reportOutputDirectory");
            projectName = props.getProperty("projectName");
            buildNumber = props.getProperty("buildNumber");
            apiEndPoint = props.getProperty("apiEndPoint");
            File reportOutput = new File(reportOutputDirectory);
            configuration = new Configuration(reportOutput, projectName, facadeType,
                    runOnJenkins, buildNumber, browsersToTest,
                    apiEndPoint);
            this.configuration = configuration;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public void initialize(String platform) {
        if (platform.equalsIgnoreCase("mobile-local")) {

        }
        if (platform.equalsIgnoreCase("web-local")) {
            DriverContainer driverContainer = new DriverContainer();
        }
    }

}
