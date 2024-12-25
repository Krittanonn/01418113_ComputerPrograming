package Lib;
import java.lang.Math;

public class Point {
    private double x;
    private double y;
    private static int count = 0;

    public Point(){
        this(0.0,0.0);
    }
    
    public Point(Double x, Double y) {
        this.setX(x);
        this.setY(y);
        Point.increaseCount();
    }
    
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public static int getCount(){
        return Point.count;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public static void setCount(int count){
        Point.count = count;
    }

    public double Distance(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double Distance(double x2, double y2){
        double dx = this.x - x2;
        double dy = this.y - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public double Distance(Point P){
        return Distance(P.getX(),P.getY());
    }

    public static void increaseCount(){
        Point.count++;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
}
