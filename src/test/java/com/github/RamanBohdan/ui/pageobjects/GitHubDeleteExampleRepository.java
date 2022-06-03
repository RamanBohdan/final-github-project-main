package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubDeleteExampleRepository extends AbstractPage {
    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;
    @FindBy(xpath = "//details[@class='details-reset details-overlay details-overlay-dark flex-md-order-1 flex-order-2']//summary")
    private WebElement buttonDeleteRepository;
    @FindBy(xpath = "(//input[@class='form-control input-block'])[4]")
    private WebElement inputNameRepositoryFromDelete;
    @FindBy(xpath = "(//span[@class='d-md-inline-block d-none'])[2]")
    private WebElement buttonAcceptDeleteRepository;
    private String nameRepository= "RamanBohdan/example";

    public GitHubDeleteExampleRepository clickDeleteRepository(){
        waitForVisibilityOfElement(buttonSetting).click();
        return this;
    }

        public GitHubUserPage selectFindRepositoryName(){
        buttonDeleteRepository.click();
        inputNameRepositoryFromDelete.sendKeys(nameRepository);
        buttonAcceptDeleteRepository.click();
        return new GitHubUserPage();
    }
}
