package main.java;

public class Main {
    public static void main(String[] args) {

        //счетчик по которому создается двумерный массив
        int count=1;
        //измените размер массива для проверки на его размер
        Object[][] mas=new Object[4][4];

        //создаем для примера двумерный массив объектов
        //строка двумерного массива
        for(int i = 0; i < mas.length; i++) {
            //столбец двумерного массива
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j]=count;
                count++;
                //выводим массив
                //System.out.println(mas[i][j]);
            }
        }

        //проверка на ошибку в элементе массива, пожалуйста, раскоментируйте чтобы проверить
        //mas[0][1]="1";

        //вызываем метод и ловим исключения
        try {
            firstMethod(mas);
        } catch (MyArraySizeException e) {
            System.out.println("Предупреждение! Размер массива не 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Предупреждение! Ошибка в:"+e.i+"x"+e.j);
        }
    }
    public static void firstMethod(Object[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum=0;
        //если массив не размера 4х4
        if (mas.length!=4||mas[0].length!=4) throw new MyArraySizeException();
        //проход по массиву
        for(int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                //пытаемся преобразовать объект в число
                try {
                    sum+=(int) (mas[i][j]);
                }
                //ловим исключение
                catch (ClassCastException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("sum="+sum);

    }
}