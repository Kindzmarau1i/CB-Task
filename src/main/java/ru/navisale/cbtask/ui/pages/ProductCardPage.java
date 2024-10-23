package ru.navisale.cbtask.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.navisale.cbtask.ui.AbstractPageObject;

/**
 * Страница "Карточка товара"
 */
public class ProductCardPage extends AbstractPageObject {

    /**
     * Контекст страницы
     */
    private static final SelenideElement context = Selenide
            .$x(".//main[@class='container page__content']");

    /**
     * Лого
     */
    private static final SelenideElement logo = Selenide
            .$x(".//div[@class='header__area-logo']");

    /**
     * Нотификация
     */
    private static final SelenideElement notification = Selenide
            .$x(".//div[@class='notifications__item-area-content']");

    /**
     * Кнопка "Корзина"
     */
    private static final SelenideElement cartButton = Selenide
            .$x(".//a[@data-selector='basket-desktop']");

    /**
     * Ценник
     */
    private static final SelenideElement price = Selenide
            .$x(".//div[@class='price__regular']");

    /**
     * Кнопка "Добавить в корзину"
     */
    private static final SelenideElement addToCartButton = Selenide
            .$x(".//span[text()='Добавить в корзину']/parent::button");

    /**
     * Кнопка "+"
     */
    private static final SelenideElement plus = Selenide
            .$x(".//button[@data-selector='quantity-group-plus']");

    /**
     * Название товара
     */
    private static final SelenideElement productName = Selenide
            .$x(".//h1[@id='name']");

    /**
     * Размер товара
     */
    private static final SelenideElement productSize = Selenide
            .$x(".//span[text()='Размер']/parent::dt/following-sibling::dd");

    /**
     * Цвет товара
     */
    private static final SelenideElement productColour = Selenide
            .$x(".//span[text()='Цвет']/parent::dt/following-sibling::dd");

    /**
     * Бренд товара
     */
    private static final SelenideElement productBrand = Selenide
            .$x(".//span[text()='Бренд']/parent::dt/following-sibling::dd");

    /**
     * Подождать, пока загрузится страница
     */
    @Override
    public void waitForOpened() {
        verifyIsVisible(context);
    }

    /**
     * Нажать на логотип сайта
     */
    public void clickLogo() {
        logo.shouldBe(Condition.visible).click();
    }

    /**
     * Нажать на кнопку "Добавить в корзину"
     */
    public void clickAddToCartButton() {
        addToCartButton.shouldBe(Condition.visible).click();
        notification.shouldBe(Condition.exist);
    }

    /**
     * Нажать на кнопку "+"
     */
    public void clickPlusButton() {
        plus.shouldBe(Condition.visible).click();
    }

    /**
     * Нажать на кнопку "Корзина"
     */
    public void clickCartButton() {
        cartButton.shouldBe(Condition.visible).click();
    }

    /**
     * Получить название товара в карточке товара
     */
    public String getProductName() {
        String[] nameArray = productName.getText().split(" ");
        String name = "";
        for (String s : nameArray) {
            if (s.equals("Цвет:") || s.equals("Размер:")) {
                break;
            }
            name += s + " ";
        }
        return name.strip();
    }

    /**
     * Получить параметры товара из наименования
     */
    public String getProductName(Boolean isBrand, Boolean isColour, Boolean isSize) {
        String[] nameArray = productName.getText().split(" ");
        if (isBrand) {
            for (String s : nameArray) {
                return s;
            }
        } else if (isColour) {
            for (int i = 0; i < nameArray.length; i++) {
                if (nameArray[i].equals("Цвет:")) {
                    return nameArray[i + 1].replace(";", "");
                }
            }
        } else if (isSize) {
            for (int i = 0; i < nameArray.length; i++) {
                if (nameArray[i].equals("Размер:")) {
                    String size = "";
                    for (int k = i+1; k < nameArray.length; k++) {
                        size += nameArray[k] + " ";
                    }
                    return size.strip();
                }
            }
        }
        return null;
    }

    /**
     * Получить размер товара в карточке товара
     */
    public String getProductSize() {
        return productSize.getText();
    }

    /**
     * Получить цвет товара в карточке товара
     */
    public String getProductColour() {
        return productColour.getText();
    }

    /**
     * Получить бренд товара в карточке товара
     */
    public String getProductBrand() {
        return productBrand.getText();
    }

    /**
     * Получить ценник товара в карточке товара
     */
    public String getProductCardPrice() {
        return price.getText();
    }
}