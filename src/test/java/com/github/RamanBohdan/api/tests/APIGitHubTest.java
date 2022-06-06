package com.github.RamanBohdan.api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class APIGitHubTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger();


    @Test
    public void testApiGetStatusCode() {
        String url = "https://api.github.com/users/RamanBohdan";
        httpClient.sendGet(url);

        Assert.assertEquals(httpClient.getStatusCode(), 200);
    }

    @Test
    public void testApiGetUserRepository() {
        String url = "https://api.github.com/users/RamanBohdan/repos";
        String sizeKey = "git_url";
        String value = "git://github.com/RamanBohdan/final-github-project-main.git";

        httpClient.sendGet(url);
        assertEquals(200, httpClient.getStatusCode());
        httpClient.getBody();
        logger.info("httpClient.getBody: " + httpClient.getBody());
        assertTrue(httpClient.getListBodyValuesByKey(sizeKey).contains(value));
    }

    @Test
    public void testApiGetUserSHHKey() throws IOException {
        String url = "https://api.github.com/users/RamanBohdan/keys";
        String key = "key";
        String value = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC/AZD2/OOC8NM/X3s6ZM0jRgW6x2Nfd1DrQHsUOhh4X5m+JSARGRF99+Wr/cqFI7KXrGcGifwyxAhtyEYQ/lpH1pS/GGGtcfkA0F3fjQKmImJZSOwRkZYEfbjA94C0N6tFxr2gZybmQcls93smTtoSc9lgIXDu09oewh+kdqnxv+LrBICASivQZhKVuOCtAHs2tdZUyzquAqwcIiuNK/fSTKj6VhZMwc53g3amU+bgslCUyeNLzZ/fr6plRKeeaG069qjucVqdJ8AWh/Jsw2AolXoqeeUERiLjjrsuC2FfQYVOf8NwyoyoAW7/xbo7llaRR25PnTU5mWuPKHh8VZK2x6YamA+KKUIBpPE/bq2UPJ5M7nYWBFjC7fhPyKywE86Uy7AJG2jgZJJp6KuNmbpy11FyEvDStJjvaTWe1O7ZSh1cy+rC4e6EqVD8z4ME8dO+liNuGUmerYLmp0J8JKr4ziyES6X+jYg05tl14DQrHyqJUife6y5RhfQZR1ohkYs=";

        httpClient.sendGet(url);
        assertEquals(200, httpClient.getStatusCode());
        httpClient.getBody();
        logger.info("httpClient.getBody: " + httpClient.getBody());
        assertTrue(httpClient.getListBodyValuesByKey(key).contains(value));
        }

}
