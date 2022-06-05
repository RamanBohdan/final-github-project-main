package com.github.RamanBohdan.ui.dataprovider;

import com.github.RamanBohdan.ui.pageobjects.AbstractPage;
import org.testng.annotations.DataProvider;

public class SignInDataProvider extends AbstractPage {

    @DataProvider(name = "loginInCorrectUserName")
    public Object[][] testProvideLoginInCorrectUserName() {
        return new Object[][]{{"100"}, {"-AQdd5"}, {"Hello"}, {"Boss"}, {"$#@!"}};
    }

    @DataProvider(name = "loginInCorrectUserPassword")
    public Object[][] testProvideLoginInCorrectUserPassword() {
        return new Object[][]{{"1234567890"}, {"password"}, {"HelloWord"}, {"*******"}, {"$#@!"}};
    }

}