package main.java.task_2;

public class Triangle extends Figure{
    private int a,b,c;
    private int area;
    private int perimeter;

    public Triangle(String backgroundColor, String borderColor, int a, int b, int c) {
        super(backgroundColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public void calculatingTheArea() {
        int p=(int)Math.floor((a+b+c)/2);
        area=(int)Math.floor(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

    @Override
    public void calculatingThePerimeter() {
        perimeter=(int)Math.floor((a+b+c));
    }

    @Override
    public void getInfo() {
        calculatingTheArea();
        calculatingThePerimeter();
        System.out.println("Треугольник: периметр "+perimeter+", площадь "+area+", цвет фона "+backgroundColor+", цвет границ "+borderColor);
    }
}
