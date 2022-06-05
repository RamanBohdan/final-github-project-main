package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.steps.CreateNewGitRepositoryStep;
import com.github.RamanBohdan.ui.steps.DeleteRepositoryStep;
import com.github.RamanBohdan.ui.steps.FindRepositoryStep;
import com.github.RamanBohdan.ui.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class GitHubTest extends AbstractTest {

    private static final String repository = "RamanBohdan/final-github-project-main";
    private static final String nameRepository = "example";
    FindRepositoryStep findRepository;
    SignInStep sign;
    CreateNewGitHubRepository createNewGitHubRepository;
    DeleteRepositoryStep deleteRepository;

    @Test(priority = 1)
    public void testSignInUserInAccount() {
        SignInStep.signInAccountStep();

        Assert.assertEquals(sign.getTitleAvatarUser(), GitHubUserPage.USER_NAME);
    }

    @Test(priority = 1)
    public void testSearchRepositoryOnHomePage() {
        FindRepositoryStep.findRepositoryWithDataProviderStep();

        Assert.assertTrue(findRepository.isAnyResultContainsRepositoryName(repository));
    }

    @Test(priority = 2)
    public void testSignInUserAndCreateNewRepository() {
        CreateNewGitRepositoryStep.createRepositoryStep();

        Assert.assertTrue(createNewGitHubRepository.isAnyResultContainsRepositoryName(nameRepository));
    }

    @Test(priority = 3)
    public void testChooseUserRepository() {
        CreateNewGitRepositoryStep.createRepositoryStep();

        Assert.assertTrue(createNewGitHubRepository.isAnyResultContainsRepositoryName(repository));
    }

    @Test(priority = 4)
    public void testDeleteUserRepository() {
        DeleteRepositoryStep.signInAccountAndDeleteRepositoryStep();

        Assert.assertTrue(deleteRepository.isAnyResultContainsRepositoryName(nameRepository));
    }

}
