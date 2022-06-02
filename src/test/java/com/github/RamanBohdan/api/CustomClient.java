package com.github.RamanBohdan.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CustomClient {
    private static final Logger logger = LogManager.getLogger();

    HttpResponse response;
    int statusCode;
    CloseableHttpClient httpClient;

    public CustomClient() {
        httpClient = HttpClientBuilder.create().build();
    }

    public void sendGet(String URL) {
        try {
            response = httpClient.execute(new HttpGet(URL));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        logger.info(statusCode);
        return statusCode;
    }
}
