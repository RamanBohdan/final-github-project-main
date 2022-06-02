package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class GitHubUserRepositoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='d-none d-md-flex flex-md-items-center flex-md-justify-end']")
    private WebElement buttonNewRepository;
    @FindBy(xpath = "//input[@id='your-repos-filter']")
    private WebElement searchRepository;

    public CreateNewRepository clickButtonAndCreateRepository() {
        buttonNewRepository.click();
        return new CreateNewRepository();
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
