package com.github.RamanBohdan.ui.utils;

import com.github.RamanBohdan.ui.entity.User;
import com.github.RamanBohdan.ui.pageobjects.AbstractPage;

public class UserCreator extends AbstractPage {
        public static final String USER_NAME = "RamanBohdan";
        public static final String USER_PASSWORD = "wmckJiMqCZ1";

       public static User createUser() {

            return new User(USER_NAME, USER_PASSWORD);
        }
    }
