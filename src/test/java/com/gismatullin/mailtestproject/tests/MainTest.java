package com.gismatullin.mailtestproject.tests;

import static com.gismatullin.mailtestproject.testhelper.TestHelper.clean;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.login;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.passw;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.setup;
import static org.testng.Assert.assertEquals;

import com.gismatullin.mailtestproject.businessobjects.MailBoxPageBusinessObject;
import com.gismatullin.mailtestproject.businessobjects.StartPageBusinessObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTest {

    @BeforeClass
    public void tearUp() {
        setup();
    }

    @Test
    public void sendingTestEmail() {
        StartPageBusinessObject startPageBO = new StartPageBusinessObject();
        MailBoxPageBusinessObject mailBoxPageBO = startPageBO.login(login, passw);
        int previousTestEmailsNumber = mailBoxPageBO.countTestEmails();
        mailBoxPageBO.sendTestEmail("test emails number : " + previousTestEmailsNumber);
        int newTestEmailsNumber = mailBoxPageBO.countTestEmails();
        int actual = newTestEmailsNumber - previousTestEmailsNumber;
        mailBoxPageBO.logout();
        assertEquals(actual, 1);
    }

    @AfterClass
    public void tearDown() {
        clean();
    }
}
