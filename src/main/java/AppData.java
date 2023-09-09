package main.java;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;
    private String path;
  //  private boolean isCreated=false;

    public AppData() {
       // this.isCreated=true;
        createCSV();
    }

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;

        createCSV();
    }

    public void save (AppData data){

        try {
            FileWriter outputFile=new FileWriter(path);
            CSVWriter writer=new CSVWriter(outputFile,';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data1 = new ArrayList<String[]>();
            data1.add(data.getHeader());
            List<String[][]> data2 = new ArrayList<String[][]>();
            data2.add(data.getData());
            writer.writeAll(data1);
            writer.writeAll(data2);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    private String[][] getData() {
        String[][] s=new String[getData().length][getData().length];
        for (int i=0;i<s.length;i++){
            for (int j=0;j<s.length;j++){
                s[i][j]= String.valueOf(data[i][j]);
            }
        }
        return s;
    }
}
