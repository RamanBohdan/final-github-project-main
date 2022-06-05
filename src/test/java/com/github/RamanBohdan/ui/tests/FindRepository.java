package com.github.RamanBohdan.ui.tests;

import com.github.RamanBohdan.ui.pageobjects.GitHubFindRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;

public class FindRepository extends GitHubFindRepository{

    private static final String repository = "RamanBohdan/final-github-project-main";
    FindRepository findRepository= new FindRepository();
    public static void FindRepositoryWithDataProviderStep() {
        new GitHubHomePage().openPage()
                .getChooseUserRepository().isAnyResultContainsRepositoryName(repository);
    }
        }