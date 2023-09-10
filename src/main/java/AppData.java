package main.java;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AppData {
    private String[] header;
    private int[][] data;
    //путь к файлу
    private String path;


    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
        //при создании объекта класса автоматически создается директория и файл
        createCSV();

    }


    //для записи в файл csv я использовал библиотеку opencsv
    //она работает с одномерными массивами, необходимо двумерный массив data перевести в одномерный
    public void save (AppData data){
        try {
            //создаем Writer для записи в файл
            //после записи каждому объекту массива если перед ним еще один объект создается ;
            FileWriter outputFile=new FileWriter(path);
            CSVWriter writer=new CSVWriter(outputFile,';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            //создаем коллекции содержащие массивы String
            List<String[]> headerCSV = new ArrayList<String[]>();
            List<String[]> dataCSV = new ArrayList<String[]>();

            //записываем заголовки столбцов в файл
            headerCSV.add(data.getHeader());
            writer.writeAll(headerCSV);

            //с помощью геттера создаем еще один двумерный массив для работы в методе
            int[][] getData=data.getData();

            //создаем коллекцию строк для чтения данных из двумерного массива объекта
            List<String> list = new ArrayList<String>();

            //создаем массив строк со второй длиной двумерного массива в который в дальнейшем будут записываться данные таблицы
            String[] words =new String[getData[0].length];

            //переменная point отслеживает индекс коллекции list
            int point=0;

            //перебираем двумерный массив и записываем данные в коллекцию list
            for (int i=0; i<getData.length;i++){
                for (int j=0; j<getData[i].length;j++){
                    list.add(String.valueOf(getData[i][j]));
                }
            }

            //в цикле заполняем массив words
            //пока i<второй длины двумерного массива, в массив words записываются данные list
            //перебираем индексы коллекции list переменной point
            for (int i=0; i<=getData[0].length-1;i++){
                words[i] = list.get(point);
                point++;

                //если i=длине второй двумерного массива, то добавляем массив в коллецию dataCSV
                //записываем массив, очищаем коллекцию, "обнуляем" счетчик i, пересоздаем массив words
                if (i==getData[0].length-1){
                    dataCSV.add(words);
                    writer.writeAll(dataCSV);
                    dataCSV.clear();
                    i=-1;
                    words =new String[getData[0].length];
                }

                //если переменная хранящая индексы коллекции выходит за пределы этой коллекции, то выходим из метода
                if (point>=list.size()){
                    break;
                }
            }

            //закрываем writer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //читаем файл с помощью BufferedReader
    public void read (){
        try {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            while ((row = csvReader.readLine()) != null) {
                String mas = row;
                    System.out.println(mas);
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //создаем директорию и файл
    private void createCSV(){
        File myDir=new File("myDir");
        myDir.mkdir();
        String path=myDir.getAbsolutePath();
        File csv=new File(path+"/file.csv");
        csv.getParentFile().mkdir();

        try {
            csv.createNewFile();
            this.path=csv.getAbsolutePath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String[] getHeader() {
        return header;
    }

    private int[][] getData() {
        return data;
    }
}
