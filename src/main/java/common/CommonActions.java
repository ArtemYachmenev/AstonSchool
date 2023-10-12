package common;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;


public class CommonActions {
    //создаем драйвер
    public static WebDriver createDriver(){
        WebDriver driver=null;

        //передаем драйвер который мы будем запускать
        switch (PLATFORM_AND_BROWSER){
            //если у нас хром то делаем параметры какой драйвер надо запускать
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-win64/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            default:
                System.out.println("выбери браузер: "+PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
        return driver;

    }
}
