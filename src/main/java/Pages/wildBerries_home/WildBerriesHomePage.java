package Pages.wildBerries_home;

import Pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Config.*;


public class WildBerriesHomePage extends BasePage {


    public WildBerriesHomePage(WebDriver driver) {
        super(driver);
    }

    //добавляем их в корзину, пусть будет 10ть штук
    //наводимся на карточку, тыкаем добавить в корзину
    public WildBerriesHomePage addProductsOnMap(int count){
        //обнуляем переменную
        PRODUCTS_INFO.clear();
        //берем в листы карточек

        // почему то выкидывает ошибку ожидания видимости продуктов
       // WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
        //старые строки поиска
        // List<WebElement> listProducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        // (By.xpath("/div[@class='main-page__goods j-main-page-block goods goods--1 j-goods-wrapper  j-goods-wrapper-hits']//div[@class='goods__list']//article\\n"))));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //мотаем страницу вниз для прогрузки большего кол-ва товаров
        Actions goDown=new Actions(driver);
        goDown.scrollByAmount(0,5000).build().perform();

        //раньше были списки лучших товаров, похоже к празднику, по ним все искало но их убрали
        //теперь пытаюсь выбрать карточки с новым интерфейсом вб

        //было
        //List<WebElement> listProducts=driver.findElements(By.xpath("//div[@class='main-page__goods j-main-page-block goods goods--1 j-goods-wrapper  j-goods-wrapper-hits']//div[@class='goods__list']//article\n"));

        List<WebElement> listProducts=
                (driver.findElements(By.xpath("//div[@class='main-page__content']//article")));
        System.out.println(listProducts.size());


        Actions actions=new Actions(driver);

        //объявляем переменные для выцепления данных о товарах и прочих манипуляций
        String dataXpath;
        int firstIndex;
        int lastIndex;
        WebElement element;
        String productName;
        String sum;
        int allSum=0;

        //перебираем элементы
        for (int i=1;i<= count;i++){
            //выуживаем xpath каждого элемента
            dataXpath= String.valueOf(listProducts.get(i-1));
            firstIndex=dataXpath.indexOf("/");
            lastIndex=dataXpath.lastIndexOf("]");
            //старая строка ищущая товары
            //String xpath=dataXpath.substring(firstIndex,lastIndex)+"["+i+"]";
            //новая
            String xpath=dataXpath.substring(firstIndex,lastIndex)+"[@data-index='"+(i-1)+"']";
            //System.out.println(xpath);
            //добавляем элементы в корзину
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

            //выуживаем название товара, его сумму
            productName=driver.findElement(By.xpath(xpath+"// span[@class='product-card__name']")).getText();
            productName=productName.substring(2);

         //   754 ₽ 1 587 ₽  430 ₽ 999 430 ₽
            sum=waitElementIsVisible(driver.findElement(By.xpath(xpath+"// ins[@class='price__lower-price']"))).getText();


            //новое тест по лоупрайсу
            sum=sum.trim();
            firstIndex=sum.indexOf("₽");

            sum=sum.substring(0,firstIndex-1).replace(" ","");
            //System.out.println(sum);

            if (sum.startsWith("o")) {
                sum=sum.substring(2);
            }
            else if (sum.startsWith(" ")){
                sum=sum.substring(1);
            }

            if (!sum.equals(null)||!sum.equals("null")||sum.length()!=0) {
                PRODUCTS_INFO.put(productName, sum);
                //общая сумма
                allSum+=Integer.parseInt(sum);
           }
            else {
                //если цена null то перебираем на товар больше
                count++;
           }


        }

        //перетасовываем то что хранится в массиве чтобы было как в баскете
//        HashMap<String, String> myNewHashMap = new HashMap<>();
//        ArrayList<String> list=new ArrayList<>();
//        for(Map.Entry<String, String> entry : PRODUCTS_INFO.entrySet()){
//           list.add(entry.getKey()+","+entry.getValue());
//        }
//
//        for (int i=list.size()-1;i>=0;i--){
//            lastIndex=list.get(i).lastIndexOf(",");
//            myNewHashMap.put(list.get(i).substring(0,lastIndex-1),list.get(i).substring(lastIndex+1));
//        }
//
//        PRODUCTS_INFO=myNewHashMap;

        //кладем общую сумму и количество товара
        PRODUCTS_INFO.put("allSum", String.valueOf(allSum));
        PRODUCTS_INFO.put("allCount",String.valueOf(count));

        //проверяем есть ли значок добавления в корзину товаров (цифра над корзиной)
        //если да то записываем это (товары добавлены)
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
