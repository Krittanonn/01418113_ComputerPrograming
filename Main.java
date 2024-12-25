import Lib.*;

public class Main {
    public static void main(String[] args) {
        Point a = new Point();
        a.setX(20);
        a.setY(50);
        Point b = new Point(30.0, 15.0);
        System.out.println("Point A: " + a.toString());
        System.out.println("Point B: " + b.toString());
        System.out.println("Distance from A to B: " + a.Distance(b));
        System.out.println("Distance from A to (0, 0): " + a.Distance());
        System.out.println("Distance from B to (10, 100): " + b.Distance(10.0, 100.0));
        System.out.println("Total number of Points: " + a.getCount());

        MoveablePoint x = new MoveablePoint(25,60,5);
        System.out.println(x.toString());
        x.Forward();
        System.out.println(x.toString());
        x.Backward();
        System.out.println(x.toString());
    }
}