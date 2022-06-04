package com.github.RamanBohdan.ui.steps;

import com.github.RamanBohdan.ui.empty.User;
import com.github.RamanBohdan.ui.pageobjects.CreateNewGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.utils.UserCreator;

public class CreateNewGitRepositoryStep extends CreateNewGitHubRepository {

    private static final String nameRepository = "example";

    public static void CreateRepositoryStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword())
                .clickUserMenuForRepository().clickButtonAndCreateRepository()
                .getNewRepository(nameRepository);
    }

}
