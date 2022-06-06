package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.dataprovider.SignInDataProvider;
import com.github.RamanBohdan.ui.steps.FindRepositoryStep;
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

        Assert.assertEquals(userPage.getTitleErrorMassagePassword(), GitHubUserPage.ERROR_MASSAGE_PASSWORD);
    }

    @Test(dataProvider = "loginInCorrectUserPassword", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserPassword(String userName) {
        GitHubUserPage userPage = new GitHubHomePage()
                .openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword);

        Assert.assertEquals(userPage.getTitleErrorMassage(), GitHubUserPage.ERROR_MASSAGE);
    }

    @Test(dataProvider = "searchInCorrectUserRepo", dataProviderClass = SignInDataProvider.class)
   public void testSearchInCorrectUserRepo(String repo) {

        FindRepositoryStep findRepository = new FindRepositoryStep();
        FindRepositoryStep.findRepositoryBeforeLoginFalse(repo);

        Assert.assertFalse(findRepository.isAnyResultContainsRepositoryNameFalse(repo));

    }
    // TODO: 07.06.2022
}
