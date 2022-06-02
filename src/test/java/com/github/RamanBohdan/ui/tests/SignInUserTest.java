package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.empty.User;
import com.github.RamanBohdan.steps.SignInStep;
import org.testng.annotations.Test;

public class SignInUserTest extends AbstractTest {
    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";
    @Test
    public void testSignInUser() {
        SignInStep signInSteps = new SignInStep();
        signInSteps.openSignInForm();
        signInSteps.fillSigInForm(new User("RamanBohdan","wmckJiMqCZ1"));
        signInSteps.clickSignInButton();
    }

}
