package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class GitHubFindRepository extends AbstractPage {

    @FindBy(xpath = "//li[@class='repo-list-item hx_hit-repo d-flex flex-justify-start py-4 public source']")
    private WebElement searchUserRepository;
    @FindBy(xpath = "//input[@id='your-repos-filter']")
    private WebElement searchRepository;

    private List<String> chooseUserRepository(String repository) {
        waitForVisibilityOfElement(searchUserRepository);
        String nameInResult = "//a[@href='/RamanBohdan/final-github-project-main']";
        List<String> name = driver.findElements(By.xpath(nameInResult)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return name;
    }
    private List<String> chooseUserRepositoryFalse(String repository) {
        waitForVisibilityOfElement(searchUserRepository);
        String nameInResult = "//li[@class='repo-list-item hx_hit-repo d-flex flex-justify-start py-4 public source']";
        List<String> name = driver.findElements(By.xpath(nameInResult)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return name;
    }

    public boolean isAnyResultContainsRepositoryNameFalse(String repository) {
        List<String> searchInResult = chooseUserRepositoryFalse(repository);
        logger.info("isAnyResultContainsRepositoryName");
        logger.info(searchInResult.stream().anyMatch(repo -> repo.contains(repository)));
        return searchInResult.stream().anyMatch(repo -> repo.contains(repository));
    }

    public boolean isAnyResultContainsRepositoryName(String repository) {
        List<String> searchInResult = chooseUserRepository(repository);
        logger.info("isAnyResultContainsRepositoryName");
        logger.info(searchInResult.stream().anyMatch(repo -> repo.contains(repository)));
        return searchInResult.stream().anyMatch(repo -> repo.contains(repository));
    }
}
