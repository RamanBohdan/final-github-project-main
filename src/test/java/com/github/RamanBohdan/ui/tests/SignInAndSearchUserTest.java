package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.dataprovider.SignInDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class SignInAndSearchUserTest extends AbstractTest {
    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";

   @Test(dataProvider = "loginInCorrectUserName", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserName(String userName) {
        GitHubUserPage userPage = new GitHubHomePage()
                .openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

       Assert.assertEquals(userPage.getTitleErrorMassageUser(),GitHubUserPage.ERROR_MASSAGE_USER);
    }

    @Test(dataProvider = "loginInCorrectUserPassword", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserPassword(String userPassword) {
        GitHubUserPage userPage = new GitHubHomePage()
                .openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

        Assert.assertEquals(userPage.getTitleErrorMassagePassword(),GitHubUserPage.ERROR_MASSAGE_PASSWORD);
    }

}
