package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement buttonSingIn;
    @FindBy(xpath = "//input[@class='form-control input-sm header-search-input jump-to-field js-jump-to-field js-site-search-focus']")
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
}
