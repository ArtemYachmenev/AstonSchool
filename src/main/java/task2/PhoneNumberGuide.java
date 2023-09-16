package main.java.task2;

import java.util.*;

public class PhoneNumberGuide {
    //каждая фамилия хранит список номеров
    private Map <String, List<String>> phoneBook;

    public PhoneNumberGuide() {
        this.phoneBook = new HashMap<>();
    }


    //получаем номера фамилии
    public List<String> get(String surname){
        if(phoneBook.containsKey(surname)){
            return phoneBook.get(surname);
        } else {
            System.out.println("В книге нет номера для "+ surname);
            return new ArrayList<>();
        }
    }

    public void add(String surname, String number){
        //если тел. книга хранит фамилию, то получаем этот номер
        //
        if(phoneBook.containsKey(surname)){
            List<String> numbers = phoneBook.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.println("Номер "+number+" добавлен для "+ surname);
            } else {
                System.out.println("Номер "+number+" уже есть для "+ surname);
            }
        } else {
            phoneBook.put(surname, new ArrayList<>(Arrays.asList(number)));
            System.out.println("Номер "+number+" добавлен для "+ surname);
        }
    }
}
