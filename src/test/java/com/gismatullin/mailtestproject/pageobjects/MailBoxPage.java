package com.gismatullin.mailtestproject.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.gismatullin.mailtestproject.testhelper.TestHelper.EMAIL_THEME;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MailBoxPage {

    public SelenideElement composeButton() {
        return $(".mail-ComposeButton-Text");
    }

    public SelenideElement composeForm() {
        return $(".ComposePopup-Content");
    }

    public SelenideElement addressRow() {
        return $(".composeYabbles");
    }

    public SelenideElement themeRow() {
        return $(".ComposeSubject-TextField");
    }

    public SelenideElement messageBody() {
        return $(".cke_wysiwyg_div");
    }

    public SelenideElement sendButton() {
        return $("div.ComposeSendButton button");
    }

    public SelenideElement searchInput() {
        return $(".textinput__control");
    }

    public SelenideElement searchResult() {
        return $(".mail-MessagesSearchInfo-Title");
    }

    public SelenideElement clearSearchQuery() {
        return $("button.search-input__narrow-close-button");
    }

    public SelenideElement doneLink() {
        return $("a.ComposeDoneScreen-Link");
    }

    public SelenideElement selectAllMailsCheckBox() {
        return $("div.mail-Toolbar-Item_main-select-all");
    }

    public SelenideElement deleteMailButton() {
        return $("div.mail-Toolbar-Item_delete");
    }

    public SelenideElement userPic() {
        return $(".legouser__current-account");
    }

    public SelenideElement logoutRow() {
        return $(".legouser__menu-item_action_exit");
    }

    public SelenideElement refreshButton() {
        return $(".mail-ComposeButton-Refresh");
    }

    public ElementsCollection testEmailsByTheme() {
        String xpath = String.format("//span[@title='%s']", EMAIL_THEME);
        return $$x(xpath);
    }

}
