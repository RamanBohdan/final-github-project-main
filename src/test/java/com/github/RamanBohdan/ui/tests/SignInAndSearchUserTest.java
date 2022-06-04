package com.github.RamanBohdan.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class SignInAndSearchUserTest extends AbstractTest {
    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";

    @Test(dataProvider = "loginInCorrectValues", dataProviderClass = SignInAndSearchUserTest.class)
    public void testSignInUser() {
        GitHubUserPage userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

    }
}
