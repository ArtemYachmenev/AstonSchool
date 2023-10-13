package Pages.basket;

import Pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private final By basket=By.xpath("//div[@class='basket-form__basket-section basket-section']//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item']");

    //метод проверяющий инфу по продуктам
    public BasePage checkInfoProducts(){
        int count=driver.findElements(basket).size();
        Assert.assertEquals(count,10);
        return this;
    }
}
