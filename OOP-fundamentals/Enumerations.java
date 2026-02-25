// Enumeration is a special data type that defines a fixed set of named constants

enum OrderStatus{
    PLACED, CONFIRMED, SHIPPED, DELIVERED, CANCELLED;
}
enum PaymentMethod{
    CREDIT_CARD("Credit Card", 2.5),
    DEBIT_CARD("Debit Card", 1.0),
    UPI("UPI", 0.0),
    NET_BANKING("Net Banking", 1.5);

    private final String displayName;
    private final double feePercent;

    PaymentMethod(String displayName, double feePercent){
        this.displayName = displayName;
        this.feePercent = feePercent;
    }

    public String getDisplayName(){
        return displayName;
    }

    public double getFeePercent(){
        return feePercent;
    }
}
class Order{
    private String orderId;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private double amount;

    public Order(String orderId, PaymentMethod paymentMethod, double amount){
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status.PLACED;
    }

    public boolean advanceStatus(){
        switch(status){
            case PLACED:
                status = status.CONFIRMED;
                return true;
            case CONFIRMED:
                status = status.SHIPPED;
                return true;
            case SHIPPED:
                status = status.DELIVERED;
                return true;
            default:
                return false;
        }
    }

    public boolean cancel(){
        if(status == status.PLACED || status == status.CONFIRMED){
            status = status.CANCELLED;
            return true;
        }
        return false; 
    }

    public double getTotalWithFees(){
        return amount + (amount * paymentMethod.getFeePercent()/100);
    }

    public void displayInfo(){
        System.out.printf("Order %s | Status: %s | Payment: %s | Amount: $%.2f (with fees: $%.2f)%n",
         orderId, status, paymentMethod.getDisplayName(), amount, getTotalWithFees());
    }
}

public class Enumerations{
    public static void main(String[] args) {
        Order o1 = new Order("mah123", PaymentMethod.CREDIT_CARD, 85.85);
    }
} 