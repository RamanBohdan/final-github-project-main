package com.github.RamanBohdan.api;

import org.testng.annotations.BeforeClass;

public class AbstractTest {
    CustomClient myClient;

    @BeforeClass
    public void getClient() {
        myClient = new CustomClient();
    }
}
