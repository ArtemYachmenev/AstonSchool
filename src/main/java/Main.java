package main.java;

public class Main {
    public static void main(String[] args) {

        //создание коробок с фруктами и добавление в нех фруктов
        Box boxApple=new Box();
        boxApple.addFruitInBox(new Apple());
        boxApple.addFruitInBox(new Apple());
        boxApple.addFruitInBox(new Apple());

        Box boxApple2=new Box();
        boxApple2.addFruitInBox(new Apple());
        boxApple2.addFruitInBox(new Apple());
        boxApple2.addFruitInBox(new Apple());

        Box boxOrange=new Box();
        boxOrange.addFruitInBox(new Orange());
        boxOrange.addFruitInBox(new Orange());
        boxOrange.addFruitInBox(new Orange());

        //смотрим массу коробок
        System.out.println("масса коробки с яблоками: "+boxApple.getWeight());
        System.out.println("масса коробки с апельсинами: "+boxOrange.getWeight());

        //сравниваем коробки
        System.out.println("массы коробок одинаковые? "+boxApple.compare(boxOrange));
        System.out.println("массы коробок одинаковые? "+boxApple.compare(boxApple2));

        //пересыпаем из одной корзины в другую
        boxApple.shiftingFruits(boxApple2);
        System.out.println("вес коробки из которой пересыпали:"+boxApple.getWeight());
        System.out.println("вес коробки в которую пересыпали:"+boxApple2.getWeight());

        Apple apple=new Apple();
        System.out.println(apple.getClass());
        System.out.println(boxApple.getList().getClass().getTypeName().toString());
        System.out.println(boxApple.compareTo(boxOrange));
        //проверка выкидывания ошибки при пересыпании разных фруктов
//        try {
//            boxApple.shiftingFruits(boxOrange);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }

        //проверка добавления в коробку не того типа фрукта
//        try {
//            boxApple.addFruitInBox(new Orange());
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
    }
}