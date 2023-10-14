package Pages.basket;

import Pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static common.Config.PRODUCTS_INFO;
import static common.Config.PRODUCTS_IN_BASKET_INFO;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    //private final By basket=By.xpath("//div[@class='basket-form__basket-section basket-section']//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item']");


    //метод проверяющий инфу по продуктам
    public BasePage addBasketProductsOnMap(){
        PRODUCTS_IN_BASKET_INFO.clear();
        String dataXpath;
        int firstIndex;
        int lastIndex;
        String productName;
        String sum;
        int allSum=0;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> listOfBasket=driver.findElements(By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item']"));
        //перебираем товары, сравниваем с выбранными товарами
        for (int i=1;i<=listOfBasket.size();i++){

            dataXpath= String.valueOf(listOfBasket.get(i-1));
            firstIndex=dataXpath.indexOf("/");
            lastIndex=dataXpath.lastIndexOf("]");
            String xpath=dataXpath.substring(firstIndex,lastIndex)+"["+i+"]";

            //выуживаем название товара, его сумму
            productName=driver.findElement(By.xpath(xpath+"// span[@class='good-info__good-name']")).getText();
            //System.out.println(productName);
            sum=driver.findElement(By.xpath(xpath+"// div[@class='list-item__price-new']")).getText();
            sum=sum.substring(0,sum.length()-2).replace(" ","");
            //System.out.println(sum);

            PRODUCTS_IN_BASKET_INFO.put(productName,sum);

            //общая сумма
            allSum+=Integer.parseInt (sum);
        }

        //кладем общую сумму и количество товара
        PRODUCTS_IN_BASKET_INFO.put("allSum", String.valueOf(allSum).replace(" ",""));
        PRODUCTS_IN_BASKET_INFO.put("allCount",String.valueOf(listOfBasket.size()));
        return this;
    }
}
