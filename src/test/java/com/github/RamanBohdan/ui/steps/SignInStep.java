package com.github.RamanBohdan.ui.steps;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.pageobjects.SignInToGitHubPage;

public class SignInStep extends SignInToGitHubPage{
    private GitHubHomePage homePage;
    private SignInToGitHubPage signInPage;
    private SignInToGitHubPage authorizedUserPage;

    public void openSignInForm() {
        signInPage = homePage.openPage()
                .clickButtonSingIn();
    }

 /*   public void fillSigInForm(User user){
        signInPage = signInPage.fillLoginUser(user.getUsername())
                .fillPasswordUser(user.getPassword());
    }
    public void clickSignInButton(){
        authorizedUserPage = signInPage.clickSignInUser();
    }*/
}
