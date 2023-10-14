package tests.base;

import Pages.base.BasePage;
import Pages.basket.BasketPage;
import Pages.wildBerries_home.WildBerriesHomePage;
import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
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
    public void addProductsToBasket(){

        //открываем сайт
        basePage.open(HOME_PAGE);

        //переходим в корзину
        wildBerriesHomePage.addProductsOnMap();
        Assert.assertEquals(CORRECT_COMPLETION,true);

    }

    //зависимый тест от addProductsToBasket
    //переключение на корзину
    //сравнение названий товаров, их количества, цен каждого товара в корзине и общей суммы товаров
    @org.testng.annotations.Test (dependsOnMethods = {"addProductsToBasket"},
    alwaysRun = true)
    public void checkToBasketAndCheckProducts(){
        //открываем корзину
        wildBerriesHomePage.goToBasket();

        String keyBasketProduct;

        basketPage.addBasketProductsOnMap();

        //иногда на главной странице вместо цены товара считывает null
        //подскажите пожалуйста, что можно сделать?
        //пытался считывать ins где цена лежит отдельно, и ставить на паузу/ожидание поток
        //не помогло :/
        //посмотрел прогоны тестов, не считывает конкретные товары типа памперсов, влажных салфеток и тп.

        //пробегаем PRODUCTS_IN_BASKET_INFO сравниваем его с PRODUCTS_INFO
        for (Map.Entry<String, String> set : PRODUCTS_IN_BASKET_INFO.entrySet()) {
            if (PRODUCTS_IN_BASKET_INFO!=null&&PRODUCTS_INFO!=null)
            {
            keyBasketProduct = set.getKey();

                //если названия-ключи равны то сравниваем содержимое (выходи ключ=ключ, значение=значению)
                if (PRODUCTS_IN_BASKET_INFO.get(keyBasketProduct).equals(PRODUCTS_IN_BASKET_INFO.get(keyBasketProduct))){
                    System.out.println(keyBasketProduct+" "+PRODUCTS_INFO.get(keyBasketProduct));
                Assert.assertEquals(PRODUCTS_IN_BASKET_INFO.get(keyBasketProduct), PRODUCTS_INFO.get(keyBasketProduct));
                }
            }


            }
        }
    }


