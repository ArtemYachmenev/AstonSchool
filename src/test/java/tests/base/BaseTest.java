package tests.base;

import Pages.base.BasePage;
import Pages.basket.BasketPage;
import Pages.wildBerries_home.WildBerriesHomePage;
import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Map;

import static common.Config.*;
import static constants.Constant.Url.HOME_PAGE;

public class BaseTest {

    protected WebDriver driver= CommonActions.createDriver();
    protected BasePage basePage=new BasePage(driver);
    protected WildBerriesHomePage wildBerriesHomePage=new WildBerriesHomePage(driver);
    protected BasketPage basketPage=new BasketPage(driver);


    //чистит куки
    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor executor= (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            executor.executeScript("window.sessionStorage.clear()");

        }
    }

    //закрывает браузер
    @AfterSuite(alwaysRun = true)
    void closeDriver(){
        if(HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }

    //добавление товаров в корзину
    @Test (priority = 1)
    public void addProductsToBasketTest(){

        //открываем сайт
        basePage.open(HOME_PAGE);

        //переходим в корзину выбираем 7 вещей
        wildBerriesHomePage.addProductsOnMap(7);
        Assert.assertEquals(CORRECT_COMPLETION,true);

    }

    //зависимый тест от addProductsToBasket
    //переключение на корзину
    //сравнение названий товаров, их количества, цен каждого товара в корзине и общей суммы товаров
    @org.testng.annotations.Test (dependsOnMethods = {"addProductsToBasketTest"},
            alwaysRun = true)
    public void checkToBasketAndCheckProductsTest(){
        //открываем корзину
        wildBerriesHomePage.goToBasket();

        String keyBasketProduct=null;
        String keyProduct;
        basketPage.addBasketProductsOnMap();

        //пробегаем PRODUCTS_IN_BASKET_INFO сравниваем его с PRODUCTS_INFO
                for (Map.Entry<String, String> set : PRODUCTS_IN_BASKET_INFO.entrySet()) {
                    for (Map.Entry<String, String> set2 : PRODUCTS_INFO.entrySet()) {
                        if (PRODUCTS_IN_BASKET_INFO != null && PRODUCTS_INFO != null)
                            keyBasketProduct = set.getKey();
                        keyProduct = set2.getKey();
                        //если названия-ключи равны то сравниваем содержимое (выходи ключ=ключ, значение=значению)
                        if (keyBasketProduct.equals(keyProduct)) {
                            System.out.println(keyBasketProduct + " " + PRODUCTS_IN_BASKET_INFO.get(keyBasketProduct));
                            Assert.assertEquals(PRODUCTS_IN_BASKET_INFO.get(keyBasketProduct), PRODUCTS_INFO.get(keyProduct));
                        }
                    }
                }
    }
}


