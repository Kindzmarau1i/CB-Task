package ru.navisale.cbtask.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class AbstractPageObject {

    private static final String BASE_URI = "https://navisale.ru/";

    public void directOpen(String url) {
        Selenide.open(BASE_URI + url);
        getWebDriver().manage().window().maximize();
    }

    public abstract void waitForOpened();

    public void verifyIsVisible(SelenideElement element) {
        element.shouldBe(Condition.appear);
    }
}
