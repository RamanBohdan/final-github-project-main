package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleRepository extends AbstractPage{
    @FindBy(xpath = "//a[@href='/RamanBohdan/example']")
    private WebElement searchRepository;

    @FindBy(xpath = "//input[@id='repository_name']")
    private WebElement inputNameRepository;
    @FindBy(xpath = "//button[@class='btn-primary btn']")
    private WebElement buttonCreateRepository;

    public ExampleRepository getNewRepository(String nameRepository){
        inputNameRepository.sendKeys(nameRepository);
        waitForElementToBeClickable(buttonCreateRepository).click();
        return new ExampleRepository();
    }


    private List<String> chooseUserRepository(String repository) {
        waitForElementToBeClickable(searchRepository).click();
        String nameInResult = "//a[@href='/RamanBohdan/example']";
        List<String> name = driver.findElements(By.xpath(nameInResult)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return name;
    }

    public boolean isAnyResultContainsRepositoryName(String repository) {
        List<String> regionsInResult = chooseUserRepository(repository);
        return regionsInResult.stream().anyMatch(region -> region.contains(repository));
    }
}
