package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.driverSingleton.DriverSingleton;
import org.testng.annotations.AfterClass;

public class AbstractTest{

    public static final String REPOSITORY = "RamanBohdan/final-github-project-main";
    public static final String NAME_REPOSITORY = "example";

    @AfterClass()
    public static void tearDown() {
        DriverSingleton.closeDriver();
    }
}
