package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.mts.by/");

        //ищем блок пополнения
        WebElement payWrapper=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div"));
        if (payWrapper!=null){
            System.out.println("так так так, блок есть");

            //если блок есть то ищем логотипы
            WebElement img1=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
            WebElement img2=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
            WebElement img3=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
            WebElement img4=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
            WebElement img5=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
            WebElement img6=driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[2]/ul/li[6]/img"));

            if (img1!=null && img2!=null && img3!=null && img4!=null && img5!=null && img6!=null){
                System.out.println("молодчинка, логотипы есть");
            }
            else {
                System.out.println("логотипов нет!!!!!!");
            }

            //вводим число 1-тестируем клик ссылки
            //2-заполняем поля, жмем "Продолжить"
            Scanner scanner=new Scanner(System.in);
            System.out.println("введи 1 - если тестишь ссылку, 2 - заполняешь поля и проверяешь работу кнопки «Продолжить»");
            int s=scanner.nextInt();
            if (s==1) {

                //проверяем ссылку на работоспособность
                WebElement ref = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/a"));

                if (ref != null) {
                    System.out.println("ссылка есть, запускаем");
                    ref.click();
                } else {
                    System.out.println("оп, а ссылочки то нет");
                }
            }

            else if (s==2)  {

               //присваиваем поля
                WebElement nomer = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
                WebElement summa = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
                WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

                //кликаем на кнопку выбора цели платежа и кликаем
                 driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")).click();
                //кликаем «Услуги связи»
                driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[3]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")).click();

                //заносим в строки данные и кликаем
                nomer.sendKeys("297777777");
                summa.sendKeys("777");
                button.click();
                System.out.println("Артем, ты красавчик, а теперь покорми кису");
            }
            else {
                System.out.println("попробуй еще раз");
            }



        }
        else{
            System.out.println("не расстраивайся, блока нет. ты все равно молодец, поработай еще");
        }

    }
}