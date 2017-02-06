package com.controlcenter.manager;
/**
 * Created by pmadan on 12/21/16.
 */

import com.controlcenter.annotations.AfterMobileSuite;
import com.controlcenter.annotations.AfterSuite;
import com.controlcenter.annotations.BeforeMobileSuite;
import com.controlcenter.annotations.BeforeSuite;
import com.mobile.teststeps.AppiumServerManager;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Embedder extends org.junit.runner.Runner {

    private Class<?> classValue;
    private Cucumber cucumber;
    private TestManager testManager;
    private AppiumServerManager manager;

    public Embedder(Class<?> classValue) throws Exception {
        this.classValue = classValue;
        cucumber = new Cucumber(classValue);
        testManager = new TestManager();
        testManager.configure();


    }

    @Override
    public Description getDescription() {
        return cucumber.getDescription();
    }

    private void runAnnotatedMethods(Class<?> annotation) throws Exception {
        if (!annotation.isAnnotation()) {
            return;
        }
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation item : annotations) {
                if (item.annotationType().equals(annotation)) {
                    method.invoke(this);
                    break;
                }
            }
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            if (this.testManager.getConfiguration().getFacadeType().equalsIgnoreCase("mobile-local")) {
                runAnnotatedMethods(BeforeMobileSuite.class);
            }
            if (this.testManager.getConfiguration().getFacadeType().equalsIgnoreCase("web-local")) {
                runAnnotatedMethods(BeforeSuite.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cucumber.run(notifier);
        try {
            if (this.testManager.getConfiguration().getFacadeType().equalsIgnoreCase("mobile-local")) {
                runAnnotatedMethods(AfterMobileSuite.class);
            }
            if (this.testManager.getConfiguration().getFacadeType().equalsIgnoreCase("web-local")) {
                runAnnotatedMethods(AfterSuite.class);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }


    }

    @BeforeSuite
    public void runbefore() {
        testManager.initialize("web-local");


    }


    @AfterSuite
    public void runafter() throws Exception {
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("/Users/prajitmadan/Documents/workspace/Skynet/target/cucumber.json");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, this.testManager.getConfiguration());
        Reportable result = reportBuilder.generateReports();
    }


    @BeforeMobileSuite
    public void runbeforemobile() {
        manager = new AppiumServerManager();
        manager.startserver();
        testManager.initialize("mobile-local");

    }


    @AfterMobileSuite
    public void runaftermobile() throws Exception {
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("/Users/prajitmadan/Documents/workspace/Skynet/target/cucumber.json");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, this.testManager.getConfiguration());
        Reportable result = reportBuilder.generateReports();
        manager.stopserver();

    }

}
