package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;

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
}