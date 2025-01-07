import java.util.Scanner;

public class Lab1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your number : ");
        long number = sc.nextLong();

        String encoded = encodeNumber(number);
        System.out.println("Your Encryption Code: " + encoded);
    }

    public static String encodeNumber(long number) {
        StringBuilder encodedNumber = new StringBuilder();
        String numberString = String.valueOf(number);

        for (int i = numberString.length() - 1; i >= 0; i--) {
            char digit = numberString.charAt(i);

            if (digit == '0') {
                encodedNumber.append('1');
            } else {
                int digitValue = Character.getNumericValue(digit);

                if (digitValue % 2 == 0) {
                    encodedNumber.append((char) (digitValue + 1 + '0'));
                } else {
                    encodedNumber.append((char) (digitValue - 1 + '0'));
                }
            }
        }

        return encodedNumber.toString();
    }
}
