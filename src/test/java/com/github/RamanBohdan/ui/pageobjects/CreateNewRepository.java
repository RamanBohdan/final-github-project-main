package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewRepository extends AbstractPage{

    @FindBy(xpath = "//input[@id='repository_name']")
    private WebElement inputNameRepository;
    @FindBy(xpath = "//button[@class='btn-primary btn']")
    private WebElement buttonCreateRepository;

    public CreateNewRepository getNewRepository(String nameRepository){
        inputNameRepository.sendKeys(nameRepository);
        waitForElementToBeClickable(buttonCreateRepository).click();
        return this;
    }

}
