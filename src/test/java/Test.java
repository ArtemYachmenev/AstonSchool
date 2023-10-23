import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
                    URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
            calculatorDisplay =new MiuiCalculatorDisplay(driver);
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
    @org.junit.jupiter.api.Test
    void plusTest() {

        calculatorDisplay.three();
        calculatorDisplay.plus();
        calculatorDisplay.nine();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 12".equals
                        (driver.findElementByAndroidUIAutomator(calculatorDisplay.getActualResult()))),
                () -> Assertions.assertTrue("3+9".equals(calculatorDisplay.getActualExpression())));

    }

    //вычитание
    @org.junit.jupiter.api.Test
    void minusTest(){
        calculatorDisplay.nine();
        calculatorDisplay.minus();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 6".equals
                        (driver.findElementByAndroidUIAutomator(calculatorDisplay.getActualResult()))),
                () -> Assertions.assertTrue("9-3".equals(calculatorDisplay.getActualExpression())));
    }

    //умножение
    @org.junit.jupiter.api.Test
    void mulTest(){
        calculatorDisplay.nine();
        calculatorDisplay.multiply();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 27".equals
                        (driver.findElementByAndroidUIAutomator(calculatorDisplay.getActualResult()))),
                () -> Assertions.assertTrue("9*3".equals(calculatorDisplay.getActualExpression())));
    }

    //деление
    @org.junit.jupiter.api.Test
    void divTest(){
        calculatorDisplay.nine();
        calculatorDisplay.divide();
        calculatorDisplay.three();
        calculatorDisplay.equally();

        Assertions.assertAll(() -> Assertions.assertTrue("= 3".equals
                        (driver.findElementByAndroidUIAutomator(calculatorDisplay.getActualResult()))),
                () -> Assertions.assertTrue("9÷3".equals(calculatorDisplay.getActualExpression())));
    }
}
