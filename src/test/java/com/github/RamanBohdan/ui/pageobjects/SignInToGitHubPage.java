package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInToGitHubPage extends AbstractPage{

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSignIn;

    public SignInToGitHubPage fillLoginUser(String userName) {
        inputLogin.clear();
        inputLogin.sendKeys(userName);
        logger.info("Type userName: " + userName);
        return this;
    }

    public SignInToGitHubPage fillPasswordUser(String userPassword) {
        inputPassword.clear();
        inputPassword.sendKeys(userPassword);
        logger.info("Type userPassword: " + userPassword);
        return this;
    }

    public SignInToGitHubPage clickSignInUser() {
        buttonSignIn.click();
        logger.info("Click buttonSignIn");
        return this;
    }

    public GitHubUserPage fillFormAddClickButtonSignIn(String userName, String userPassword) {
        fillLoginUser(userName);
        fillPasswordUser(userPassword);
        buttonSignIn.click();
        logger.info("Click buttonSignIn");
        return new GitHubUserPage();
    }
}
