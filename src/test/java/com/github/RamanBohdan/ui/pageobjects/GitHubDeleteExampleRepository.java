package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GitHubDeleteExampleRepository extends AbstractPage {
    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;
    @FindBy(xpath = "//details[@class='details-reset details-overlay details-overlay-dark flex-md-order-1 flex-order-2']//summary")
    private WebElement buttonDeleteRepository;
    @FindBy(xpath = "//div[@class='position-relative']//input[@type='text']")
    private WebElement inputNameRepositoryFromDelete;
    @FindBy(xpath = "(//span[@class='d-md-inline-block d-none'])[1]")
    private WebElement buttonAcceptDeleteRepository;
    private String nameRepository= "RamanBohdan/example";

    public GitHubDeleteExampleRepository clickDeleteRepository(){
        waitForVisibilityOfElement(buttonSetting).click();
        return this;
    }

        public GitHubDeleteExampleRepository selectFindRepositoryName(){
        buttonDeleteRepository.click();
        inputNameRepositoryFromDelete.sendKeys(nameRepository);
        buttonAcceptDeleteRepository.click();

      //  waitForElementToBeClickable(buttonDeleteRepository).sendKeys(nameRepository);
      //  Actions action = new Actions(driver);
      //  action.moveToElement(driver.findElement(By.xpath(String.format(nameRepository)))).click().build().perform();
        return this;
    }
}
