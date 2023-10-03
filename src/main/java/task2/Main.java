package main.java.task2;

public class Main {
    public static void main(String[] args) {
        PhoneNumberGuide guide=new PhoneNumberGuide();

        //заполняем книгу
        System.out.println("заполняем книгу:");
        guide.add("yachmenev",4444);
        guide.add("yachmenev",9999);
        guide.add("kositsin",2222);
        guide.add("pelmenev",3333);
        guide.add("yachmenev",7777);
        guide.add("pelmenev",6666);
       guide.add("kitov",1111);

        //извлекаем номера
        System.out.println("извлекаем номера:");
        guide.get("yachmenev");
        guide.get("kositsin");
        guide.get("pelmenev");
        guide.get("kitov");

        //записываем уже имеющийся номер
        System.out.println("записываем уже имеющийся номер:");
        guide.add("kitov",1111);

        //если человек отсутствует
        System.out.println("если человек отсутствует");
        guide.get("krotov");
    }
}
