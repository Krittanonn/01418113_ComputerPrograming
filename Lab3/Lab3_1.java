import java.util.Scanner;

public class Lab3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int Rows = sc.nextInt();
        
        int count = 0, i, j ;
        int s = Rows/2;
        if(Rows%2==0){

        }else{
            for(i=0;i<Rows;i++){
                if(i<s){
                    for(j=0;j<i;j++){
                        System.out.print(" ");
                    }
                    for(j=0;j<i+1;j++){
                        System.out.print("*");
                        count++;
                    }
                    System.out.println();
                }else{
                    for(j=0;j<Rows-i-1;j++){
                        System.out.print(" ");
                    }
                    for(j=0;j<Rows-i;j++){
                        System.out.print("*");
                        count++;
                    }
                    System.out.println();
                }
            } 
        System.out.println("Count of * is "+count);
        }
    }
}
