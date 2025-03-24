import java.io.*;
import java.util.*;

public class From2 {
    public From2(){
        Scanner input = new Scanner(System.in);

        System.out.print("Please input csv file name : ");
        String filename = input.nextLine();
        System.out.print("Please input string : ");
        String name = input.nextLine();

        try {
            File f = new File("File/"+filename+".csv");
            FileReader fr = new FileReader(f);
            BufferedReader fw = new BufferedReader(fr);

            String line;
            while ((line = fw.readLine()) != null ) { 
                if (line.contains(name)) {
                    System.out.println(line);
                }
            }

            fw.close(); fr.close();
            
        }catch (FileNotFoundException e) {
            System.out.println("FileNotFound");

        }catch (IOException e) {
            System.out.println("IOException");
        }
        input.close();
    }
}
