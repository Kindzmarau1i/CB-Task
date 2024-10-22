package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;

/**
 * Страница "Каталог"
 */
public class CatalogPage extends AbstractPageObject {

    /**
     * Контекст страницы
     */
    private static final SelenideElement context = Selenide
            .$x(".//div[@class='container mega-burger__inner']");

    /**
     * Товар "Джинсы"
     */
    private static final SelenideElement denim = Selenide
            .$x(".//div[contains(@class, 'mega-burger__sub-content_show')]//a[normalize-space()='Джинсы']");

    /**
     * Товар "Жилеты"
     */
    private static final SelenideElement waistcoat = Selenide
            .$x(".//div[contains(@class, 'mega-burger__sub-content_show')]//a[normalize-space()='Жилеты']");

    /**
     * Товар "Пиджаки"
     */
    private static final SelenideElement jacket = Selenide
            .$x(".//div[contains(@class, 'mega-burger__sub-content_show')]//a[normalize-space()='Пиджаки']");

    /**
     * Подождать, пока загрузится страница
     */
    @Override
    public void waitForOpened() {
        verifyIsVisible(context);
    }

    /**
     * Нажать на кнопку "Джинсы"
     */
    public void clickDenimButton() {
        denim.click();
    }

    /**
     * Нажать на кнопку "Жилеты"
     */
    public void clickWaistcoatButton() {
        waistcoat.click();
    }

    /**
     * Нажать на кнопку "Пиджаки"
     */
    public void clickJacketButton() {
        jacket.click();
    }
}