package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GitHubUserPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']")
    private WebElement selectUserMenu;
    @FindBy(xpath = "//a[text()='Your repositories']")
    private WebElement inputUserRepository;

    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;
    @FindBy(xpath = "//input[@class='form-control input-sm header-search-input jump-to-field js-jump-to-field js-site-search-focus']")
    private WebElement buttonDeleteRepository;
    @FindBy(xpath = "//div[@class='position-relative']//input[@type='text']")
    private WebElement inputNameRepositoryFromDelete;
    @FindBy(xpath = "(//span[@class='d-md-inline-block d-none'])[1]")
    private WebElement buttonAcceptDeleteRepository;


    public GitHubUserRepositoryPage clickUserMenuForRepository() {
        waitForVisibilityOfElement(selectUserMenu).click();
        waitForVisibilityOfElement(inputUserRepository).click();
        return new GitHubUserRepositoryPage();
    }

    public GitHubUserRepositoryPage clickDeleteRepository() {
        waitForVisibilityOfElement(buttonSetting).click();
        return new GitHubUserRepositoryPage();
    }

    public GitHubUserPage selectFindRepositoryName() {
        String nameRepository = "RamanBohdan/example";
        waitForElementToBeClickable(buttonDeleteRepository).sendKeys(nameRepository);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(nameRepository)))).click().build().perform();
        return new GitHubUserPage();
    }
}
