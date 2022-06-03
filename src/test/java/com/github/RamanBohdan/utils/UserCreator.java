package com.github.RamanBohdan.utils;

import com.github.RamanBohdan.empty.User;

public class UserCreator {
        public static final String USER_NAME = "RamanBohdan";
        public static final String USER_PASSWORD = "wmckJiMqCZ1";

        public static User createUser() {

            return new User(USER_NAME, USER_PASSWORD);
        }

        public static User createUser(String name, String password) {
            return new User(name, password);
        }
    }
