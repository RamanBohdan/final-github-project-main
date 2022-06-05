package com.github.RamanBohdan.ui.steps;
import com.github.RamanBohdan.ui.empty.User;
import com.github.RamanBohdan.ui.pageobjects.CreateNewGitHubRepository;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.pageobjects.SignInToGitHubPage;
import com.github.RamanBohdan.ui.utils.UserCreator;

public class SignInStep extends SignInToGitHubPage {
    public static void SignInAccountStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword())
                .clickUserMenuForRepository();
    }

    public static void SignInAccountWithDataProviderStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword());
    }
}