package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteGitHubRepository extends AbstractPage {
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

    public DeleteGitHubRepository clickDeleteRepository() {
        waitForVisibilityOfElement(buttonSetting).click();
        return this;
    }

    public DeleteGitHubRepository selectFindRepositoryName() {
        String nameRepository = "RamanBohdan/example";
        buttonDeleteRepository.click();
        inputNameRepositoryFromDelete.sendKeys(nameRepository);
        buttonAcceptDeleteRepository.click();
        return this;
    }

    public DeleteGitHubRepository getChooseRepository(String repository) {
        searchRepository.click();
        waitForElementToBeClickable(searchRepository);
        String selectChooseRepo = "(//div[@class='region-selection'])[1]";
        List<WebElement> chooseRepo = driver.findElements(By.xpath(selectChooseRepo));
        for (WebElement repo : chooseRepo) {
            if (repository.equals(repo.getText().trim())) {
                repo.click();
                break;
            }
        }
        return this;
    }

    public boolean isAnyResultContainsRepositoryName(String repository) {
        List<String> searchInResult = (List<String>) getChooseRepository(repository);
        logger.info("isAnyResultContainsRepositoryName");
        logger.info(searchInResult.stream().anyMatch(repo -> repo.contains(repository)));
        return searchInResult.stream().anyMatch(repo -> repo.contains(repository));
    }
}
