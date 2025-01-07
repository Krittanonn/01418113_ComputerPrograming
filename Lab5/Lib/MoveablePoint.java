package Lib;

public class MoveablePoint extends Point {
    private double speed;
    
    public MoveablePoint() {
        super();
        this.speed = 0;
    }

    public MoveablePoint(double x , double y , double speed) {
        super(x,y);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void Forward() {
        setX(getX()+this.speed);
        setY(getY()+this.speed);
    }

    public void Backward() {
        setX(getX()-this.speed);
        setY(getY()-this.speed);
    }

    public String toString() {
        return "(" + getX() + "," + getY() + "," + this.speed + ")";
    }
}
