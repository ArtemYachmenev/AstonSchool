package main.java.task_2;

public class Circle extends Figure{
    private int radius;
    private int area;
    private int perimeter;

    public Circle(String backgroundColor, String borderColor, int radius) {
        super(backgroundColor, borderColor);
        this.radius = radius;
    }

    @Override
    public void calculatingTheArea() {
        area=(int)Math.floor(3.14*Math.pow(radius,2));
    }

    @Override
    public void calculatingThePerimeter() {
        perimeter=(int)Math.floor(2*3.14*radius);
    }

    @Override
    public void getInfo() {
        calculatingTheArea();
        calculatingThePerimeter();
        System.out.println("Круг: периметр "+perimeter+", площадь "+area+", цвет фона "+backgroundColor+", цвет границ "+borderColor);

    }
}
