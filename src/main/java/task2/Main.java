package main.java.task2;

public class Main {
    public static void main(String[] args) {
        PhoneNumberGuide guide=new PhoneNumberGuide();
        //заполняем книгу
        System.out.println("заполняем книгу:");
        guide.add("yachmenev","4444");
        guide.add("kositsin","2222");
        guide.add("pelmenev","3333");
        guide.add("yachmenev","7777");
        guide.add("pelmenev","6666");
        guide.add("kitov","1111");
        //извлекаем номера
        System.out.println("извлекаем номера:");
        System.out.println("yachmenev "+ guide.get("yachmenev"));
        System.out.println("kositsin "+guide.get("kositsin"));
        System.out.println("pelmenev "+guide.get("pelmenev"));
        System.out.println("kitov "+guide.get("kitov"));
        //записываем уже имеющийся номер
        System.out.println("записываем уже имеющийся номер:");
        guide.add("kitov","1111");
        System.out.println("kitov "+guide.get("kitov"));
        //если человек отсутствует
        System.out.println("krotov"+guide.get("krotov"));
    }
}
