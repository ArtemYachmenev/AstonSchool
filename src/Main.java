import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //в данной практике массивы инициализированы в методах
        //1 Написать метод, принимающий на вход два
        // целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
        // (включительно), если да – вернуть true, в противном случае – false.
        System.out.println("");
        System.out.println(firstMethod(2,5));
        //2 Написать метод, которому в качестве параметра передается целое число, метод
        // должен напечатать в консоль, положительное ли число передали или
        // отрицательное. Замечание: ноль считаем положительным числом.
        System.out.println("");
        twoMethod(0);
        //3 Написать метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        System.out.println("");
        System.out.println(threeMethod(5));
        //4 Написать метод, которому в качестве аргументов передается строка и число,
        // метод должен отпечатать в консоль указанную строку, указанное количество раз;
        System.out.println("");
        fourMethod("Купить пиво",5);
        //5 Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("");
        System.out.println(fifthMethod(2007));
        //6 Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("");
        sixthMethod();
        //7 Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        System.out.println("");
        seventhMethod();
        //8 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("");
        eighthMethod();
        //9 Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по
        // следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
        System.out.println("");
        ninthMethod();
        //10 Написать метод, принимающий на вход два аргумента: len и initialValue,
        // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
        System.out.println("");
        System.out.println(Arrays.toString(tenthMethod(5,1)));


    }
    public static boolean firstMethod(int a, int b){

        return ((10<=(a+b)&&(a+b)<=20)?true:false);
    }
    public static void twoMethod(int a){
        System.out.println((a<0) ? "отрицательное" : "положительное");
    }
    public static boolean threeMethod(int a){
        return (a<0)?true:false;
    }
    public static void fourMethod(String s, int count){
        while (count!=0){
            System.out.println(s);
            count--;
        }
    }
    public static boolean fifthMethod(int year) {
        return ((((year%400==0) || (year%4==0 && year%100!=0)) && year>1584) ? true : false);
    }
    public  static void sixthMethod(){
        int[] mas={1,1,1,0,0,0};
        for (int i=0;i<mas.length;i++){
            if (mas[i]==0){
                mas[i]=1;
            }
            else {
                mas[i]=0;
            }
        }
        System.out.println(Arrays.toString(mas));
    }
    public static void seventhMethod(){
        int[] mas=new int[100];
        int count=0;
        while (count!=100){
            mas[count]=count;
            count++;
        }
        System.out.println(Arrays.toString(mas));
    }
    public static void eighthMethod(){
        int[] mas={1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0;i<mas.length;i++){
            if (mas[i]<6){
                mas[i]=mas[i]*2;
            }
        }
        System.out.println(Arrays.toString(mas));
    }

    public static void ninthMethod(){
        int[][] mas=new int[3][3];
        int count = 0;

        for(int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                count++;
                mas[i][j] = count;

                if ( (i==j ) || (i+j == mas.length-1)){
                    mas[i][j]=1;
                }

            }
        }
        String array = Arrays.deepToString(mas).replace("], ", "]\n");

        array = array.replace("[[", "[");
        array = array.replace("]]", "]");

        System.out.println(array);
    }

    public static int[] tenthMethod(int len, int initialValue){
        int[] mas=new int[len];
        for(int i = 0; i < mas.length; i++) {
            mas[i]=initialValue;
        }
        return mas;
    }
}