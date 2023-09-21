package main.java;

import java.util.*;
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
        System.out.println("массив отфильтрованный (только четные числа): "+mas);
        //количество четных чисел
        long count= mas.stream().filter(a->a%2==0).count();
        System.out.println("количество четных чисел: "+count);

        //2
        List<String> strings=Arrays.asList("Highload","High", "Load", "Highload");
        //сколько раз объект «High» встречается
        long countHigh= strings.stream().filter(a->a.equals("High")).count();
        System.out.println("сколько раз объект «High» встречается: "+countHigh);
        //какой элемент в коллекции находится на первом месте
        System.out.println("какой элемент в коллекции находится на первом месте: "+strings.stream().findFirst().orElse("0"));
        //вернуть последний элемент
        System.out.println("последний элемент: "+strings.stream().reduce((a, b) -> b).orElse("0"));

        //3
        List<String> words=Arrays.asList("f10","f15", "f2", "f4", "f4");
        //сортировка в алфавитном порядке
        words=words.stream().sorted().collect(Collectors.toList());
        System.out.println("отсортированная по строкам коллекция: "+words);
        //добавление в массив
        String[] masWords= words.toArray(size -> new String[size]);
        System.out.println("вложенная в массив коллекция: "+Arrays.toString(masWords));

        //4
        Collection<Student> students=Arrays.asList(new Student("Дмитрий",17, Gender.MAN),
                new Student("Максим",20, Gender.MAN ),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 20, Gender.MAN));
        //средний возраст студентов мужского пола
        double man= students.stream().filter(a-> a.gender.equals(Gender.MAN)).mapToInt(a->a.getAge()).average().getAsDouble();
        System.out.println("Средний возраст мужчин: "+man);
        //Кому из студентов грозит получение повестки
        List<String> name=students.stream().filter(a-> a.getAge()>=18 && a.getAge()<=27 && a.getGender()==Gender.MAN).map(a->a.getName()).collect(Collectors.toList());
        System.out.println("имена призывников: "+name);

        //5
        List<String> passwords=new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("введи пароль: ");
        String pass= in.nextLine();

        while (!pass.isEmpty()){
            System.out.print("введи пароль: ");
            passwords.add(pass);
            pass=in.nextLine();
        }

        List<String> fPass=passwords.stream().filter(a->a.startsWith("f",0)).collect(Collectors.toList());
        System.out.println("пароли начинающиеся на f: "+fPass);




    }


    private static class Student{
        private final String name;
        private final Integer age;
        private final  Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }




        @Override
        public String toString() {
            return "{"+"name='"+ name+'\''+
                    ", age="+age+
                    ", gender="+gender+'}';
        }
        @Override
        public boolean equals(Object o) {
            if (this==o) return true;
            if (!(o instanceof Student)) return false;
            Student student= (Student) o;
            return Objects.equals(name,student.name)&&
                    Objects.equals(name,student.age)&&
                    Objects.equals(name,student.gender);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name,age,gender);
        }
    }

}