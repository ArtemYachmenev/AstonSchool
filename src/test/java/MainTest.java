import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    //объявлялем n, k. n-число, которое передаетчя в метод
    //testGetFactorial, k-присваиват результат в этом методе
    int n,k;
    @BeforeMethod
    public void setUp() {
        n = 5;
    }

    //проверяем факториал 5, он равен 120
    //проверяем в мейне что в метод testGetFactorial передал в переменную к результат 120
    @Test
    public void testMain() {
        testGetFactorial();
        assertEquals(120,k);
    }

    //проверяем что в методе getFactorial результат равен 120
    @Test
    public void testGetFactorial() {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        k=result;
        assertEquals(120,result);
    }
}