package main.java;

public class Main {
    public static void main(String[] args) {

        //создание заголовка с набором столбцов
         String[] header=new String[3];
         header[0]="value 1";
         header[1]="value 2";
         header[2]="value 3";

        //счетчик по которому создается двумерный массив
        int count=1;
        int[][] mas=new int[3][3];

        //создаем для примера двумерный массив который потом запишется в файл вместе с заголовком
        //строка двумерного массива
        for(int i = 0; i < mas.length; i++) {
            //столбец двумерного массива
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j]=count;
                count++;
            }
        }
        //создание класса AppData, сохранение в файл и его чтение
        //файл .csv находится в директории myDir
        AppData data=new AppData(header, mas);
        data.save(data);
        System.out.println("read:");
        data.read();

    }
}