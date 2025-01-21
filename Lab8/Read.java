import java.io.*;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input csv file name: ");
        String fileName = scanner.nextLine();
        System.out.print("Please input string: ");
        String searchString = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName + ".csv"))) {
            String line;
            System.out.println("\nResults:");
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
