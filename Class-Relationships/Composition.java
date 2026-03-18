import java.util.*;

class LineItem{
    private String productName;
    private int quantity;
    private double unitPrice;
    public LineItem(String productName, int quantity, double unitPrice){
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public double getSubtotal(){
        return quantity * unitPrice;
    }
    public String getProductName(){
        return productName;
    }
    public void describe(){
        System.out.printf("%s x%d @ $%.2f = $%.2f%n", 
                            productName, quantity, unitPrice, getSubtotal());
    }
}
class Order{
    private String orderId;
    private List<LineItem> lineitems;
    public Order(String orderId){
        this.orderId = orderId;
        this.lineitems = new ArrayList<>();
    }
    public void addItem(String product, int quantity, double unitPrice){
        lineitems.add(new LineItem(product, quantity, unitPrice));
    }
    public void removeItem(String product){
        lineitems.removeIf(item -> item.getProductName().equals(product));
    }
    public double getTotal(){
        double total = 0;
        for(LineItem item : lineitems){
            total += item.getSubtotal();
        }
        return total;
    }
    public void printReceipt(){
        System.out.println("Order: "+orderId);
        for(LineItem item : lineitems){
            item.describe();
        }
        System.out.printf("Total: $%.2f%n", getTotal());
    }
}

public class Composition {
    public static void main(String[] args) {
        Order order1 = new Order("ORD-1001");
        order1.addItem("Wireless Mouse", 1, 29.99);
        order1.addItem("USB-C Cable", 3, 9.99);
        order1.addItem("Laptop Stand", 1, 49.99);
        order1.printReceipt();
    }
}
