package com.github.RamanBohdan.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class GitHubTest extends AbstractTest {
    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";
    private static final String nameRepository = "example";
    private static final String repository = "RamanBohdan/final-github-project-main";

    @Test(priority = 1)
    public void testSignInUserAndCreateNewRepository() {
        ExampleRepository userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .clickUserMenuForRepository()
                .clickButtonAndCreateRepository()
                .getNewRepository(nameRepository);

        Assert.assertTrue(userPage.isAnyResultContainsRepositoryName(nameRepository));
    }

    @Test(priority = 2)
    public void testChooseUserRepository() {
        GitHubChoosePage userPage = new GitHubHomePage()
                .openPage()
                .getChooseUserRepository();

        Assert.assertTrue(userPage.isAnyResultContainsRepositoryName(repository));
    }

    @Test(priority = 3)
    public void testDeleteUserRepository() throws InterruptedException {
        GitHubDeleteExampleRepository userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .clickUserMenuForRepository()
                .clickButtonExampleRepository()
                .clickDeleteRepository()
                .selectFindRepositoryName();

        Assert.assertTrue(userPage.isAnyResultContainsRepositoryName(nameRepository));
    }
}
