package main.java;

import java.util.ArrayList;
import java.util.List;

//я не понял как из этого класса как-нибудь "неявно вытащить" тип дженерика (яблоко или апельсин)
//была мысль его вытащить и сравнить методы красиво с помощью имплементации Comparable
//можно ли это как-нибудь сделать чтобы в будущем еще красивее все оформить?

public class Box <T extends Fruit>  {

    private List<T> list = new ArrayList<>();

    private T type;

    //при создании бокса явно указываем тип фруктов в нем
    public Box(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public List<T> getList() {
        return list;
    }

    //возвращает массу коробки
    public float getWeight() {
        float weight = 0;
        for (T t : list) {
            if (t instanceof Apple) {
                weight += 1.0f;
            } else {
                weight += 1.5f;
            }
        }
        return weight;
    }

    // добавляем в коробку один элемент если добавляемый фрукт и фрукт в коробке разные то выскакивает ошибка
    public void addFruitInBox(T fruit)  {
            if (!compareToTypeFruit(fruit)) {

                System.out.println("Фрукты разные");
            }
            else {
            list.add(0, fruit);
        }
    }

    //сравниваем вес
    public boolean compareWeight(Box box) {
        return getWeight() - box.getWeight() == 0 ? true : false;
    }


    //перекладывание фруктов, если фрукты разные то выкидывается ошибка
    public void shiftingFruits(Box box) {
        if (!compareToTypeBox(box)) {
           System.out.println("Фрукты разные");
            //throw new RuntimeException("Фрукты разные");
        }
        else {
            for (int i = list.size() - 1; i >= 0; i--) {
                box.getList().add(list.get(i));
                list.remove(i);
            }
        }

    }

    //определяем сопоставимы ли коробки чтобы в них перекладывать фрукты
    public boolean compareToTypeBox(Box<T> o) {
        return this.type==o.getType();
    }

    //определяем сопоставимы ли фрукты
    public boolean compareToTypeFruit(T fruit) {
        return this.type.getClass()==fruit.getClass();
    }


}
