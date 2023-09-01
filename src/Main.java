public class Main {
    public static void main(String[] args) {
        //создание массива и выввод сотрудников старше 40ка
        Employee[] employees=new Employee[5];
        employees[0]=new Employee("sokolnik", "artem", "artemovich","ceo","123@yandex.ru",
                +89120000, 100500, 55);
        employees[1]=new Employee("selov", "ignat", "olegivic","it специалист","222@yandex.ru",
                +89121111, 80000, 25);
        employees[2]=new Employee("borodov", "mark", "petrov","линия поддержки","333@yandex.ru",
                +89123333, 25000, 30);
        employees[3]=new Employee("mazurov", "sasha", "konstantinovich","эникейщик","444@yandex.ru",
                +89124444, 50000, 60);
        employees[4]=new Employee("ivanov", "ivan", "ivanovhich","менеджер","555@yandex.ru",
                +89125555, 40000, 27);
        for (Employee emp:employees){
            if (emp.age>40){
                emp.printInfoEmployee();
            }
        }
    //создание парка и вывод информации
        Park park=new Park("carousel");
        park.createParkInfo();
    }
}