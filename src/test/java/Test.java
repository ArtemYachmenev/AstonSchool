import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Epic("miui calculator")
@Feature("test functions")
class Test {
        static AndroidDriver<AndroidElement> driver=null;
        private static MiuiCalculatorDisplay calculatorDisplay;

    //объявляем драйвер и calculatorDisplay
        @BeforeEach
    public void initialize() {
        DesiredCapabilities capabilities = new
                DesiredCapabilities();

            //пытался изначально использовать google калькулятор, но не понял как можно вытащить верный
            //AndroidMobileCapabilityType.APP_ACTIVITY для него, подскажите пожалуйста, как это можно сделать?
            //в appium нет такого объекта как cal.CalculatorActivity

//        capabilities.setCapability(AndroidMobileCapabilityType
//                .APP_ACTIVITY,"cal.CalculatorActivity");

        try {
            driver = new AndroidDriver<>(new
                    URL("http://127.0.0.1:4723/wd/hub"),DeviceCharacteristics.getAndroidCharacteristics());
            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
            calculatorDisplay =new MiuiCalculatorDisplay(driver);
            calculatorDisplay.clear();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    //закрываем драйвер
    @AfterAll
    public static void quit() {
        driver.quit();
    }

    //сложение
    @Story("plus")
    @org.junit.jupiter.api.Test
    void plusTest() {
        calculatorDisplay.clear();

        calculatorDisplay.three();
        calculatorDisplay.plus();
        calculatorDisplay.nine();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 12".equals
                        (calculatorDisplay.getActualResult())),
                () -> Assertions.assertTrue("3+9".equals(calculatorDisplay.getActualExpression())));

    }

    //вычитание
    @Story("minus")
    @org.junit.jupiter.api.Test
    void minusTest(){
        calculatorDisplay.clear();

        calculatorDisplay.nine();
        calculatorDisplay.minus();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 6".equals
                        (calculatorDisplay.getActualResult())),
                () -> Assertions.assertTrue("9-3".equals(calculatorDisplay.getActualExpression())));
    }

    //умножение
    @Story("multiply")
    @org.junit.jupiter.api.Test
    void mulTest(){
        calculatorDisplay.clear();

        calculatorDisplay.nine();
        calculatorDisplay.multiply();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 27".equals
                       (calculatorDisplay.getActualResult())),
                () -> Assertions.assertTrue("9×3".equals(calculatorDisplay.getActualExpression())));
    }

    //деление
    @Story("division")
    @org.junit.jupiter.api.Test
    void divTest(){
        calculatorDisplay.clear();

        calculatorDisplay.nine();
        calculatorDisplay.divide();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 3".equals
                (calculatorDisplay.getActualResult())),
                () -> Assertions.assertTrue("9÷3".equals(calculatorDisplay.getActualExpression())));
    }
}
