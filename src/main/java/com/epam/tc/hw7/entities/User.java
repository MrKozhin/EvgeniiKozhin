package com.epam.tc.hw7.entities;

import com.epam.jdi.light.elements.composite.Form;
import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    public static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String loginName;
    private String password;
    private String loggedInUsername;

    public User(String loginName, String password, String loggedInUsername) {
        this.loginName = loginName;
        this.password = password;
        this.loggedInUsername = loggedInUsername;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }
}
