import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class two {

    public static List<Integer> union(List<Integer> list1, List<Integer> list2) {
        Set<Integer> resultSet = new HashSet<>(list1);
        resultSet.addAll(list2);
        return new ArrayList<>(resultSet);
    }

    public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        Set<Integer> resultSet = new HashSet<>(list1);
        resultSet.retainAll(list2);
        return new ArrayList<>(resultSet);
    }

    public static List<Integer> difference(List<Integer> list1, List<Integer> list2) {
        Set<Integer> resultSet = new HashSet<>(list1);
        resultSet.removeAll(list2);
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first line: ");
        String input1 = scanner.nextLine();
        List<Integer> list1 = parseInputToList(input1);

        System.out.print("Enter second line: ");
        String input2 = scanner.nextLine();
        List<Integer> list2 = parseInputToList(input2);

        System.out.print("Enter operation (+ , * , - ): ");
        String operation = scanner.nextLine();

        List<Integer> result = new ArrayList<>();
        switch (operation) {
            case "+":
                result = union(list1, list2);
                break;
            case "*":
                result = intersection(list1, list2);
                break;
            case "-":
                result = difference(list1, list2);
                break;
            default:
                System.out.println("Invalid operation.");
                System.exit(0);
        }

        System.out.println("Result: " + result);
    }

    private static List<Integer> parseInputToList(String input) {
        String[] parts = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (String part : parts) {
            list.add(Integer.parseInt(part.trim()));
        }
        return list;
    }
}
