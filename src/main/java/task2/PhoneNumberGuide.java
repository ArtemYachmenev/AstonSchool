package main.java.task2;

import java.util.*;

public class PhoneNumberGuide {
    //каждая номер хранит фамилии
    private Map<Integer, String> phoneBook;


    public PhoneNumberGuide() {
        this.phoneBook = new HashMap<>();
    }

    //получаем номера фамилии-всех однофимильцев
    public void get(String surname) {

        boolean exist=false;
        if (!phoneBook.isEmpty()) {
            for (Map.Entry<Integer, String> entry : phoneBook.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();

                if (value.equals(surname)) {
                    System.out.println(value + ": " + key);
                    exist=true;
                }
            }
        }
        if (exist==false){
            System.out.println("В книге нет номера для " + surname);
        }

    }

    public void add(String surname, Integer number) {

        //у однофамильцев свой номер телефона, фамилии не суммируются в один ключ
        // уникальный ключ номер тел., значение фамилия

        if (phoneBook.containsKey(number)) {
            String numbers = phoneBook.get(number);
            if (surname.contains(numbers)) {
                System.out.println("Номер " + number + " уже есть для " + surname);
            } else {
                phoneBook.put(number, surname);
                System.out.println("Номер " + number + " добавлен для " + surname);
            }
        } else {
            phoneBook.put(number, surname);
            System.out.println("Номер " + number + " добавлен для " + surname);
        }
    }
}

