package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.empty.User;
import com.github.RamanBohdan.ui.pageobjects.DeleteGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.utils.UserCreator;

public class DeleteRepositoryStep extends DeleteGitHubRepository {

    public static void signInAccountAndDeleteRepositoryStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword())
                .clickUserMenuForRepository()
                .clickButtonExampleRepository()
                .clickDeleteRepository()
                .selectFindRepositoryName();
    }
}
