package main.java.task_2;

public class Main {
    public static void main(String[] args) {
        //класс Figure абстрактный и имплементирует интерфейсы
        //площадь и периметр расчитываются в методах getInfo() (оттуда вызываются их методы)
        //площадь и периметр округляются в пользу большего целочисленного числа (пример 3.8 ->4)
        Circle circle=new Circle("#FFFFFF", "#000000",10);
        Triangle triangle=new Triangle("#000000","#FFFFFF",25,16,15);
        Rectangle rectangle=new Rectangle("#FFFFFF","#FFFFFF",50,100);
        circle.getInfo();
        triangle.getInfo();
        rectangle.getInfo();

    }
}
