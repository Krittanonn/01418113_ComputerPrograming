import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reader {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        Map<String, Item> itemMap = new HashMap<>();

        // อ่านจากไฟล์
        try (BufferedReader br = new BufferedReader(new FileReader("D:/b6621650477/Week13/Week13/src/sell.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t\t");
                if (parts.length == 4) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1].replace("$", ""));
                    int quantity = Integer.parseInt(parts[2]);
                    Item item = new Item(name, price, quantity);
                    items.add(item);
                    itemMap.put(name, item); // เพิ่มสินค้าในแผนที่เพื่อค้นหาได้ง่าย
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // แสดงรายการสินค้าที่มีในไฟล์
        System.out.println("List of Item :");
        for (Item item : items) {
            System.out.println(item);
        }

        // ให้ผู้ใช้เลือกสินค้า
        Scanner sc = new Scanner(System.in);
        System.out.print("Please select ur order to check : ");
        String selectedItemName = sc.nextLine();

        // ตรวจสอบและแสดงยอดขาย
        Item selectedItem = itemMap.get(selectedItemName);
        if (selectedItem != null) {
            System.out.println("Order Select :  " + selectedItemName + ": $" + selectedItem.getTotalPrice());
        } else {
            System.out.println("No orderS " + selectedItemName);
        }

        sc.close();
    }

}
