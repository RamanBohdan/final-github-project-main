package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.dataprovider.SignInDataProvider;
import com.github.RamanBohdan.ui.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class SignInAccountTest extends AbstractTest {

    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";

    @Test(dataProvider = "loginInCorrectUserName", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserName(String userPassword) {
        GitHubUserPage userPage = new GitHubHomePage()
                .openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

        Assert.assertEquals(userPage.getTitleErrorMassage(), GitHubUserPage.ERROR_MASSAGE);
    }

    @Test(dataProvider = "loginInCorrectUserPassword", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserPassword(String userName) {
        GitHubUserPage userPage = new GitHubHomePage()
                .openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

        Assert.assertEquals(userPage.getTitleErrorMassage(), GitHubUserPage.ERROR_MASSAGE);
    }

}
