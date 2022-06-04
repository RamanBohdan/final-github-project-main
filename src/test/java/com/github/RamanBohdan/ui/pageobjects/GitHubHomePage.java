package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement buttonSingIn;
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchUserRepository;

    public GitHubHomePage openPage() {
        String BASE_URL = "https://github.com/";
        driver.get(BASE_URL);
        return this;
    }

    public SignInToGitHubPage clickButtonSingIn() {
        buttonSingIn.click();
        return new SignInToGitHubPage();
    }

    public CreateNewGitHubRepository getUserRepository() {
        searchUserRepository.sendKeys("RamanBohdan/example" + Keys.ENTER);
        return new CreateNewGitHubRepository();
    }

    public GitHubFindRepository getChooseUserRepository() {
        waitForElementToBeClickable(searchUserRepository).click();
        searchUserRepository.sendKeys("RamanBohdan/final-github-project-main" + Keys.ENTER);
        return new GitHubFindRepository();
    }

}
