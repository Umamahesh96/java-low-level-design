
// class Car{
//     private String brand;
//     private String model;
//     private int speed;
//     public Car(String brand, String model, int speed){
//         this.brand = brand;
//         this.model = model;
//         this.speed = speed;
//     }
//     public void accelerate(int increment){
//         speed += increment;
//     }
//     public void displayStatus(){
//         System.out.println(brand+" is running at "+speed+"kmph.");
//     }
// }


// public class ClassesAndObjects {
//     public static void main(String[] args) {
//         Car c1 = new Car("Toyota", "Corolla", 80);
//         Car c2 = new Car("Ford", "Mustang", 120);

//         c2.accelerate(15);
//         c2.displayStatus();
//     }
// }
import java.util.*;
class FoodOrder{
    private String orderId;
    private String customerName;
    private List<String> items;
    private double totalAmount;
    private boolean isPlaced;
    public FoodOrder(String orderId, String customerName){
        this.orderId = orderId;
        this.customerName = customerName;
        items = new ArrayList<>();
        totalAmount = 0.0;
        isPlaced = false;
    }
    public void addItem(String name, double price){
        if(isPlaced){
            System.out.println("Cannot modify a placed order");
            return;
        }
        items.add(name);
        totalAmount += price;
    }
    public boolean placeOrder(){
        if(isPlaced || items.isEmpty()){
            return false;
        }
        isPlaced = true;
        return true;
    }
    public int getItemCount(){
        items.size();
        return items.size();
    }
    public void displayOrder(){
        String status = isPlaced ? "PLACED" : "PENDING";
        System.out.println("Order "+orderId+" ("+customerName+") - "+status);
        for(String item : items){
            System.out.println(" - "+item);
        }
        System.out.printf(" Total : $%.2f%n", totalAmount);
    }
}

public class ClassesAndObjects{
    public static void main(String[] args) {
        FoodOrder f1 = new FoodOrder("mah123", "mahesh");
        f1.addItem("Milk", 3.5);
        f1.addItem("Eggs(60)", 25.25);
        f1.addItem("yogurt", 5.65);
        f1.placeOrder();

        FoodOrder f2 = new FoodOrder("ven456", "venkatesh");
        f2.addItem("Chicken", 10.45);
        f2.addItem("Rice", 12.55);

        f1.displayOrder();
        System.out.println();
        f2.displayOrder();

    }
}
