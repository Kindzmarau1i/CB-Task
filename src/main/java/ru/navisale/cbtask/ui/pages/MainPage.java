package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;

/**
 * Главная страница сервиса
 */
public class MainPage extends AbstractPageObject {

    /**
     * Контекст страницы
     */
    private static final SelenideElement context = Selenide
            .$x(".//main[@class='container page__content']");

    /**
     * Кнопка "Каталог"
     */
    private static final SelenideElement catalogButton = Selenide
            .$x(".//a[contains(@class, 'btn_primary') and @href='/catalog']");

    /**
     * Открыть страницу
     */
    public void open() {
        directOpen("");
        waitForOpened();
    }

    /**
     * Подождать, пока загрузится страница
     */
    @Override
    public void waitForOpened() {
        verifyIsVisible(context);
    }

    /**
     * Нажать на кнопку "Каталог"
     */
    public void clickCatalogButton() {
        catalogButton.shouldBe(Condition.visible).click();
    }
}