import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // jaagged Array
        
        int number;
        while (true) {
            try {
                System.out.print("Input number: ");
                number = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        int arr[][] = new int[number][];
        int count = number;
        for(int i=0;i<number;i++){
            arr[i] = new int[count];
            count--;
        }

        int value = 1;
        for(int i=0;i<number;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = value;
                value++;
            }
        }

        for (int i=0;i<number;i++) {
            for (int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //ArrayList
        DataManager dataManager = new DataManager();
        boolean running = true;

        while (running) {
            System.out.println("\n==== MENU ====");
            System.out.println("1) Add Text to back");
            System.out.println("2) Add Text at index");
            System.out.println("3) Edit Text");
            System.out.println("4) Remove Text by index");
            System.out.println("5) Remove Text by value");
            System.out.println("6) Exit");
            System.out.print("Select--> ");

            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.println("== Add Text to back ==");
                        System.out.print("Input text: ");
                        String textToAdd = sc.nextLine();
                        dataManager.addTextToBack(textToAdd);
                        break;

                    case "2":
                        System.out.println("== Add Text at index ==");
                        System.out.print("Input index: ");
                        int indexToAdd = Integer.parseInt(sc.nextLine());
                        System.out.print("Input text: ");
                        String textToAddAtIndex = sc.nextLine();
                        dataManager.addTextAtIndex(indexToAdd, textToAddAtIndex);
                        break;

                    case "3":
                        System.out.println("== Edit Text ==");
                        System.out.print("Input index: ");
                        int indexToEdit = Integer.parseInt(sc.nextLine());
                        System.out.print("Input new text: ");
                        String newText = sc.nextLine();
                        dataManager.editText(indexToEdit, newText);
                        break;

                    case "4":
                        System.out.println("== Remove Text by index ==");
                        System.out.print("Input index: ");
                        int indexToRemove = Integer.parseInt(sc.nextLine());
                        dataManager.removeTextByIndex(indexToRemove);
                        break;

                    case "5":
                        System.out.println("== Remove Text by value ==");
                        System.out.print("Input text: ");
                        String textToRemove = sc.nextLine();
                        dataManager.removeTextByValue(textToRemove);
                        break;

                    case "6":
                        System.out.println("Bye!!!");
                        running = false;
                        break;

                    default:
                        System.out.println("Wrong input!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("java.lang.NumberFormatException: For input string: \"" + e.getMessage() + "\"");
                dataManager.printData();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("java.lang.IndexOutOfBoundsException: " + e.getMessage());
                dataManager.printData();
            }
        }

    }
    

}
