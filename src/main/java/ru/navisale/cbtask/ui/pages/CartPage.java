package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;
import ru.navisale.cbtask.ui.constants.XPathPatterns;

/**
 * Страница "Корзина"
 */
public class CartPage extends AbstractPageObject {

    /**
     * Контекст страницы
     */
    private static final SelenideElement context = Selenide
            .$x(".//div[@class='basket']");

    /**
     * Счетчик товаров в корзине
     */
    private static final SelenideElement productCounterCart = Selenide
            .$x(".//span[@class='js-more']");

    /**
     * Счетчик товаров в sidebar
     */
    private static final SelenideElement productCounterSidebar = Selenide
            .$x(".//div[@class='header__area-user-menu']//span[@data-selector='bage']");

    /**
     * Подождать, пока загрузится страница
     */
    @Override
    public void waitForOpened() {
        verifyIsVisible(context);
    }

    /**
     * Получить общее количество выбранного товара в корзине
     */
    public String getProductCountCart() {
        String[] countProductCartArray = productCounterCart.getText().split(" ");
        return countProductCartArray[0];
    }

    /**
     * Получить итоговое количество товаров в sidebar
     */
    public String getProductCountSidebar() {
        return productCounterSidebar.getText();
    }

    /**
     * Получить наименование товара в зависимости от страны поставщика
     */
    public String getProductName(String country) {
        return Selenide.$x(String.format(XPathPatterns.NAME_PRODUCT, country)).getText();
    }

    /**
     * Получить размер товара
     */
    public String getProductSize(String country) {
        return Selenide.$x(String.format(XPathPatterns.SIZE_PRODUCT, country)).getText().replace("Размер: ", "");
    }

    /**
     * Получить цвет товара
     */
    public String getProductColour(String country) {
        return Selenide.$x(String.format(XPathPatterns.COLOUR_PRODUCT, country)).getText().replace("Цвет: ", "");
    }

    /**
     * Получить ценник товара в корзине
     */
    public String getProductCartPrice(String country) {
        return Selenide.$x(String.format(XPathPatterns.PRICE_PRODUCT, country)).getText();
    }
}