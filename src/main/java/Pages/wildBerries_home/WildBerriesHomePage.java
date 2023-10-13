package Pages.wildBerries_home;

import Pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WildBerriesHomePage extends BasePage {

    public WildBerriesHomePage(WebDriver driver) {
        super(driver);
    }

    //берем в лист карточки в топе
    private final List<WebElement> listProducts=driver.findElements(By.xpath("//article[@class='goods__item product-card j-product-item product-card--hoverable']"));


    //добавляем их в корзину, пусть будет 10ть штук
    //наводимся на карточку, тыкаем добавить в корзину
    public WildBerriesHomePage  addProducts(int count){
        Actions actions=new Actions(driver);
        for (int i=0;i<count;i++){
            actions.moveToElement(listProducts.get(i)).contextClick((WebElement) By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']"));
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
