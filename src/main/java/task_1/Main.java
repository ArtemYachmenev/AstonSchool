package main.java.task_1;

public class Main {
    public static void main(String[] args) {
        //проверка вывода счетчика животных, кошек и собак
        //Исходя из условия задачи решил что предельные дистанции начинаются с 200, 500, 10
        // (т.е. от 0 до 199, 499 и 9 крайние возможные дистанции для животных которые эни могут преодолеть)
        Animal slon=new Animal();
        Animal belka=new Animal();
        Dog bulldog=new Dog("Гоша");
        Cat siam=new Cat("Маша",50);
        Cat meykun=new Cat("Цири",200);
        Cat asian=new Cat("Геральт",250);
        System.out.println("всего животных: "+Animal.getCountAnimal());
        System.out.println("всего кошек: "+Cat.getCountCat());
        System.out.println("всего собак: "+Dog.getCountDog());

        //проверка методов кошек и собак
        bulldog.run(400);
        bulldog.swim(200);
        siam.run(300);
        siam.swim(0);

        //создание тарелки
        Plate plate=new Plate(200);
        //коты кушают
        //для информации о том что кому-то не хватило еды в методе eatFood и addFood классов Cat и Pale
        //были добавлены дополнительные сообщения для отслеживания состояния количества корма в тарелке и
        //попытки кота поесть. Исходя из задания я решил что после того, как
        //кот который не смог поесть отходит, тарелка засыпается количеством корма для ушедшего кота и кот снова ест

        //в метод eatFood добавлен вызов этого же метода чтобы кот снова поел
        Cat[] cats=new Cat[3];
        cats[0]=siam;
        cats[1]=meykun;
        cats[2]=asian;
        for (Cat cat:cats){
            if (cat.getSatiety()==false){
                cat.eatFood(plate);
            }
            cat.satietyInfo();
        }
    }
}