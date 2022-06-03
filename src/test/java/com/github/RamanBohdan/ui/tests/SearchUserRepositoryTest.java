package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.pageobjects.CreateNewGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import org.testng.annotations.Test;

public class SearchUserRepositoryTest extends AbstractTest {

    private static String nameRepository = "RamanBohdan/example";

    @Test(enabled = false)
    private void testSearchUserRepository(){
        CreateNewGitHubRepository homePage = new GitHubHomePage()
                .openPage()
                .getUserRepository();
    }


}
