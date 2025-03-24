import java.io.*;
import java.util.*;


public class From3 {
    public From3(){
        Scanner input = new Scanner(System.in);
        
        try {
            File f = new  File("File/focus.txt");
           FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
         while (true) {
            System.out.println("Call me : ");
            String name = input.nextLine();
            
            if (name.equalsIgnoreCase("Q")){
                break;
            }

            bw.write("Name : " +name);
            bw.newLine();
           
            }
            bw.close(); fw.close();
            
        } catch (IOException e) {
            System.out.println("IOException");
           
        }

        try {
            File f = new File("File/focus.txt");
            FileReader fr = new FileReader(f);
            BufferedReader fw = new BufferedReader(fr);

            String line;
            while ((line = fw.readLine()) != null ) { 
                    System.out.println(line);

            }

            fw.close(); fr.close();
            
        }catch (FileNotFoundException e) {
            System.out.println("FileNotFound");

        }catch (IOException e) {
            System.out.println("IOException");
        }
        
        }
    }

