package com.github.RamanBohdan.api;

import org.testng.annotations.BeforeClass;

public class AbstractTest {
    CustomClient httpClient;

    @BeforeClass
    public void getClient() {
        httpClient = new CustomClient();
    }
}
