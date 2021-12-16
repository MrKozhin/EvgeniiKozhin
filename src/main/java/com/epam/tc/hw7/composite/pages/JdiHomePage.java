package com.epam.tc.hw7.composite.pages;

import static com.epam.tc.hw7.composite.Header.MetalsAndColors;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.composite.forms.LogInForm;
import com.epam.tc.hw7.entities.User;

public class JdiHomePage extends WebPage {
    private LogInForm logInForm;

    @Css("#user-name")
    private Text username;
    @Css("#user-icon")
    private Button userIcon;
    @UI(".uui-navigation.nav li")
    public static Menu headerMenu;

    public String getUsername() {
        return username.getValue();
    }

    public void login(User user) {
        userIcon.click();
        logInForm.loginAs(user);
    }

    public void openMetalsAndColorsPage() {
        headerMenu.select(MetalsAndColors);
    }
}
