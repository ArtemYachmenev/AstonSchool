import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //1
        //длина массива (пусть для удобства проверки будет не больше 10 и не меньше 5
        int sizeMas= (int) (Math.random()*((10-5)+1))+5;
        System.out.println(sizeMas);
        //набор случайно сгенерированных чисел, пусть для удобства они будут целочисленными от 0 до 1000
        List<Integer> mas=new ArrayList<>();
        //заполняем массив случайными числами
        for (int i=0;i<sizeMas;i++){
            mas.add((int) (Math.random()*((1000-0)+1))+0);
        }
        //массив который был
        System.out.println(mas);
        // для удобства представлен массив отфильтрованный (только четные числа)
        mas=mas.stream().filter(a->a%2==0).collect(Collectors.toList());
        System.out.println(mas);
        //количество четных чисел
        long count= mas.stream().filter(a->a%2==0).count();
        System.out.println(count);

        //2
        List<String> strings=Arrays.asList("Highload","High", "Load", "Highload");
        //сколько раз объект «High» встречается
        long countHigh= strings.stream().filter(a->a.equals("High")).count();
        System.out.println(countHigh);
        //какой элемент в коллекции находится на первом месте
        System.out.println(strings.stream().findFirst().orElse("0"));
        //вернуть последний элемент
        System.out.println(strings.stream().reduce((a, b) -> b).orElse("0"));

        //3
        List<String> words=Arrays.asList("f10","f15", "f2", "f4", "f4");
        //сортировка в алфавитном порядке
        words=words.stream().sorted().collect(Collectors.toList());
        System.out.println(words);
        //добавление в массив
        String[] masWords= words.toArray(size -> new String[size]);
        System.out.println(Arrays.toString(masWords));

    }
}