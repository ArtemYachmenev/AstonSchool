package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> implements Comparable<Box<T>> {

    private List<T> list=new ArrayList<>();
    private T type;

    public T getType() {
        if (this.getList().get(0) instanceof Apple){
            type= (Apple) type;
        }
        return type;
    }

    public List<T> getList() {
        return list;
    }

    //возвращает массу коробки
    public float getWeight(){
        float weight=0;
        for (T t: list){
            if (t instanceof Apple){
                weight+=1.0f;
            }
            else {
                weight+=1.5f;
            }
        }
        return weight;
    }

    // добавляем в коробку один элемент если добавляемый фрукт и фрукт в коробке разные то выскакивает ошибка
    public void addFruitInBox(T fruit) {
        if (list.size() > 1) {
            if (comparableFruitInBox(fruit)) {
                try {
                    throw new Exception("Фрукты разные");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        list.add(0, fruit);
    }

    //сравниваем вес
    public  boolean compare(Box box){
        return getWeight() - box.getWeight()==0?true:false;
    }


    //определяем сопоставимы ли коробки чтобы в них перекладывать фрукты
    public boolean comparableFruitInBox(Box box) {

//        if (this.list.getClass()==box.getList().getClass()){
//            return true;
//        }
//        return false;
       // return list.get(0).getClass() != box.getList().get(0).getClass();
        return false;
    }

    //определяем сопоставимы ли коробки чтобы в них перекладывать фрукты
    public boolean comparableFruitInBox(Fruit fruit) {
        return list.get(0).getClass() != fruit.getClass();
    }

    //перекладывание фруктов, если фрукты разные то выкидывается ошибка
    public void shiftingFruits(Box box) {
        if (comparableFruitInBox(box)) {
            System.out.println("Фрукты разные");

        }
        for (int i = list.size() - 1; i >= 0; i--) {
            box.getList().add(list.get(i));
            list.remove(i);
        }

    }


    @Override
    public int compareTo(Box<T> o) {
        return this.compareTo(o);
    }
}
