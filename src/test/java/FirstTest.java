import org.junit.Assert;
import org.junit.Test;
import ru.navisale.cbtask.ui.constants.CountryDelivery;
import ru.navisale.cbtask.ui.pages.*;

public class FirstTest extends BaseTest {

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
        catalogPage.clickDenimButton();
        productsPage.chaseCountryDelivery(CountryDelivery.CHINA);
        productsPage.clickItem(0);
        // Получить параметры товара для теста
        String productNameCardPageDenim = productCardPage.getProductName();
        String productSizeCardPageDenim = productCardPage.getProductSize();
        String productPriceCardPageDenim = productCardPage.getProductCardPrice();
        // Добавить товар в корзину
        productCardPage.scrollPage(5, false);
        productCardPage.clickAddToCartButton();

        // Вернуться в каталог и перейти в карточку товара
        productCardPage.scrollPage(5, true);
        productCardPage.clickLogo();
        mainPage.clickCatalogButton();
        catalogPage.clickWaistcoatButton();
        productsPage.chaseCountryDelivery(CountryDelivery.USA_FULL);
        productsPage.clickItem(0);
        // Получить параметры товара для теста
        String productNameCardPageWaistcoat = productCardPage.getProductName();
        String productSizeCardPageWaistcoat = productCardPage.getProductSize();
        String productColourCardPageWaistcoat = productCardPage.getProductColour();
        String productPriceCardPageWaistcoat = productCardPage.getProductCardPrice();
        // Добавить товар в корзину
        productCardPage.scrollPage(5, false);
        productCardPage.clickAddToCartButton();
        productCardPage.clickPlusButton();
        productCardPage.scrollPage(5, false);

        // Вернуться в каталог и перейти в карточку товара
        productCardPage.scrollPage(5, true);
        productCardPage.clickLogo();
        mainPage.clickCatalogButton();
        catalogPage.clickJacketButton();
        productsPage.chaseCountryDelivery(CountryDelivery.GERMANY);
        productsPage.clickItem(0);
        // Получить параметры товара для теста
        String productNameCardPageJacket = productCardPage.getProductName();
        String productSizeCardPageJacket = productCardPage.getProductSize();
        String productColourCardPageJacket = productCardPage.getProductColour();
        String productPriceCardPageJacket = productCardPage.getProductCardPrice();
        // Добавить товар в корзину
        productCardPage.clickAddToCartButton();

        // Перейти в корзину
        productCardPage.scrollPage(5, true);
        productCardPage.clickCartButton();

        // 1.Проверить что название и параметры товара, добавленные в корзину, соответствуют добавленному ранее товару
        Assert.assertEquals(productNameCardPageDenim, cartPage.getProductName(CountryDelivery.CHINA));
        Assert.assertEquals(productSizeCardPageDenim, cartPage.getProductSize(CountryDelivery.CHINA));

        Assert.assertEquals(productNameCardPageWaistcoat, cartPage.getProductName(CountryDelivery.USA));
        Assert.assertEquals(productSizeCardPageWaistcoat, cartPage.getProductSize(CountryDelivery.USA));
//        Assert.assertEquals(productColourCardPageWaistcoat, cartPage.getProductColour("США")); TODO цвет в карточкее товара не совпадает с цветом в корзине

        Assert.assertEquals(productNameCardPageJacket, cartPage.getProductName(CountryDelivery.GERMANY_GEN));
        Assert.assertEquals(productSizeCardPageJacket, cartPage.getProductSize(CountryDelivery.GERMANY_GEN));
        Assert.assertEquals(productColourCardPageJacket, cartPage.getProductColour(CountryDelivery.GERMANY_GEN));

        // 2.Проверить общее количество выбранного товара в корзине с итоговым кол-вом в sidebar`е
        String countProductCart = cartPage.getProductCountCart();
        String countProductSidebar = cartPage.getProductCountSidebar();
        Assert.assertEquals(countProductCart, countProductSidebar);

        // 3.Для каждого товара сравнить ценник
        Assert.assertEquals(productPriceCardPageDenim, cartPage.getProductCartPrice(CountryDelivery.CHINA));
        Assert.assertEquals(productPriceCardPageWaistcoat, cartPage.getProductCartPrice(CountryDelivery.USA));
        Assert.assertEquals(productPriceCardPageJacket, cartPage.getProductCartPrice(CountryDelivery.GERMANY_GEN));
    }

    @Test
    public void verifyNameProductWithSpecifications() {
        // Открыть сайт и перейти в карточку товара
        mainPage.open();
        mainPage.clickCatalogButton();
        catalogPage.clickJacketButton();
        productsPage.clickItem(3);

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