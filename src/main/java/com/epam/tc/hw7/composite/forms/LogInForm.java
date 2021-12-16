package com.epam.tc.hw7.composite.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class LogInForm extends Form<User> {
    @Css("#name")
    private TextField loginName;
    @Css("#password")
    private TextField password;
    @Css("#login-button")
    private Button submit;
}
