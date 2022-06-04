package com.github.RamanBohdan.ui.empty;

public class User {
    private static String username = "RamanBohdan";
    private static String password = "wmckJiMqCZ1";


    public User(String username, String password) {
        User.username = username;
        User.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        User.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

