import java.util.ArrayList;

public class DataManager {
    private ArrayList<String> data;

    public DataManager() {
        data = new ArrayList<>();
    }

    public void addTextToBack(String text) {
        data.add(text);
        printData();
    }

    public void addTextAtIndex(int index, String text) {
        data.add(index-1, text);
        printData();
    }

    public void editText(int index, String newText) {
        data.set(index, newText);
        printData();
    }

    public void removeTextByIndex(int index) {
        data.remove(index);
        printData();
    }

    public void removeTextByValue(String text) {
        if (data.remove(text)) {
            printData();
        } else {
            System.out.println("Text not found in the list.");
        }
    }

    public void printData() {
        if (data.isEmpty()) {
            System.out.println("Data =");
        } else {
            System.out.print("Data = ");
            for (String text : data) {
                System.out.print(text + " ");
            }
            System.out.println();
        }
    }
}
