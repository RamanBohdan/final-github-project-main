package com.github.RamanBohdan.ui.dataprovider;

import com.github.RamanBohdan.ui.pageobjects.AbstractPage;
import org.testng.annotations.DataProvider;

public class SignInDataProvider extends AbstractPage {

    @DataProvider(name = "loginInCorrectValues")
    public Object[] provideLoginInCorrectValues(String userName, String userPassword){
        return new Object[]{"100", "49", "-118", "301", "4545656", "абв", "/.."};
    }

}