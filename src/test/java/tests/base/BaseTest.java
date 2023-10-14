package tests.base;

import Pages.base.BasePage;
import Pages.basket.BasketPage;
import Pages.wildBerries_home.WildBerriesHomePage;
import common.CommonActions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.CORRECT_COMPLETION;
import static common.Config.HOLD_BROWSER_OPEN;
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
    @Test
    public void addProductsToBasket(){

        //открываем сайт
        basePage.open(HOME_PAGE);

        //переходим в корзину
        wildBerriesHomePage.addProducts(10);
        Assert.assertEquals(CORRECT_COMPLETION,true);

        //basketPage.checkInfoProducts();
    }

}
