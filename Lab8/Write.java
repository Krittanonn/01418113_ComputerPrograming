import java.io.*;
import java.util.Scanner;

public class Write {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "Text1.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            int index = 1; // เก็บลำดับของชื่อ
            while (true) {
                System.out.print("Please input name: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("Q")) {
                    break;
                }


                bw.write("Name[" + index + "] : " + name);
                bw.newLine();
                index++;
            }
            System.out.println("\nData saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}

//version upgrade
/*public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "Text1.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            int index = getCurrentIndex(fileName); // หาลำดับปัจจุบันจากไฟล์
            while (true) {
                System.out.print("Please input name: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("Q")) {
                    break;
                }

                index++;
                bw.write("Name[" + index + "] : " + name);
                bw.newLine();
            }
            System.out.println("\nData appended to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    private static int getCurrentIndex(String fileName) {
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name[")) {
                    int start = line.indexOf('[') + 1;
                    int end = line.indexOf(']');
                    if (start > 0 && end > start) {
                        String number = line.substring(start, end);
                        try {
                            index = Integer.parseInt(number);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        return index;
    }
}
*/