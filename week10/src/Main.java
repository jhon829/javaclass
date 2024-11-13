
interface Shape2 {
    final double PI = 3.14;
    void draw();
    double getArea();

    default public void redraw() {
        System.out.print("--- 다시 그립니다.\n");
        draw();
    }
}

class Circle implements Shape2 {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}


public class Main {
    public static void main(String[] args) {
        Shape2 donut = new Circle(20);
        donut.redraw();
        System.out.println("면적은 " + donut.getArea());
    }
}
