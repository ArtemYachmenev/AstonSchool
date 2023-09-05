package main.java.task_1;

public class Animal {
    private static int countAnimal=0;

    public Animal() {
        this.countAnimal++;
    }

    public void run(int length){

    };
    public void swim(int length){

    };

    public static int getCountAnimal() {
        return countAnimal;
    }
}
