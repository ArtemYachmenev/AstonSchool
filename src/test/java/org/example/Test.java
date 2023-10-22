package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test {
    AndroidDriver<AndroidElement> driver = null;

    @BeforeEach
    public void initialize() {
        DesiredCapabilities capabilities = new
                DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");


        capabilities.setCapability(AndroidMobileCapabilityType
                .APP_PACKAGE, "com.miui.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType
                .APP_ACTIVITY, "cal.CalculatorActivity");

        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new
                    URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    //сложение
    @org.junit.jupiter.api.Test
    void plusTest() {

        driver.findElementById("com.miui.calculator:id/btn_3_s").click();

        driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
        driver.findElementById("com.miui.calculator:id/btn_9_s").click();

        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        assertEquals("= 12", driver.findElementByAndroidUIAutomator("new UiSelector().packageName(\"com.miui.calculator\")." +
                "resourceId(\"com.miui.calculator:id/result\")").getText());


    }

    //вычитание
    @org.junit.jupiter.api.Test
    void minusTest() {
        driver.findElementById("com.miui.calculator:id/btn_3_s").click();

        driver.findElementById("com.miui.calculator:id/btn_minus_s").click();
        driver.findElementById("com.miui.calculator:id/btn_9_s").click();

        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        assertEquals("= -6", driver.findElementByAndroidUIAutomator("new UiSelector().packageName(\"com.miui.calculator\")." +
                "resourceId(\"com.miui.calculator:id/result\")").getText());
    }

    //умножение
    @org.junit.jupiter.api.Test
    void mulTest() {
        driver.findElementById("com.miui.calculator:id/btn_3_s").click();

        driver.findElementById("com.miui.calculator:id/btn_mul_s").click();
        driver.findElementById("com.miui.calculator:id/btn_9_s").click();

        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        assertEquals("= 27", driver.findElementByAndroidUIAutomator("new UiSelector().packageName(\"com.miui.calculator\")." +
                "resourceId(\"com.miui.calculator:id/result\")").getText());
    }

    //деление
    @org.junit.jupiter.api.Test
    void divTest() {
        driver.findElementById("com.miui.calculator:id/btn_9_s").click();
        driver.findElementById("com.miui.calculator:id/btn_div_s").click();
        driver.findElementById("com.miui.calculator:id/btn_3_s").click();

        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        assertEquals("= 3", driver.findElementByAndroidUIAutomator("new UiSelector().packageName(\"com.miui.calculator\")." +
                "resourceId(\"com.miui.calculator:id/result\")").getText());
    }


}
