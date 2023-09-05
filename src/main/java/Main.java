package main.java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1
        System.out.println(firstMethod(2,5));
        //2
        twoMethod(0);
        //3
        System.out.println(threeMethod(5));
        //4
        fourMethod("Купить пиво",5);
        //5
        System.out.println(fifthMethod(2007));
        //6
        sixthMethod();
        //7
        seventhMethod();
        //8
        eighthMethod();
        //9
        ninthMethod();
        //10
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
        return ((((year%400==0) || (year%4==0 && year%100!=0))) ? true : false);
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

        for(int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {


                if ( (i==j ) || (i+j == mas.length-1)){
                    mas[i][j]=1;
                }
                System.out.print(mas[i][j]);
            }
            System.out.println();
        }

    }

    public static int[] tenthMethod(int len, int initialValue){
        int[] mas=new int[len];
        for(int i = 0; i < mas.length; i++) {
            mas[i]=initialValue;
        }
        return mas;
    }
}