package main.java.task_1;

public class Dog extends Animal{
    private String name;
    private static int countDog=0;


    public Dog(String name) {
        this.name = name;
        countDog++;
    }

    @Override
    public void run(int length) {
        String info = length >= 500 ? ("собака "+name + " не может пробежать 500 метров и более") : ("собака "+name + " пробежал "+length+" м");
        System.out.println(info);
    }

    @Override
    public void swim(int length) {
        String info = length >= 10 ? ("собака "+name + " не может проплыть 10 метров и более") : ("собака "+name + " проплыла "+length+" м");
        System.out.println(info);
    }

    public static int getCountDog() {
        return countDog;
    }
}
