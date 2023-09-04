public class Main {
    public static void main(String[] args) {
        //1
        printThreeWords();
        System.out.println("");
        //2
        checkSumSign();
        System.out.println("");
        //3
        printColor();
        System.out.println("");
        //4
        compareNumbers();
        System.out.println("");

    }
    public static void printThreeWords(){
        System.out.print("Orange \n"  + "Banana \n" + "Apple \n");
    }

    public static void checkSumSign(){
        int a=1, b=2;
        int sum=a+b;
        if (sum>=0){
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value=5;
        if (value<=0){
            System.out.println("Красный");
        }
        else if (value>0 && value<=100){
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers(){
        int a=0, b=10;
        String comparison= a>=b? "a>=b": "a<b";
        System.out.println(comparison);
    }

}