package Pages.wildBerries_home;

import Pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


import static common.Config.CORRECT_COMPLETION;
import static common.Config.PRODUCTS_INFO;


public class WildBerriesHomePage extends BasePage {


    public WildBerriesHomePage(WebDriver driver) {
        super(driver);
    }

    //добавляем их в корзину, пусть будет 10ть штук
    //наводимся на карточку, тыкаем добавить в корзину
    public WildBerriesHomePage  addProducts(int count){
        //обнуляем переменуую

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

        String dataXpath;
        int firstIndex;
        int lastIndex;
        WebElement element;
        String productName;
        String sum;

        int allSum=0;

        //если мы задаем количество товаров и их больше чем товаров реальных (взятых)
        //то кол-во товаров равно количеству взятых товаров
        if (count> listProducts.size()){
            count=listProducts.size();
        }
        //перебираем элементы
        for (int i=1;i<=count;i++){
            //выуживаем xpath каждого элемента
            dataXpath= String.valueOf(listProducts.get(i-1));
            firstIndex=dataXpath.indexOf("/");
            lastIndex=dataXpath.lastIndexOf("]");
            String xpath=dataXpath.substring(firstIndex,lastIndex)+"["+i+"]";
            //добавляем элементы в корзину
            System.out.println(xpath);
            element=driver.findElement(By.xpath(xpath));
            actions.moveToElement(element)
                    .click(driver.findElement(By.xpath(xpath+"//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']"))).build().perform();

            //при добавлении товаров иногда встречаются вещи
            //сделал проверку на всплывающее окно выбора размера
            try {
                driver.findElement(By.xpath("//label[@class='j-quick-order-size-fake sizes-list__button'][1]")).click();
            }
            catch (Exception e){

            }
            System.out.println(driver.findElement(By.xpath(xpath)).getText().trim());
//div[@class='main-page__goods j-main-page-block goods goods--1 j-goods-wrapper  j-goods-wrapper-hits']//div[@class='goods__list']//article[1]
// ins[@class='price__lower-price']
            //выуживаем название товара, его сумму
            productName=driver.findElement(By.xpath(xpath+"// span[@class='product-card__name']")).getText();
            productName=productName.substring(2);
            sum=driver.findElement(By.xpath(xpath+"// ins[@class='price__lower-price']")).getText();
            sum=sum.substring(0,sum.length()-2);

            PRODUCTS_INFO.put(productName,sum);

            //общая сумма
            allSum+=Integer.valueOf(sum);
        }
        //кладем общую сумму и количество товара
        PRODUCTS_INFO.put("allSum", String.valueOf(allSum));
        PRODUCTS_INFO.put("allCount",String.valueOf(listProducts.size()));

        //проверяем есть ли значок добавления в корзину товаров (цифра над корзиной)
        try {
            driver.findElement(By.xpath("//span[@class='navbar-pc__notify']")).isEnabled();
            CORRECT_COMPLETION=true;
        }
        catch (Exception e){

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
