package main.java.task_2;

public abstract class Figure implements PerimeterCalculation,AreaCalculation {

    String backgroundColor;
    String borderColor;

    public Figure(String backgroundColor, String borderColor) {

        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }


    public void getInfo(){}
}
