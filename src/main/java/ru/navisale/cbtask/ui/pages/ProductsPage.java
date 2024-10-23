package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;
import ru.navisale.cbtask.ui.constants.XPathPatterns;

/**
 * Общая старница с товарами для всех типов одежды
 */
public class ProductsPage extends AbstractPageObject {

    /**
     * Контекст страницы
     */
    private static final SelenideElement context = Selenide
            .$x(".//main[@class='container page__content']");

    /**
     * Список карточек товаров
     */
    private static final ElementsCollection items = Selenide
            .$$x(".//div[@class='rubrics-items-grid']/div[@class='product-listing-card']");

    /**
     * Страна поставщика
     */
    private static final SelenideElement countryDelivery = Selenide
            .$x(".//div[text()='Страна поставщика']/following-sibling::button[@data-selector='filter-group:btn-collapse']");

    /**
     * Фильтр
     */
    private static final SelenideElement filter = Selenide
            .$x(".//div[@class='tag-with-button']");

    /**
     * Подождать, пока загрузится страница
     */
    @Override
    public void waitForOpened() {
        verifyIsVisible(context);
    }

    /**
     * Нажать на карточку товара в списке
     */
    public void clickItem(int index) {
        items.get(index).click();
    }

    /**
     * Выбрать страну поставщика
     */
    public void chaseCountryDelivery(String country) {
        countryDelivery.click();
        scrollPage(5, false);
        Selenide.$x(String.format(XPathPatterns.CHECK_BOX, country))
                .shouldBe(Condition.visible).click();
        verifyIsVisible(filter);
    }
}