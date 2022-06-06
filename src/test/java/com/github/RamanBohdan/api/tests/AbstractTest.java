package com.github.RamanBohdan.api.tests;

import com.github.RamanBohdan.api.client.CustomClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
    CustomClient httpClient;

    @BeforeClass
    public void getClient() {
        httpClient = new CustomClient();
    }

    @AfterClass
    public void tearDownClient() {
        httpClient.closeHttpClient();
    }
}
