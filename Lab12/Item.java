import java.util.ArrayList;

import java.util.Scanner;


public class Item{

    String name;
    double price;
    int quantity;
    

    public Item(String n, Double p,int q){
        name = n;
        price = p;
        quantity = q;
    }

    public Item(){

    }

    @Override
    public String toString() {
        return name+"\t\t$"+price+"\t\t"+quantity+"\t\t$"+(quantity*price);
    }

    public Double getTotalPrice(){
        return quantity*price;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Item> cart = new ArrayList<>();
        Item c;
        Scanner sc = new Scanner(System.in);
        double totals = 0;
        
        while(true) {
            System.out.print("Enter the name of the item: ");
            String name = sc.nextLine();

            System.out.print("Enter the unit price: ");
            Double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter the quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            cart.add(new Item(name, price, quantity));
            
            System.out.print("Continue shopping (y/n)?: ");
            String check = sc.nextLine();
            if(!check.equalsIgnoreCase("y")){
                break;
            }
            
        }

        System.out.println("\nFinal Shopping Cart totals");
        for(int i = 0 ; i < cart.size() ; i++){
            System.out.println(cart.get(i));
            totals += cart.get(i).getTotalPrice();
        }
        System.out.println("Total $ Amount in Cart : $"+totals);

        

        
    }
}
