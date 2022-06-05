package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.dataprovider.SignInDataProvider;
import com.github.RamanBohdan.ui.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class SignInAndSearchUserTest extends AbstractTest {

   @Test(dataProvider = "loginInCorrectUserName", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserName(String userName, String userPassword) {
       SignInStep sign = new SignInStep();
       SignInStep.SignInAccountWithDataProviderStep();

       Assert.assertEquals(sign.getTitleErrorMassage(),GitHubUserPage.ERROR_MASSAGE);
    }

    @Test(dataProvider = "loginInCorrectUserPassword", dataProviderClass = SignInDataProvider.class)
    public void testProvideLoginInCorrectUserPassword(String userPassword) {
        SignInStep sign = new SignInStep();
        SignInStep.SignInAccountWithDataProviderStep();

        Assert.assertEquals(sign.getTitleErrorMassage(),GitHubUserPage.ERROR_MASSAGE);
    }

}
