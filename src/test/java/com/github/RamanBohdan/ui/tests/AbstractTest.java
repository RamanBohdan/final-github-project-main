package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.driverSingleton.DriverSingleton;
import org.testng.annotations.AfterClass;

public class AbstractTest {

    @AfterClass()
    public static void tearDown() {
        DriverSingleton.closeDriver();
    }
}
