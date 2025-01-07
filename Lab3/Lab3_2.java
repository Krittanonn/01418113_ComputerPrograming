import java.math.BigInteger;
import java.util.Scanner;

public class Lab3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger sum = BigInteger.ZERO;
        
        for(int i=1;i<=2;i++){
            System.out.print("Input Number"+i+": ");
            String num = sc.nextLine();

            BigInteger number = new BigInteger(num);
            sum = sum.add(number);

        }
        System.out.println("Summation = " + sum);
        sc.close();
    }
}
