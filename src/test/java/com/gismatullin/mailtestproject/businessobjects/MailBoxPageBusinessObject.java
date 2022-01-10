package com.gismatullin.mailtestproject.businessobjects;

import static com.gismatullin.mailtestproject.testhelper.TestHelper.EMAIL_THEME;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.login;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.SEARCH_QUERY;

import com.gismatullin.mailtestproject.pageobjects.MailBoxPage;

import org.openqa.selenium.Keys;

public class MailBoxPageBusinessObject {

    private MailBoxPage page = new MailBoxPage();

    public void sendTestEmail(String body) {
        page.composeButton().click();
        page.addressRow().sendKeys(login);
        page.themeRow().sendKeys(EMAIL_THEME);
        page.messageBody().click(); // focus to message body form
        page.messageBody().sendKeys(body);
        page.sendButton().click(); // send test email
        page.doneLink().click();
    }

    public int countTestEmails() {
        String searchQuery = SEARCH_QUERY + "\"" + EMAIL_THEME + "\"";
        refreshMailList();
        clearSearchInput();
        page.searchInput().sendKeys(searchQuery + Keys.ENTER);
        return page.testEmailsByTheme().size(); // return count of found emails
    }

    private void refreshMailList() {
        page.refreshButton().click();
    }
    
    private void clearSearchInput() {
        page.searchInput().clear();
    }

    public void logout() {
        page.userPic().click();
        page.logoutRow().click();
    }
    
}
