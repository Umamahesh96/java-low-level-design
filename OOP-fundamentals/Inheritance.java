
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// class Vehicle{
//     protected String make;
//     protected String model;
//     protected int year;
//     public Vehicle(String make, String model, int year){
//         this.make = make;
//         this.model = model;
//         this.year = year;
//     }
//     public void startEngine(){
//         System.out.println("Engine Started");
//     }
//     public void stopEngine(){
//         System.out.println("Engine stopped");
//     }   
//     public void displayInfo(){
//         System.out.println(year+" "+make+" "+model);
//     }
// }
// class ElectricCar extends Vehicle{
//     private int batteryCapacity;
//     public ElectricCar(String make, String model, int year, int batteryCapacity){
//         super(make, model, year);
//         this.batteryCapacity = batteryCapacity;
//     }
//     public void chargeBattery(){
//         System.out.println("Charging "+batteryCapacity+"kWh battery");
//     }
//     public void startEngine(){

//     }
// }
// class GasCar extends Vehicle{
//     private double fuelTankSize;
//     public GasCar(String make, String model, int year, double fuelTankSize){
//         super(make, model, year);
//         this.fuelTankSize = fuelTankSize;
//     }
//     public void fillTank(){
//         System.out.println("Filling "+fuelTankSize+"L fuel tank");
//     }
//     public void startEngine(){

//     }
// }
// public class Inheritance{
//     public static void main(String[] args) {
//         ElectricCar v1 = new ElectricCar("Tesla", "T150", 2026, 10);
//         v1.chargeBattery();
//     }
// }
//-------------------------------------------------------------------------------------------------

// class Vehicle{
//     protected String make;
//     protected String model;
//     protected int year;
//     public Vehicle(String make, String model, int year){
//         this.make = make;
//         this.model = model;
//         this.year = year;
//     }
//     public void startEngine(){
//         System.out.println("Engine started");
//     }
//     public void stopEngine(){
//         System.out.println("Engine stopped");
//     }
//     public void displayInfo(){
//         System.out.println("Year: "+year+" | make: "+make+" | model: "+model);
//     }
// }
// class ElectricCar extends Vehicle{
//     private int batteryCapacity;
//     public ElectricCar(String make, String model, int year, int batteryCapacity){
//         super(make, model, year);
//         this.batteryCapacity = batteryCapacity;
//     }
//     public void chargeBattery(){
//         System.out.println("Charging "+batteryCapacity+"kWh battery");
//     }
// }
// class GasCar extends Vehicle{
//     private double fuelTankSize;
//     public GasCar(String make, String model, int year, double fuelTankSize){
//         super(make, model, year);
//         this.fuelTankSize = fuelTankSize;
//     }
//     public void fillTank(){
//         System.out.println("Filling "+fuelTankSize+"L fuel tank");
//     }
// }
// public class Inheritance{
//     public static void main(String[] args) {
        
//     }
// }
//-------------------------------------------------------------------------------------------------

class Notification{
    protected String recipient;
    protected String message;
    protected String timestamp;
    public Notification(String recipient, String message){
        this.recipient = recipient;
        this.message = message;
        this.timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String formatHeader(){
        return "["+timestamp+"] To: "+recipient;
    }
    public void send(){
        System.out.println(formatHeader());
        System.out.println("Message: "+message);
    }
}
class EmailNotification extends Notification{
    private String subject;
    public EmailNotification(String recipient, String message, String subject){
        super(recipient, message);
        this.subject = subject;
    }
    @Override
    public void send(){
        System.out.println(formatHeader());
        System.out.println("Subject: "+subject);
        System.out.println("Body: "+message);
        System.out.println("Status: Email delivered");
    }
}
class SMSNotification extends Notification{
    private String phoneNumber;
    private static final int MAX_LENGTH = 160;
    public SMSNotification(String recipient, String message, String phoneNumber){
        super(recipient, message);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void send(){
        System.out.println(formatHeader());
        System.out.println("Phone: "+phoneNumber);
        String smsBody = message.length() > MAX_LENGTH
                ? message.substring(0, MAX_LENGTH - 3) + "...."
                : message;
        System.out.println("SMS: "+smsBody);
        System.out.println("Status: SMS sent ("+smsBody.length()+"/"+MAX_LENGTH+" chars");
    }
}
public class Inheritance{
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification("mahesh@gmail.com", "Your order has been shipped!", "Order Update");
        email.send();
    }
}