import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.ConstructorParameters;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //объясвялем n, k. n-число, которое передаетчя в метод
    //getFactorial, k-присваиват результат в этом методе
   static int n,k;
    @BeforeAll
    static void prepareData() {
        n = 5;
    }

    //проверяем факториал 5, он равен 120
    //проверяем в мейне что в метод getFactorial передал в переменную к результат 120
    @Test
    void main() {
        getFactorial();
        assertEquals(120,k);
    }

    //проверяем что в методе getFactorial результат равен 120
    @Test
    void getFactorial() {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        k=result;
        assertEquals(120,result);
    }
}