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
    public void testApiGetTestingStatusCode() {
        String url = "https://github.com/RamanBohdan";
        myClient.sendGet(url);

        assertEquals(myClient.getStatusCode(), 200);
    }

    @Test
    public void testApiGetTestingBookingId() throws IOException {
        String url = "https://github.com/RamanBohdan";
        String location = "Gomel";
        int value = 168;
        HttpUriRequest request = new HttpGet(url);

        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        Assert.assertTrue(responseBody.contains(location));
    }

}
