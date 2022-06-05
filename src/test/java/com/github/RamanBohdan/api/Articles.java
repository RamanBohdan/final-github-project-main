package com.github.RamanBohdan.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class Articles{
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testGetArticles() throws IOException {
        String token = "ghHtY5nUA2a%2BU1ZxvkJ7rBJDY5ZAr%2FkHaMEEE0EmAJTV0FpcP3l7c9sFN9Y4aUnDV2SLxFMOUqBoIz0a4FN7KJZ6tE5BpupV1hZe0zpAaJqNnjWvFd1FRzmXmMcloEsMiRm299fZbmEC7%2B%2Bcvwe3vOnJL5msuu0NO6nXpvwjKz1NTAbAa2R9thgO8Qs0jkMNycLQiWlZYTTygMARRC0He0YcyunItX8G5Hi9gG5udSIBFo5tle9vA0gIsnzUrRAkemClyoZpvnrSWeACmCCSRA%3D%3D--9HU%2FQavR3zOgGt0Q--VyxryidylkBxMd9jMdd7Gg%3D%3D-NKsVlj-JB9YrzeKozaDU1RjYYQCS-M-MDsO-DfbbHBL56o";

        HttpGet request = new HttpGet("https://github.com/RamanBohdan");
        //CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        CloseableHttpResponse response = HttpClientBuilder.create().setDefaultHeaders(Arrays.asList(new BasicHeader("Authorization", token))).build().execute(request);
        String body = response.toString();
        logger.info(body);
    }
}