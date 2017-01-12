package com.web.skynet.teststeps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by pmadan on 12/20/16.
 */
public class Hooks {



    @Before("@web")
    public void runbefore() {
    }

    @After("@web")
    public void runafter() {
        System.out.println("Bye!!!");
    }

}