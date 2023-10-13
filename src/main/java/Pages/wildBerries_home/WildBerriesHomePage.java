package Pages.wildBerries_home;

import Pages.BasePage;
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

    private WebDriverWait wait;
    //wait = new WebDriverWait(double, Duration.ofMillis(5000));

    //берем в лист карточки в топе
    List<WebElement> listProducts=driver.findElements(By.xpath("//article[@class='goods__item product-card j-product-item product-card--hoverable']"));




    //добавляем их в корзину, пусть будет 10ть штук
    //наводимся на карточку, тыкаем добавить в корзину
    public void addProducts(int count){
        Actions actions=new Actions(driver);
        for (int i=0;i<count;i++){
            actions.moveToElement(listProducts.get(i)).contextClick((WebElement) By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']"));
        }
    }
    public void goToBasket(){
        By basket=By.xpath("//div[@class='navbar-pc__item j-item-basket']//a");
        WebElement basketEl=driver.findElement(basket);
        basketEl.click();
    }
}
