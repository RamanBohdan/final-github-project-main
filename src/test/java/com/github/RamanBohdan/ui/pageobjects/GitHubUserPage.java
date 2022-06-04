package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubUserPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']")
    private WebElement selectUserMenu;
    @FindBy(xpath = "//a[text()='Your repositories']")
    private WebElement inputUserRepository;
    @FindBy(xpath = "//div[@class='px-2']")
    private WebElement titleErrorMassageUser;
    @FindBy(xpath = "//div[@id='login']")
    private WebElement titleErrorMassagePassword;

    public static final String USER_NAME = "RamanBohdan";
    public static final String ERROR_MASSAGE_USER = "Incorrect username or password.";
    public static final String ERROR_MASSAGE_PASSWORD = "There have been several failed attempts to sign in from this account or IP address. Please wait a while and try again later.";

    public GitHubUserRepositoryPage clickUserMenuForRepository() {
        waitForVisibilityOfElement(selectUserMenu).click();
        waitForVisibilityOfElement(inputUserRepository).click();
        return new GitHubUserRepositoryPage();
    }

    public String getTitleErrorMassageUser(){
        return titleErrorMassageUser.getText();
    }

    public String getTitleErrorMassagePassword(){
        return titleErrorMassagePassword.getText();
    }
}