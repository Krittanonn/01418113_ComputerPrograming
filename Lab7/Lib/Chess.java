package Lib;

public class Chess extends Toy implements MyRectangle, MyShape {
    private double height;
    private double width;

    public Chess() {
        super("board game", 7);
        this.height = 100;
        this.width = 80;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculateCircumference() {
        return 2 * (height + width);
    }

    @Override
    public void play() {
        System.out.println("Game Start!!!");
    }
}
