import Lib.*;

public class main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        
        System.out.println("Chess Properties:");
        System.out.println("Category: " + chess.getCategory());
        System.out.println("Minimum Age: " + chess.getMinAge());
        System.out.println("Height: " + chess.getHeight());
        System.out.println("Width: " + chess.getWidth());
        System.out.println("Area: " + chess.calculateArea());
        System.out.println("Circumference: " + chess.calculateCircumference());
        
        chess.play();
    }
}
