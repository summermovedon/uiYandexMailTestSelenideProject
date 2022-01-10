package com.gismatullin.mailtestproject.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class StartPage {
    
    public SelenideElement startLoginButton() {
        return $(".HeadBanner-Button-Enter");
    }

    public SelenideElement loginInput() {
        return $("#passp-field-login");
    }

    public SelenideElement passwInput() {
        return $("#passp-field-passwd");
    }

}
