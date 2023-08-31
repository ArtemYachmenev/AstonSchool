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

    @Override
    public String toString(){
        return String.format("Фамилия: %s \t Имя: %s \t Отчество: %s \t Должность: %s \n Email: %s \t Номер телефона: %d \n Зарплата: %d \t Возраст: %d \n",
                lastLame, firstName, patronymic, position, email, phone, salary, age);}

    // это метод вывода в консоль (как по заданию)
    public void printInfoEmployee() {
        System.out.println(this);

    }
}
