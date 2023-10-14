package tests.addProductsAndGoToBasket;

import Pages.wildBerries_home.WildBerriesHomePage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import tests.base.BaseTest;

import static common.Config.CORRECT_COMPLETION;
import static constants.Constant.Url.HOME_PAGE;

//сценарий
public class AddProductsAndGoToBasket extends BaseTest {

    @Test
    public void addProductsToBasket(){

        //открываем сайт
        basePage.open(HOME_PAGE);

        //переходим в корзину
        wildBerriesHomePage.addProducts(10);
        Assert.assertEquals(CORRECT_COMPLETION,true);

        //basketPage.checkInfoProducts();
    }
}
