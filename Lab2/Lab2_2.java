import java.util.Scanner;

public class Lab2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input youe E-maail: ");
        String E_mail = sc.nextLine();

        int i;

        for(i=0;i<=E_mail.length();i++){
            if(E_mail.charAt(i)=='@'){
                break;
            }
        }

        System.out.println(E_mail.substring(i));

    }
}
