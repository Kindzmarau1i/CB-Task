package ru.navisale.cbtask.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class AbstractPageObject {

    private static final String BASE_URI = "https://navisale.ru/";

    public void directOpen(String url) {
        Selenide.open(BASE_URI + url);
        getWebDriver().manage().window().maximize();
    }

    public abstract void waitForOpened();

    public void scrollPage(int step, boolean isUp) {
        for (int i = 0; i < step; i++) {
            if (isUp) {
                Selenide.$x(".//html[@class='js-focus-visible']").sendKeys(Keys.UP);
            } else {
                Selenide.$x(".//html[@class='js-focus-visible']").sendKeys(Keys.DOWN);
            }
        }
    }

    public void verifyIsVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }
}
