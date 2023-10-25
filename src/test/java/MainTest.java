import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    //объявляем positive, k. negative negative и -число, которое передаетчя в метод
    //getFactorial, k и message-присваиват результат в этом методе
    static int positive,k;
    static Object negative, message;

    @BeforeMethod
    public void setUp() {
        positive = 5;
        negative = "dfgdfg";
    }

    //проверяем факториал 5, он равен 120
    //проверяем в мейне что в метод testGetFactorial передал в переменную к результат 120
    //позитивный тест
    @Test
    public void positiveTest() {
        testGetFactorial(positive);
        assertEquals(120,k);
    }

    //негативный тест
    @Test
    void negativeTest() {
        testGetFactorial(negative);
        assertEquals("error, no int",message);
    }

    //проверяем что в методе getFactorial результат равен 120

    public void testGetFactorial(Object data) {
        int result = 1;
        if (!data.getClass().equals(Integer.class)){
            message="error, no int";
        }
        else {
            int count = (Integer) data;
            for (int i = 1; i <= count; i++) {
                result = result * i;
            }
            k = result;
        }
    }
}