import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //объявляем positive, k. negative negative и -число, которое передаетчя в метод
    //getFactorial, k и message-присваиват результат в этом методе
   static int positive,k;
   static Object negative, message;
    @BeforeAll
    static void prepareData() {
        positive = 5;
        negative = "dfgdfg";
    }

    //проверяем факториал 5, он равен 120
    //проверяем в мейне что в метод getFactorial передал в переменную к результат 120
    //позитивный тест
    @Test
    void positiveTest() {
        getFactorial(positive);
        assertEquals(120,k);
    }

    //негативный тест
    @Test
    void negativeTest() {
        getFactorial(negative);
        assertEquals("error, no int",message);
    }

    //проверяем что в методе getFactorial результат равен 120
    void getFactorial(Object data) {
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