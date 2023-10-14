package common;

import java.util.HashMap;

public class Config {
    public static final String PLATFORM_AND_BROWSER="win_chrome";
    //чистит куки если тру
    public static final Boolean CLEAR_COOKIES_AND_STORAGE=true;

    //если тру закрывает браузер
    public static final Boolean HOLD_BROWSER_OPEN=true;

    //корректное завершение теста добавления в корзину товаров
    public static boolean CORRECT_COMPLETION=false;

    //храним данные для сравнения названия товаров, их количества, цен каждого товара в корзине и общей суммы товаров
    public static HashMap<String,String> PRODUCTS_INFO;
}
