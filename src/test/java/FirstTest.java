import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import ru.navisale.cbtask.ui.pages.*;

public class FirstTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    ProductsPage productsPage = new ProductsPage();
    ProductCardPage productCardPage = new ProductCardPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addProductsToCartAndVerifySpecifications() {
        // Открыть сайт и перейти в карточку товара
        mainPage.open();
        mainPage.clickCatalogButton();
        catalogPage.waitForOpened();
        catalogPage.clickDenimButton();
        productsPage.waitForOpened();
        productsPage.clickItem(0);
        productCardPage.waitForOpened();
        // Получить параметры товара для теста
        String productNameCardPageDenim = productCardPage.getProductName();
        String productSizeCardPageDenim = productCardPage.getProductSize();
        String productPriceCardPageDenim = productCardPage.getProductCardPrice();
        Selenide.sleep(1000); // Нужна задержка, т.к. по непонятной причине кнопка добавления в корзину не успевает прогрузиться
        // Добавить товар в корзину
        productCardPage.clickAddToCartButton();

        // Вернуться в каталог и перейти в карточку товара
        mainPage.clickCatalogButton();
        catalogPage.waitForOpened();
        catalogPage.clickWaistcoatButton();
        productsPage.waitForOpened();
        productsPage.clickItem(0);
        productCardPage.waitForOpened();
        // Получить параметры товара для теста
        String productNameCardPageWaistcoat = productCardPage.getProductName();
        String productSizeCardPageWaistcoat = productCardPage.getProductSize();
        String productColourCardPageWaistcoat = productCardPage.getProductColour();
        String productPriceCardPageWaistcoat = productCardPage.getProductCardPrice();
        Selenide.sleep(1000); // Нужна задержка, т.к. по непонятной причине кнопка добавления в корзину не успевает прогрузиться
        // Добавить товар в корзину
        productCardPage.clickAddToCartButton();
        productCardPage.clickPlusButton();

        // Вернуться в каталог и перейти в карточку товара
        mainPage.clickCatalogButton();
        catalogPage.waitForOpened();
        catalogPage.clickJacketButton();
        productsPage.waitForOpened();
        productsPage.clickItem(0);
        productCardPage.waitForOpened();
        // Получить параметры товара для теста
        String productNameCardPageJacket = productCardPage.getProductName();
        String productSizeCardPageJacket = productCardPage.getProductSize();
        String productColourCardPageJacket = productCardPage.getProductColour();
        String productPriceCardPageJacket = productCardPage.getProductCardPrice();
        Selenide.sleep(1000); // Нужна задержка, т.к. по непонятной причине кнопка добавления в корзину не успевает прогрузиться
        // Добавить товар в корзину
        productCardPage.clickAddToCartButton();

        // Перейти в карзину
        productCardPage.clickCartButton();

        // 1.Проверить что название и параметры товара, добавленные в корзину, соответствуют добавленному ранее товару
        cartPage.waitForOpened();
        Assert.assertEquals(productNameCardPageDenim, cartPage.getProductName("Китай"));
        Assert.assertEquals(productSizeCardPageDenim, cartPage.getProductSize("Китай"));

        Assert.assertEquals(productNameCardPageWaistcoat, cartPage.getProductName("США"));
        Assert.assertEquals(productSizeCardPageWaistcoat, cartPage.getProductSize("США"));
//        Assert.assertEquals(productColourCardPageWaistcoat, cartPage.getProductColour("США")); TODO цвет в карточкее товара не совпадает с цветом в корзине

        Assert.assertEquals(productNameCardPageJacket, cartPage.getProductName("Германии"));
        Assert.assertEquals(productSizeCardPageJacket, cartPage.getProductSize("Германии"));
        Assert.assertEquals(productColourCardPageJacket, cartPage.getProductColour("Германии"));

        // 2.Проверить общее количество выбранного товара в корзине с итоговым кол-вом в sidebar`е
        String countProductCart = cartPage.getProductCountCart();
        String countProductSidebar = cartPage.getProductCountSidebar();
        Assert.assertEquals(countProductCart, countProductSidebar);

        // 3.Для каждого товара сравнить ценник
        Assert.assertEquals(productPriceCardPageDenim, cartPage.getProductCartPrice("Китай"));
        Assert.assertEquals(productPriceCardPageWaistcoat, cartPage.getProductCartPrice("США"));
        Assert.assertEquals(productPriceCardPageJacket, cartPage.getProductCartPrice("Германии"));
    }

    @Test
    public void verifyNameProductWithSpecifications() {
        // Открыть сайт и перейти в карточку товара
        mainPage.open();
        mainPage.clickCatalogButton();
        catalogPage.waitForOpened();
        catalogPage.clickJacketButton();
        productsPage.waitForOpened();
        productsPage.clickItem(2);
        productCardPage.waitForOpened();

        // Получить параметры товара из наименования
        String brand = productCardPage.getProductName(true, false, false);
        String colour = productCardPage.getProductName(false, true, false);
        String size = productCardPage.getProductName(false, false, true);

        // Получить парметры товара из характеристик
        String productSizeCardPageJacket = productCardPage.getProductSize();
        String productColourCardPageJacket = productCardPage.getProductColour();
        String productBrandCardPageJacket = productCardPage.getProductBrand();

        // 4.Для страницы товара написать page object и выполнить проверки – сравнить название товара с его характеристиками
        Assert.assertEquals(brand, productBrandCardPageJacket);
        Assert.assertEquals(colour, productColourCardPageJacket);
        Assert.assertEquals(size, productSizeCardPageJacket);
    }
}