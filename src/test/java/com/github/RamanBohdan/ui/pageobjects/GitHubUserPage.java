package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class GitHubUserPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']")
    private WebElement selectUserMenu;
    @FindBy(xpath = "//a[text()='Your repositories']")
    private WebElement inputUserRepository;

    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;

    @FindBy(xpath = "//details[@class='details-reset details-overlay details-overlay-dark flex-md-order-1 flex-order-2']//summary")
    private WebElement buttonDeleteRepository;
    @FindBy(xpath = "(//input[@class='form-control input-block'])[4]")
    private WebElement inputNameRepositoryFromDelete;
    @FindBy(xpath = "(//span[@class='d-md-inline-block d-none'])[2]")
    private WebElement buttonAcceptDeleteRepository;

    @FindBy(xpath = "//input[@id='dashboard-repos-filter-left']")
    private WebElement searchRepository;

    @FindBy(xpath = "//a[@href='/RamanBohdan/example']")
    private WebElement inputExampleRepository;


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
        searchRepository.sendKeys(nameRepository);
        inputNameRepositoryFromDelete.sendKeys(nameRepository);
      //  Actions action = new Actions(driver);
      //  action.moveToElement(driver.findElement(By.name(nameRepository))).click().build().perform();
        buttonDeleteRepository.click();
        buttonAcceptDeleteRepository.click();
        return this;
    }

  /*  public GitHubUserPage selectFindRepositoryName2(String repository) {
        Actions action = new Actions(driver);
        String selectChooseRepo = "//input[@id='dashboard-repos-filter-left']";
        action.moveToElement(driver.findElement(By.xpath(String.format(selectChooseRepo, repository))))
                .click().build().perform();
        waitForVisibilityOfElement(searchRepository);
        return this;
    }*/
}