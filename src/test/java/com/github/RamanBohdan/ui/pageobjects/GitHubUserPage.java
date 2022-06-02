package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubUserPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']")
    private WebElement selectUserMenu;
    @FindBy(xpath = "//a[text()='Your repositories']")
    private WebElement inputUserRepository;

    public GitHubUserRepositoryPage clickUserMenuForRepository() {
        waitForVisibilityOfElement(selectUserMenu).click();
        waitForVisibilityOfElement(inputUserRepository).click();
        return new GitHubUserRepositoryPage();
    }
}
