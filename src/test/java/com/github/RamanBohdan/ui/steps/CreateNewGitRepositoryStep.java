package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.pageobjects.CreateNewGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubUserRepositoryPage;

public class CreateNewGitRepositoryStep extends CreateNewGitHubRepository {

    private static final String nameRepository = "example";

    public static void createRepositoryStep() {
        SignInStep.signInAccountStep();
         new GitHubUserRepositoryPage()
                .clickButtonAndCreateRepository().getNewRepository(nameRepository);
    }

}
