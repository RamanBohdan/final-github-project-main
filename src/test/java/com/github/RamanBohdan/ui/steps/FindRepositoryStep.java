package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.pageobjects.GitHubFindRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;

public class FindRepositoryStep extends GitHubFindRepository {

    private static final String repository = "RamanBohdan/final-github-project-main";

    public static void findRepositoryWithDataProviderStep() {
        new GitHubHomePage().openPage()
                .getChooseUserRepository()
                .isAnyResultContainsRepositoryName(repository);
    }
}