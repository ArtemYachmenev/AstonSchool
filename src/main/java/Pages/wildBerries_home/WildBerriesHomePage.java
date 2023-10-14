package Pages.wildBerries_home;

import Pages.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WildBerriesHomePage extends BasePage {

    public WildBerriesHomePage(WebDriver driver) {
        super(driver);
    }


    //добавляем их в корзину, пусть будет 10ть штук
    //наводимся на карточку, тыкаем добавить в корзину
    public WildBerriesHomePage  addProducts(int count){
        //берем в листы карточек

        // почему то выкидывает ошибку ожидания видимости продуктов
       // WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
        // List<WebElement> listProducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        // (By.xpath("/div[@class='main-page__goods j-main-page-block goods goods--1 j-goods-wrapper  j-goods-wrapper-hits']//div[@class='goods__list']//article\\n"))));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> listProducts=driver.findElements(By.xpath("//div[@class='main-page__goods j-main-page-block goods goods--1 j-goods-wrapper  j-goods-wrapper-hits']//div[@class='goods__list']//article\n"));
        Actions actions=new Actions(driver);

        //System.out.println(listProducts.size());

        //если мы задаем количество товаров и их больше чем товаров реальных (взятых)
        //то кол-во товаров равно количеству взятых товаров
        if (count> listProducts.size()){
            count=listProducts.size();
        }
        //перебираем элементы
        for (int i=1;i<=count;i++){

            //выуживаем xpath каждого элемента
            String dataXpath= String.valueOf(listProducts.get(i-1));
            int firstIndex=dataXpath.indexOf("/");
            int lastIndex=dataXpath.lastIndexOf("]");
            String xpath=dataXpath.substring(firstIndex,lastIndex)+"["+i+"]";
            //System.out.println(xpath);

            //добавляем элементы в корзину
            WebElement element1=driver.findElement(By.xpath(xpath));
            actions.moveToElement(element1)
                    .click(driver.findElement(By.xpath(xpath+"//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']"))).build().perform();

            //при добавлении товаров иногда встречаются вещи
            //сделал проверку на всплывающее окно выбора размера
            try {
                driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/label")).click();
            }
            catch (Exception e){

            }


        }
        return this;
    }
    //переходим на корзину
    public WildBerriesHomePage goToBasket(){
        By basket=By.xpath("//div[@class='navbar-pc__item j-item-basket']//a");
        WebElement basketEl=driver.findElement(basket);
        waitElementIsVisible(basketEl).click();
        return this;
    }
}
