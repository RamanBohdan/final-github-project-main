package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class GitHubUserRepositoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='d-none d-md-flex flex-md-items-center flex-md-justify-end']")
    private WebElement buttonNewRepository;
    @FindBy(xpath = "//input[@id='your-repos-filter']")
    private WebElement searchRepository;

    @FindBy(xpath = "//a[@href='/RamanBohdan/example']")
    private WebElement inputExampleRepository;


    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;
    @FindBy(xpath = "//input[@class='form-control input-sm header-search-input jump-to-field js-jump-to-field js-site-search-focus']")
    private WebElement buttonDeleteRepository;
    @FindBy(xpath = "//div[@class='position-relative']//input[@type='text']")
    private WebElement inputNameRepositoryFromDelete;
    @FindBy(xpath = "(//span[@class='d-md-inline-block d-none'])[1]")
    private WebElement buttonAcceptDeleteRepository;


    public ExampleRepository clickButtonAndCreateRepository() {
        buttonNewRepository.click();
        return new ExampleRepository();
    }

    public GitHubDeleteExampleRepository clickButtonExampleRepository() {
        inputExampleRepository.click();
        return new GitHubDeleteExampleRepository();
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

    private List<String> chooseUserRepository(String repository) {
        waitForElementToBeClickable(searchRepository).click();
        String nameInResult = "//input[@id='your-repos-filter']";
        List<String> name = driver.findElements(By.xpath(nameInResult)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return name;
    }
    public boolean isAnyResultContainsRepositoryName(String repository) {
        List<String> regionsInResult = chooseUserRepository(repository);
        return regionsInResult.stream().anyMatch(region -> region.contains(repository));
    }

  /*  public GitHubUserRepositoryPage chooseUserRepository(String repository) {
        searchRepository.click();
        String selectUserRepository = "//input[@id='your-repos-filter']";
        List<WebElement> listRepositories = driver.findElements(By.xpath(selectUserRepository));
        for (WebElement repo : listRepositories) {
            if (repository.equals(repo.getText().trim())) {
                logger.info("User Repository: " + repo.getText());
                repo.click();
                break;
            }
        }
        return this;
    }*/

   /* public GitHubUserRepositoryPage chooseUserRepository1(String nameRepository) {
        waitForVisibilityOfElement(searchRepository);
        waitForVisibilityOfElement(searchRepository).sendKeys(nameRepository);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(nameRepository)))).click().build().perform();
        return this;
    }*/

}
