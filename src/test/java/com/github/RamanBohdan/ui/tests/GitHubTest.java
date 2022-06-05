package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.steps.CreateNewGitRepositoryStep;
import com.github.RamanBohdan.ui.steps.FindRepositoryStep;
import com.github.RamanBohdan.ui.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class GitHubTest extends AbstractTest {

    @Test(priority = 1)
    public void testSignInUserInAccount() {
        SignInStep sign = new SignInStep();
        SignInStep.signInAccountStep();

        Assert.assertEquals(sign.getTitleAvatarUser(), GitHubUserPage.USER_NAME);
    }

    @Test(priority = 2)
    public void testSignInUserAndCreateNewRepository() {
        CreateNewGitHubRepository createNewGitHubRepository = new CreateNewGitHubRepository();
        CreateNewGitRepositoryStep.createRepositoryStep();

        Assert.assertTrue(createNewGitHubRepository.isAnyResultContainsRepositoryName(NAME_REPOSITORY));
    }

    @Test(priority = 3)
    public void testSearchRepositoryOnHomePage() {
        FindRepositoryStep findRepository= new FindRepositoryStep();
        FindRepositoryStep.findRepositoryBeforeLogin();

        Assert.assertTrue(findRepository.isAnyResultContainsRepositoryName(REPOSITORY));
    }

    @Test(priority = 4)
    public void testChooseUserRepository() {
        FindRepositoryStep findRepository= new FindRepositoryStep();
        FindRepositoryStep.findRepositoryAfterCreateUserStep();

        Assert.assertTrue(findRepository.isAnyResultContainsRepositoryName(NAME_REPOSITORY));
    }

 /*  @Test(priority = 5)
    public void testDeleteUserRepository() {
        DeleteRepositoryStep deleteRepository = new DeleteRepositoryStep();
        DeleteRepositoryStep.signInAccountAndDeleteRepositoryStep();

        Assert.assertTrue(deleteRepository.isAnyResultContainsRepositoryName(NAME_REPOSITORY));
    }

  */
    // TODO


}
