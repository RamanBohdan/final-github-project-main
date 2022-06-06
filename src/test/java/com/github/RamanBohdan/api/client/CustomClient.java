package com.github.RamanBohdan.api.client;

import com.github.RamanBohdan.api.tests.AbstractTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomClient extends AbstractTest {
    private static final Logger logger = LogManager.getLogger();

    HttpResponse response;
    int statusCode;
    CloseableHttpClient httpClient;
    private String body;

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
        logger.info("statusCode: "+ statusCode);
        return statusCode;
    }

    public String getBody() {
        try {
            body = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return body;
    }

    public  List<String> getListBodyValuesByKey(String sizeKey) {
        JSONArray jsonArray = new JSONArray(body);
        List<String > bodyList = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            bodyList.add((String) ((JSONObject) jsonObject).get(sizeKey));
        }
        logger.info(bodyList);
        return bodyList;
    }

    public void closeHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
}

