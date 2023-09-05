//класс работника
package main.java;

public class Employee {
    String lastLame, firstName, patronymic, position, email;
    int phone, salary, age;

    public Employee(String lastLame, String firstName, String patronymic, String position, String email, int phone, int salary, int age) {
        this.lastLame = lastLame;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //переопределяем строковой вывод информации
    @Override
    public String toString(){
        return String.format("Фамилия: %s \t Имя: %s \t Отчество: %s \t Должность: %s \nEmail: %s \t Номер телефона: %d \nЗарплата: %d \t Возраст: %d \n",
                lastLame, firstName, patronymic, position, email, phone, salary, age);}

    // вывод в консоль
    public void printInfoEmployee() {
        System.out.println(this);

    }
}
