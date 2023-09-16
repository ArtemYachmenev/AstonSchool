package main.java.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Маша-2, Артем-3, Марк-2 раза дублируется
        List<String> listName= Arrays.asList("Маша", "Петя", "Артем", "Коля", "Маша", "Артем", "Артем", "Марк", "Ильдар", "Ваня", "Марк");
        //смотрим уникальные имена и количество их повторений
        FirstMethod(listName);
    }

    public static void FirstMethod(Collection collection){
        Set<String> uniqueName=new HashSet<>(collection);
        System.out.println("уникальные имена: "+uniqueName);
        for (String key: uniqueName){
            System.out.println(key+ ": " + Collections.frequency(collection, key));
        }
    }
}