package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.pageobjects.GitHubFindRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.pageobjects.GitHubUserRepositoryPage;

public class FindRepositoryStep extends GitHubFindRepository {

    private static final String repository = "RamanBohdan/final-github-project-main";
    private static final String nameRepository = "example";

    public static void findRepositoryBeforeLogin() {
        new GitHubHomePage().openPage()
                .getChooseUserRepository()
                .isAnyResultContainsRepositoryName(repository);
    }

    public static void findRepositoryBeforeLoginFalse(String repo) {
        new GitHubHomePage().openPage()
                .getChooseUserRepository()
                .isAnyResultContainsRepositoryName(repo);
    }

    public static void findRepositoryAfterCreateUserStep() {
        SignInStep.signInAccountStep();
        new GitHubUserRepositoryPage()
                .getChooserRepository()
                .isAnyResultContainsRepositoryName(nameRepository);

    }
}