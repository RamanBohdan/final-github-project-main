package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.steps.CreateNewGitRepositoryStep;
import com.github.RamanBohdan.ui.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class GitHubTest extends AbstractTest {

    private static final String repository = "RamanBohdan/final-github-project-main";
    private static final String nameRepository = "example";

    @Test(priority = 1)
    public void testSignInUser() {
        SignInStep sign = new SignInStep();
        SignInStep.SignInAccountStep();

        Assert.assertEquals(sign.getTitleAvatarUser(), GitHubUserPage.USER_NAME);
    }

    @Test(priority = 2)
    public void testSignInUserAndCreateNewRepository() {
        CreateNewGitHubRepository createNewGitHubRepository = new CreateNewGitHubRepository();
        CreateNewGitRepositoryStep.CreateRepositoryStep();

        Assert.assertTrue(createNewGitHubRepository.isAnyResultContainsRepositoryName(nameRepository));
    }

    @Test(priority = 3)
    public void testChooseUserRepository() {
        GitHubFindRepository userPage = new GitHubHomePage()
                .openPage()
                .getChooseUserRepository();

        Assert.assertTrue(userPage.isAnyResultContainsRepositoryName(repository));
    }

   /* @Test(priority = 4)
    public void testDeleteUserRepository() throws InterruptedException {
        DeleteGitHubRepository userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .clickUserMenuForRepository()
                .clickButtonExampleRepository()
                .clickDeleteRepository()
                .selectFindRepositoryName();

        Assert.assertTrue(userPage.isAnyResultContainsRepositoryName(nameRepository));
    }
    */ // TODO: 04.06.2022  

}
