package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import instructions.Instructions;
import org.junit.jupiter.api.Test;
import postman.RequestEchoPostman;
import postman.ResponseEchoPostman;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static constants.Constants.SITE;

class TestPostman {
    //тесты сделаны по порядку как на
    // https://www.postman.com/postman/workspace/published-postman-templates/documentation/631643-f695cab7-6878-eb55-7943-ad88e1ccfd65?ctx=documentation

   final Instructions instructions=new Instructions();

   //устанавливаем настройку перед всеми тестами
    //устанавливаем сайт и тип ответа
    @BeforeEach
    void setProperty(){
        instructions.setProperty(instructions.requestInstructions(SITE), instructions.responseSpecification());
    }

    //тестируем метод гет
    //передаем /get?foo1=bar1&foo2=bar2, сравниваем элементы foo1 и foo2 со значениями внутри них
    @org.junit.jupiter.api.Test
    void get(){
        given().log().body().when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().all().body("args.foo1",equalTo("bar1")).body("args.foo2",equalTo("bar2"));
    }

    //тестируем метод post
    //отправляем пустой /post, получаем пустой ответ
    @Test
    void post(){
        given().log().body().when().post("/post").then().log().all();
    }

    //тестируем метод post
    //отправляем /post с данными, получаем ответ
    //сравниваем его с bar1 и bar2 которые уже были

    //вообще изначально в классах постмена были объекты obj1 и obj2, но с ними тест не проходил
    //пришлось изменить все на foo1 и foo2. Это особенность json'a?
    @Test
    void dataPost(){
        RequestEchoPostman requestEchoPostman = new RequestEchoPostman("bar1", "bar2");
        ResponseEchoPostman responseEchoPostman = given().body(requestEchoPostman)
                .when().post("/post").then()
                .body("json.foo1", equalTo("bar1"))
                .and().
                body("json.foo2", equalTo("bar2"))
                .extract().
                body().
                jsonPath().getObject("json", ResponseEchoPostman.class);
        Assertions.assertAll(()->
                        Assertions.assertTrue(responseEchoPostman.getFoo1().equals("bar1")),
                ()->
                        Assertions.assertTrue(responseEchoPostman.getFoo2().equals("bar2")));
    }

    //передаем пустой запрос на сервер
    @Test
    void put(){
        given().log().body().when().put("/put").then();
    }

    //обновляем ресурсы на сервере
    @Test
    void patch(){
        given().log().body().when().patch("/patch").then();
    }

    //удаляем ресурсы на сервере
    @Test
    void delete(){
        given().log().body().when().delete("/delete").then();
    }



}