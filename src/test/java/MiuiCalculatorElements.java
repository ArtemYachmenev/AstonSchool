import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//элементы калькулятора с которыми работаем
public class MiuiCalculatorElements {
    @FindBy(id = "com.miui.calculator:id/btn_plus_s")
    private AndroidElement plus;
    @FindBy(id = "com.miui.calculator:id/btn_minus_s")
    private AndroidElement minus;
    @FindBy(id = "com.miui.calculator:id/btn_mul_s")
    private AndroidElement multipl;
    @FindBy(id = "com.miui.calculator:id/btn_div_s")
    private AndroidElement divide;
    @FindBy(id = "com.miui.calculator:id/btn_3_s")
    private AndroidElement three;
    @FindBy(id = "com.miui.calculator:id/btn_9_s")
    private AndroidElement nine;
    @FindBy(id = "com.miui.calculator:id/btn_equal_s")
    private AndroidElement equally;
    @FindBy(id = "com.miui.calculator:id/expression")
    private AndroidElement expression;
    @FindBy(id = "com.miui.calculator:id/result")
    private AndroidElement result;
    @FindBy(id = "com.miui.calculator:id/btn_c_s")
    private AndroidElement clear;

    //ждем отображения элемента
    public WebElement waitToVisible(AndroidDriver<AndroidElement> driver, AndroidElement element) {
        return new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(element));
    }

    public AndroidElement getThree() {
        return three;
    }

    public AndroidElement getNine() {
        return nine;
    }

    public AndroidElement getEqually() {
        return equally;
    }

    public AndroidElement getPlus() {
        return plus;
    }

    public AndroidElement getMinus() {
        return minus;
    }

    public AndroidElement getMultipl() {
        return multipl;
    }

    public AndroidElement getDivide() {
        return divide;
    }

    public AndroidElement getClear() {
        return clear;
    }

    public AndroidElement getResult() {
        return result;
    }

    public AndroidElement getExpression() {
        return expression;
    }


}
