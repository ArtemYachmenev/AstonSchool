package org.example;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


import static org.junit.jupiter.api.Assertions.*;

class Test {

    private static WebDriver driver;

    //перед всеми тестами устанавливаем свойства драйвера
    @BeforeAll
    static void setupAll(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-win64/chromedriver.exe");

    }

    //перед каждым тестом устанавливаем драйвер,
    //разворачиваем окно хрома,
    //переходим на сайт мтс, ставим неявное ожидание на 5 секунд для загрузки страницы
    @BeforeEach
    void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //после каждого теста закрываем драйвер
    @AfterEach
    void closeDriver(){
        driver.quit();
    }

    //метод ищет элемент с помощью xpath
    private WebElement sourseXpath(WebDriver driver, String s){
        return driver.findElement(By.xpath(s));
    }

    //метод вставляет в поиск тега button текст
    private String textToButton(String s) {
        return "//button[text()=".concat("'").concat(s).concat("'").concat("]");
    }

    //проверяем что есть блок
    @org.junit.jupiter.api.Test
    void enabledBlock(){
        WebElement block=sourseXpath(driver,"//div[@class='col-12 col-xl-8']");
        assertEquals(true,block.isEnabled());
    }

    //проверяем наличие логотипов
    @org.junit.jupiter.api.Test
    void enabledImg(){
        //Хотел написать путь //ul[@src='https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']/li/img
        //но он не ищется, можно это как-то исправить или по некотором атрибутам не делается поиск?
        List<WebElement> img=driver.findElements(By.xpath("//section//ul/li/img"));
        assertAll(() -> assertTrue(img.get(0).isDisplayed()), () -> assertTrue(img.get(1).isDisplayed()),
                () -> assertTrue(img.get(2).isDisplayed()), () -> assertTrue(img.get(3).isDisplayed()),
                () -> assertTrue(img.get(4).isDisplayed()), () -> assertTrue(img.get(5).isDisplayed()));
    }

    //проверяем работу ссылки «Подробнее о сервисе»
    @org.junit.jupiter.api.Test
    void clickToLink(){
        //поиск по этому xpath тоже не работает :/
        // //a[@href='https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']
        sourseXpath(driver,"//a[text()='Подробнее о сервисе']").click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    //Заполняем поля и проверяем работу кнопки «Продолжить»
    @org.junit.jupiter.api.Test
    void fullFieldsAndClickButton(){
        WebElement phone = sourseXpath(driver, "//*[@id=\"connection-phone\"]");
        WebElement summa = sourseXpath(driver, "//*[@id=\"connection-sum\"]");
        WebElement email = sourseXpath(driver, "//*[@id=\"connection-email\"]");
        WebElement nextButton = sourseXpath(driver, textToButton("Продолжить"));
        phone.sendKeys("297777777");
        summa.sendKeys("77");
        email.sendKeys("artem@prikolovich.aston");
        nextButton.click();

        //перехватываем всплывшее окно
        WebDriver frame = driver.switchTo().frame(sourseXpath(driver, "//iframe[@class='bepaid-iframe']"));

        //ждем
        // тут вызывал driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // но с ним выкидывает пустое значение суммы где ожидалось полное:
        //Expected :77.00 BYN
        //Actual   :
        // может я что-то не так делаю? подскажите пожалуйста в комментах по задаче
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement text=sourseXpath(frame, "//p[@class='header__payment-amount'][text()=' 77.00 BYN ']");
        assertEquals("77.00 BYN",text.getText().trim());
    }
}