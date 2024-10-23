package ru.navisale.cbtask.ui.constants;

public final class XPathPatterns {
    public static final String CHECK_BOX = ".//div[@class='checkbox-with-icon__text' and text()='%s ']";
    public static final String NAME_PRODUCT = ".//div[@class='group-items__header']//strong[text()='%s']" +
            "//ancestor::div[@class='group-items__header']/following-sibling::div//a[@data-selector='js-title']";
    public static final String SIZE_PRODUCT = ".//div[@class='group-items__header']//strong[text()='%s']" +
            "//ancestor::div[@class='group-items__header']/following-sibling::div//li[starts-with(text(), 'Размер:')]";
    public static final String COLOUR_PRODUCT = ".//div[@class='group-items__header']//strong[text()='%s']" +
            "//ancestor::div[@class='group-items__header']/following-sibling::div//li[starts-with(text(), 'Цвет:')]";
    public static final String PRICE_PRODUCT = ".//div[@class='group-items__header']//strong[text()='%s']" +
            "//ancestor::div[@class='group-items__header']/following-sibling::div//div[contains(@class, 'cart-item-default__price')]";
}
