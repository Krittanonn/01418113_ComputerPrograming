import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Distance(km): ");
        double distance = sc.nextDouble();

        String distanceCost = calculateCost(distance);

        System.out.println("Derivery Fee = " + distanceCost);
    }

    public static String calculateCost(double distance) {
        double freeLimit = 4;
        double belowLimit = 10;
        double aboveLimit = 12;
    
        double distanceCost;
    
        if (distance <= freeLimit) {
            distanceCost = 0;
            return "Free!!!";
        } else if (distance <= 10) {
            distanceCost = (distance - freeLimit) * belowLimit;
        } else {
            distanceCost = (10 - freeLimit) * belowLimit + (distance - 10) * aboveLimit;
        }
    
        return String.format("%.0f THB", distanceCost);
    }
    
}
