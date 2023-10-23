import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

//класс который находит элементы по FindBy по явному ожиданию waitToVisible
//некоторые нажимает, некоторые отдает нам
public class MiuiCalculatorDisplay extends MiuiCalculatorElements {
    private AndroidDriver<AndroidElement> driver;
    private String expr;
    private String exprResourses;

    public MiuiCalculatorDisplay(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver = driver;
    }

    public MiuiCalculatorDisplay three() {
        waitToVisible(driver, getThree()).click();
        return this;
    }

    public MiuiCalculatorDisplay nine() {
        waitToVisible(driver, getNine()).click();
        return this;
    }

    public MiuiCalculatorDisplay equally() {
        waitToVisible(driver, getEqually()).click();
        return this;
    }

    public MiuiCalculatorDisplay multiply() {
        waitToVisible(driver, getMultipl()).click();
        return this;
    }

    public MiuiCalculatorDisplay divide() {
        waitToVisible(driver, getDivide()).click();
        return this;
    }

    public MiuiCalculatorDisplay plus() {
        waitToVisible(driver, getPlus()).click();
        return this;
    }

    public MiuiCalculatorDisplay minus() {
        waitToVisible(driver, getMinus()).click();
        return this;
    }

    public MiuiCalculatorDisplay clear() {
        waitToVisible(driver, getClear()).click();
        return this;
    }

    public String getActualExpression() {
        expr = waitToVisible(driver, getExpression()).getAttribute("content-desc");;
        return expr;
    }

    public String getActualResult() {
        exprResourses = waitToVisible(driver, getResult()).getText();
        return exprResourses;
    }

}
