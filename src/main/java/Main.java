package main.java;

public class Main {
    public static void main(String[] args) {

         String[] header=new String[2];
         header[0]="value 1";
        header[1]="value 2";
//        header[2]="value 3";
//         int[][] mas=new int[2][2];
        int count=1;
//         for (int i=0;i< mas.length;i++){
//             for (int j=0;j< mas.length;j++){
//                 mas[i][j]=count;
//                 count++;
//                 System.out.print(mas[i][j]);
//             }
//
//         }


        int[][] mas=new int[4][5];
//строка

        for(int i = 0; i < mas.length; i++) {
            //столбец
            for (int j = 0; j < mas.length; j++) {



                mas[i][j]=count;
                count++;
              //  System.out.print(mas[i][j]);
            }
            System.out.println("");
        }
        AppData data=new AppData(header, mas);
       // data.read();
        //System.out.println(data);
        // data.save(data);
        String convertedToString = String.valueOf(data);
        System.out.println(convertedToString.toString());
    }
}