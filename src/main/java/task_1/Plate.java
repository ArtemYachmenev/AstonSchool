package main.java.task_1;

public class Plate {
    private int countFood;

    public Plate(int countFood) {
        this.countFood = countFood;
    }

    public int getCountFood() {
        return countFood;
    }

    public void addFood(int food){
        countFood+=food;
        System.out.println("в тарелку положили "+food+ " еды");
    }
    public void decreaseFood(int food) {
        countFood-=food;
    }
    public void checkFood() {
        System.out.println(countFood);
    }
}
