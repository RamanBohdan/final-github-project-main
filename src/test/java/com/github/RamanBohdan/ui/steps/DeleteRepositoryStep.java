package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.pageobjects.DeleteGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubUserRepositoryPage;

public class DeleteRepositoryStep extends DeleteGitHubRepository {

    public static void signInAccountAndDeleteRepositoryStep() {
        SignInStep.signInAccountStep();
        new GitHubUserRepositoryPage()
                .clickButtonExampleRepository()
                .clickDeleteRepository()
                .selectFindRepositoryName();
    }
}
