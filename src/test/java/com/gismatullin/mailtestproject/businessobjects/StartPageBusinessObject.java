package com.gismatullin.mailtestproject.businessobjects;

import com.gismatullin.mailtestproject.pageobjects.StartPage;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.*;

import org.openqa.selenium.Keys;

public class StartPageBusinessObject {

    private StartPage page = new StartPage();

    public MailBoxPageBusinessObject login(String login, String password) {
        page.startLoginButton().click();
        page.loginInput().sendKeys(login + Keys.RETURN);
        page.passwInput().sendKeys(passw + Keys.RETURN);
        return new MailBoxPageBusinessObject();
    }
    
}
