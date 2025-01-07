import java.util.Scanner;

public class Lab2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input String 1: ");
        String str1 = sc.nextLine();
        System.out.print("Input String 2: ");
        String str2 = sc.nextLine();
        
        // System.out.println(str1.equals(str2));
        boolean areEqual = str1.equalsIgnoreCase(str2);
        if(areEqual){
            System.out.println("The two strings are equal.");
        }else {
            System.out.println("The two strings are NOT equal.");
        }
        sc.close();
    }
}
