package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubUserRepositoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='d-none d-md-flex flex-md-items-center flex-md-justify-end']")
    private WebElement buttonNewRepository;
    @FindBy(xpath = "//a[@href='/RamanBohdan/example']")
    private WebElement inputExampleRepository;
    @FindBy(xpath = "//a[@id='settings-tab']")
    private WebElement buttonSetting;

    public CreateNewGitHubRepository clickButtonAndCreateRepository() {
        buttonNewRepository.click();
        return new CreateNewGitHubRepository();
    }

    public DeleteGitHubRepository clickButtonExampleRepository() {
        inputExampleRepository.click();
        return new DeleteGitHubRepository();
    }

}
