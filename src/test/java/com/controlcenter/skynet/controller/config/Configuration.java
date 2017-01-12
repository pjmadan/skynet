package com.controlcenter.skynet.controller.config;

import java.io.File;

/**
 * Created by pmadan on 12/24/16.
 */
public class Configuration extends net.masterthought.cucumber.Configuration {

    private String facadeType;
    private String browsersToTest;
    private String apiEndPoint;
    private String reportOutputDirectory;
    private String projectName;
    private String platformName;

    public Configuration(File reportOutputDirectory, String projectName, String facadeType,
                         boolean runWithJenkins, String buildNumber,
                         String browsersToTest, String apiEndPoint) {
        super(reportOutputDirectory, projectName);
        this.facadeType=facadeType;
        this.setRunWithJenkins(runWithJenkins);
        this.setBuildNumber(buildNumber);
        this.browsersToTest=browsersToTest;
        this.apiEndPoint=apiEndPoint;
        this.setTagsToExcludeFromChart("@Ignore");
        //TODO make all this in config file
        this.platformName="android";
    }

    public String getFacadeType(){return this.facadeType;}
    public String getPlatformName(){return this.platformName;}
    public String getbrowsersToTest(){return this.browsersToTest;}
    public String getapiEndPoint(){return this.apiEndPoint;}
    public String getprojectname(){return super.getProjectName();}

}
