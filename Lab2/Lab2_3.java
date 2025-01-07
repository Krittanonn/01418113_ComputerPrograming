import java.util.Scanner;

public class Lab2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String stdId = "";
        float maxscore = 0;

        while (true) {
            System.out.print("Std ID: ");
            String std = sc.nextLine();

            if(std.charAt(0)=='Q'){
                break;
            }

            System.out.print("Score: ");
            float score = sc.nextFloat();
            sc.nextLine();

            if(score>maxscore){
                maxscore = score;
                stdId = std;
            }
        }

        System.out.println("Maximun Score is "+String.format("%.2f", maxscore)+" on "+stdId);
        sc.close();

    }
}
