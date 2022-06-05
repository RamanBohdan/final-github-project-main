package com.github.RamanBohdan.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class APIGetTest extends AbstractTest{

    @Test
    public void testApiGetStatusCode() {
        String url = "https://github.com/RamanBohdan";
        httpClient.sendGet(url);

        assertEquals(httpClient.getStatusCode(), 200);
    }

    @Test
    public void testApiGetUserLocation() throws IOException {
        String url = "https://github.com/RamanBohdan/";
        String location = "Gomel";
        HttpUriRequest request = new HttpGet(url);

        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        Assert.assertTrue(responseBody.contains(location));
    }

    @Test
    public void testApiGetTestingBookingId() throws IOException {
        String url = "https://api.github.com/repos/RamanBohdan/final-github-project-main";
        String fullNameRepository = "RamanBohdan/final-github-project-main";
        HttpUriRequest request = new HttpGet(url);

        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        Assert.assertTrue(responseBody.contains(fullNameRepository));
    }
}
