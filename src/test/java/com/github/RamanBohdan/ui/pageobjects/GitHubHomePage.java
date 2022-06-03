package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

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

    public ExampleRepository getUserRepository() {
        searchUserRepository.sendKeys("RamanBohdan/example" + Keys.ENTER);


        return new ExampleRepository();
    }

    public GitHubChoosePage getChooseUserRepository() {
        waitForElementToBeClickable(searchUserRepository).click();
        searchUserRepository.sendKeys("RamanBohdan/final-github-project-main" + Keys.ENTER);
        return new GitHubChoosePage();
    }

}
