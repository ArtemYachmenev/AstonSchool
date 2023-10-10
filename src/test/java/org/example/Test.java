package org.example;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


import static org.junit.jupiter.api.Assertions.*;

public class Test {
    private static WebDriver driver;
    private WebDriverWait wait;

    //перед всеми тестами устанавливаем свойства драйвера
    @BeforeAll
    static void setProperty(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-win64/chromedriver.exe");

    }

    //перед каждым тестом устанавливаем драйвер,
    //разворачиваем окно хрома,
    //переходим на сайт мтс, ставим неявное ожидание на 5 секунд для загрузки страницы
    //находим строки и кнопку продолжить, заполняем поля, жмем на кнопку
    @BeforeEach
    void setActions(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement phone = sourseXpath(driver, "//*[@id=\"connection-phone\"]");
        WebElement summa = sourseXpath(driver, "//*[@id=\"connection-sum\"]");
        WebElement email = sourseXpath(driver, "//*[@id=\"connection-email\"]");
        WebElement nextButton = sourseXpath(driver, textToButton("Продолжить"));
        phone.sendKeys("297777777");
        summa.sendKeys("77");
        email.sendKeys("artem@pricolovich.aston");
        nextButton.click();
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

    //метод вставляет в поиск тега label текст
    private String textToLabel(String s){
        return "//label[text()=".concat("'").concat(s).concat("'").concat("]");
    }

    //берем сумму из всплывшего окна и сравниваем ее с ожидающей суммой
    @org.junit.jupiter.api.Test
    void TextInButtonTest(){
        //переключаемся на всплывшее окно
        WebDriver frame =driver.switchTo().frame(sourseXpath(driver, "//iframe[@class='bepaid-iframe']"));

        //пробовал написать такие строки для явного ожидания появления суммы (что-то вроде этого)
        // WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement summ=(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header__payment']/p"))));
        //выкидавает ошибку:
        // Expected condition failed:
        // waiting for presence of element located by: By.xpath: //div[@class='header__payment'] (tried for 5 second(s) with 500 milliseconds interval)

        //ждем пару секунд
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        //берем элемент с суммой пополнения
        List<WebElement> elementList= frame.findElements(
                By.xpath("//div[@class='header__payment']/p"));

        //сравниваем что ввели и что ожидаем
        assertAll(() -> assertEquals("77.00 BYN", elementList.get(0).getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", elementList.get(1).getText()));

    }

    //сравниваем напдпись на кнопке оплаты во всплывшем окне (что ввели в строки и что ожидаем)
    @org.junit.jupiter.api.Test
    void newFramePayButtonTest(){
        //переключаемся на всплывшее окно
        WebDriver frame=driver.switchTo().frame(sourseXpath(driver, "//iframe[@class='bepaid-iframe']"));

        //ждем
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //явное ожидание почему-то работает 50/50, если подставлять frame вместо драйвера то всегда тест падает
       // WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10000));
       // WebElement payB=(wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-card-page//button[text()=' Оплатить  77.00 BYN ']"))));

        WebElement payB= sourseXpath(frame,"//app-card-page" + textToButton(" Оплатить  77.00 BYN "));
        assertEquals("Оплатить 77.00 BYN", payB.getText());
    }

    //находим поля банковской карты, сравниваем поля в них (которые автоматом выходят) и то мы в них ничего не ввели
    @org.junit.jupiter.api.Test
    void defaultFieldsTest(){
        WebDriver frame=driver.switchTo().frame(sourseXpath(driver,"//iframe[@class='bepaid-iframe']"));

        //ждем
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement card= sourseXpath(frame, textToLabel("Номер карты"));
        WebElement date= sourseXpath(frame, textToLabel("Срок действия"));
        WebElement cvc= sourseXpath(frame, textToLabel("CVC"));
        WebElement holderName= sourseXpath(frame, textToLabel("Имя держателя (как на карте)"));
        assertAll(() -> assertEquals("Номер карты", card.getText()),
                () -> assertEquals("Срок действия", date.getText()),
                () -> assertEquals("CVC", cvc.getText()),
                () -> assertEquals("Имя держателя (как на карте)", holderName.getText()));
    }

    //смотрим что картинки отображаются
    @org.junit.jupiter.api.Test
    void enabledImgTest() {
        WebDriver frame = driver.switchTo().frame(sourseXpath(driver, "//iframe[@class='bepaid-iframe']"));
        //ждем
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait = new WebDriverWait(frame, Duration.ofMillis(5000));
        //выуживаем картинки
        List<WebElement> img = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//app-input//img")));
        assertAll(() -> assertTrue(img.get(0).isDisplayed()),
                () -> assertTrue(img.get(1).isDisplayed()),
                () -> assertTrue(img.get(2).isDisplayed()),
                () -> assertTrue(img.get(3).isDisplayed()),
                () -> assertTrue(img.get(4).isDisplayed()));
    }

    //проверяем надписи в незаполненных полях каждого варианта оплаты услуг (должен быть текст по умолчанию
    @org.junit.jupiter.api.Test
    void emptyFieldsUsligi() {
        //есть ли способ этот метод вывести из под @BeforeEach? В интернете не нашел особо красивых способов
        //тут тоже можно было бы наверно сделать явное ожидание отображения элемента, но как и выше он бы наверно работал 50/50


        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int i = 0;
        while (i < 4) {
            driver.findElement(By.xpath("//button[@class='select__header']")).click();
            //ждем
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 0) {

                //кликаем «Услуги связи»
                driver.findElement(By.xpath("//p[@class='select__option'][text()='Услуги связи']")).click();

                //находим элементы
                WebElement phone = sourseXpath(driver, "//form//input[@id='connection-phone']");
                WebElement sum = sourseXpath(driver, "//form//input[@id='connection-sum']");
                WebElement email = sourseXpath(driver, "//form//input[@id='connection-email']");

                //должны быть дефолтные значения
                assertAll(() -> assertEquals("Номер телефона", phone.getAttribute("placeholder")),
                        () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                        () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));

                //увеличиваем для того чтобы перейти в другой цикл
                i++;

            } else if (i == 1) {

                //кликаем «Домашний интернет»
                driver.findElement(By.xpath("//p[@class='select__option'][text()='Домашний интернет']")).click();

                //находим элементы
                WebElement phoneAbon = sourseXpath(driver, "//form//input[@id='internet-phone']");
                WebElement sum = sourseXpath(driver, "//form//input[@id='internet-sum']");
                WebElement email = sourseXpath(driver, "//form//input[@id='internet-email']");

                //должны быть дефолтные значения
                assertAll(() -> assertEquals("Номер абонента", phoneAbon.getAttribute("placeholder")),
                        () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                        () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));

                //увеличиваем для того чтобы перейти в другой цикл
                i++;
            } else if (i == 2) {

                //кликаем «Рассрочка»
                driver.findElement(By.xpath("//p[@class='select__option'][text()='Рассрочка']")).click();

                //находим элементы
                WebElement number = sourseXpath(driver, "//form//input[@id='score-instalment']");
                WebElement sum = sourseXpath(driver, "//form//input[@id='instalment-sum']");
                WebElement email = sourseXpath(driver, "//form//input[@id='instalment-email']");

                //должны быть дефолтные значения
                assertAll(() -> assertEquals("Номер счета на 44", number.getAttribute("placeholder")),
                        () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                        () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));

                //увеличиваем для того чтобы перейти в другой цикл
                i++;
            } else if (i == 3) {

                //кликаем «Задолженность»
                driver.findElement(By.xpath("//p[@class='select__option'][text()='Задолженность']")).click();

                //находим элементы
                WebElement number = sourseXpath(driver, "//form//input[@id='score-arrears']");
                WebElement sum = sourseXpath(driver, "//form//input[@id='arrears-sum']");
                WebElement email = sourseXpath(driver, "//form//input[@id='arrears-email']");

                //должны быть дефолтные значения
                assertAll(() -> assertEquals("Номер счета на 2073", number.getAttribute("placeholder")),
                        () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                        () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));

                //увеличиваем для того чтобы выйти из цикла
                i++;
            }
        }
    }

}
