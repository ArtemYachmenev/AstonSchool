package main.java;

public class Main {
    public static void main(String[] args) {

        //создание коробок с фруктами и добавление в нех фруктов
        Box boxApple=new Box(new Apple());
        boxApple.addFruitInBox(new Apple());
        boxApple.addFruitInBox(new Apple());
        boxApple.addFruitInBox(new Apple());

        Box boxApple2=new Box(new Apple());
        boxApple2.addFruitInBox(new Apple());
        boxApple2.addFruitInBox(new Apple());
        boxApple2.addFruitInBox(new Apple());

        Box boxOrange=new Box(new Orange());
        boxOrange.addFruitInBox(new Orange());
        boxOrange.addFruitInBox(new Orange());
        boxOrange.addFruitInBox(new Orange());


        //смотрим массу коробок
        System.out.println("масса коробки с яблоками: "+boxApple.getWeight());
        System.out.println("масса коробки с апельсинами: "+boxOrange.getWeight());

        //сравниваем коробки
        System.out.println("массы коробок одинаковые? boxApple vs boxOrange "+boxApple.compareWeight(boxOrange));
        System.out.println("массы коробок одинаковые? boxApple vs boxApple2 "+boxApple.compareWeight(boxApple2));

        //пересыпаем из одной корзины в другую
        boxApple.shiftingFruits(boxApple2);
        System.out.println("вес коробки из которой пересыпали:"+boxApple.getWeight());
        System.out.println("вес коробки в которую пересыпали:"+boxApple2.getWeight());

        //проверка выкидывания ошибки при пересыпании разных фруктов

        boxApple.shiftingFruits(boxOrange);

        //проверка добавления в коробку не того типа фрукта
        boxApple.addFruitInBox(new Orange());


    }
}