
// class Product{
//     private String name;
//     private double price;

//     public Product(String name, double price){
//         this.name = name;
//         setPrice(price);
//     }
//     public String getName(){
//         return name;
//     }
//     public double getPrice(){
//         return price;
//     }
//     public void setPrice(double price){
//         if(price < 0){
//             throw new IllegalArgumentException("Price cannot be negative");
//         }
//         this.price = price;
//     }
// }

// Practice : Bank Account
// class BankAccount{
//     private String accountHolder;
//     private double balance;

//     public BankAccount(String accountHolder){
//         this.accountHolder = accountHolder;
//         this.balance = 0;
//     }

//     public void deposit(double amount){
//         if(amount <= 0){
//             throw new IllegalArgumentException("Deposit amount must be positive");
//         }
//         balance += amount;
//     }

//     public void withdraw(double amount){
//         if(amount <= 0){
//             throw new IllegalArgumentException("Withdrawal amount must be positive");
//         }
//         if(amount > balance){
//             throw new IllegalArgumentException("Insufficient funds");
//         }
//         balance -= amount;
//     }

//     public double getBalace(){
//         return balance;
//     }

//     public String getAccountHolder(){
//         return accountHolder;
//     }
// }

//Practice : Payment Proceser
// class PaymentProcesser{
//     private String cardNumber;
//     private double amount;

//     public PaymentProcesser(String cardNumber, double amount){
//         this.cardNumber = cardNumber;
//         this.amount = amount;
//     }

//     private String maskCardNumber(String cardNumber){
//         return "****_****_****_"+cardNumber.substring(cardNumber.length()-4);
//     }

//     public void processPayment(){
//         System.out.println("Processing payment of $"+amount+" for card "+cardNumber);
//     }
// }
// public class Encapsulation{
//     public static void main(String[] args) {
//         PaymentProcesser payment = new PaymentProcesser("1234567812345678", 2500.00);
//         payment.processPayment();
//     }
// }
//----------------------------------------------------------------------------------------------------

// class Product{
//     private String name;
//     private double price;
//     public Product(String name, double price){
//         this.name = name;
//         setPrice(price);
//     }
//     public String getName(){ return name;}
//     public double getprice(){ return price;}
//     public void setPrice(double price){
//         if(price < 0){
//             throw new IllegalArgumentException("Price cannot be negative");
//         }
//         this.price = price;
//     }
// }
//----------------------------------------------------------------------------------------------------

class BankAccount{
    private String accountHolder;
    private double balance;
    public BankAccount(String accountHolder){
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount should be positive");
        }
        balance += amount;
    }
    public void withdraw(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Withdraw amount should be positive");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
}
public class Encapsulation{
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Uma Mahesh");
        acc1.deposit(1000);
        acc1.withdraw(150);
        System.out.println(acc1.getBalance());
    }
}