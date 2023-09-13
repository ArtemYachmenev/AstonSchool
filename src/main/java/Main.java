package main.java;

public class Main {
    public static void main(String[] args) {

        //счетчик по которому создается двумерный массив
        int count=1;
        int[][] mas=new int[4][4];

        //создаем для примера двумерный массив который потом запишется в файл вместе с заголовком
        //строка двумерного массива
        for(int i = 0; i < mas.length; i++) {
            //столбец двумерного массива
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j]=count;
                count++;
                //выводим массив
                System.out.println(mas[i][j]);
            }
        }
    }
}