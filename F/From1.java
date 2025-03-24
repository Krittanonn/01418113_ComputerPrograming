import java.io.*;
import java.util.Scanner;

public class From1 {
    public From1(){
        Scanner input = new Scanner(System.in);
        try {
            File f = new File("File/Text.txt");
            FileWriter fw = new FileWriter(f ,true);
            BufferedWriter bw = new BufferedWriter(fw);

            while (true) {
                int index =1;
                System.out.print( "Please input name : ");
                String name = input.nextLine();

                if (name.equalsIgnoreCase("Q")){
                    break;
                }

                bw.write("Name :" + name);
                bw.newLine();
            }

            bw.close(); fw.close();

            
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }
}

