package main.java.task_2;

public class Rectangle extends Figure{
    private int a,b;
    private double radius;
    private int area;
    private int perimeter;

    public Rectangle(String backgroundColor, String borderColor, int a, int b) {
        super(backgroundColor, borderColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public void calculatingTheArea(){
        area=(int)Math.floor(a*b);
    }

    @Override
    public void calculatingThePerimeter() {
        perimeter=(int)Math.floor(2*(a+b));

    }

    @Override
    public void getInfo() {
        calculatingTheArea();
        calculatingThePerimeter();
        System.out.println("Прямоугольник: периметр "+perimeter+", площадь "+area+", цвет фона "+backgroundColor+", цвет границ "+borderColor);
    }
}
