package main.java.task_1;

public class Cat extends Animal{


    private String name;
    private static int countCat=0;
    private boolean satiety;
    int foodForSatiety;


    public Cat(String name,int foodForSatiety) {
        this.name = name;
        this.foodForSatiety=foodForSatiety;
        this.satiety=false;
        countCat++;
    }



    @Override
    public void run(int length) {
        String info = length >= 200 ? ("кот "+name + " не может пробежать 200 метров и более") : ("кот "+name + " пробежал "+length+" м");
        System.out.println(info);
    }

    @Override
    public void swim(int length) {
        System.out.println("кот не умеет плавать");
    }

    public static int getCountCat() {
        return countCat;
    }
//int theAmountOfFoodInThePlate
    public void eatFood(Plate p){
        if (p.getCountFood()<=0){
            System.out.println("в тарелке нет еды!!!");
        }
        else {
            if (p.getCountFood()<foodForSatiety){
                System.out.println("коту "+name+ " не хватило еды, дабавляем еду");
                p.addFood(foodForSatiety);
                this.eatFood(p);

            }
            else {
                p.decreaseFood(foodForSatiety);
                satiety=true;

            }
        }

    }

    public boolean getSatiety() {
        return satiety;
    }

    public void satietyInfo(){
       String info= satiety==true?("кот "+name+" cыт"):("кот "+name+" голоден");
        System.out.println(info);
    }

}
