package tests.addProductsAndGoToBasket;

import Pages.wildBerries_home.WildBerriesHomePage;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Url.HOME_PAGE;

//сценарий
public class AddProductsAndGoToBasket extends BaseTest {

    @Test
    public void addProductsToBasket(){

        //открываем сайт
        basePage.open(HOME_PAGE);

        //переходим в корзину
        wildBerriesHomePage.addProducts(10).goToBasket();
        //basketPage.checkInfoProducts();
    }
}
