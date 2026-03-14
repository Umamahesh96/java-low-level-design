//Compile Time Polymorphism - Method Overloading

// class Calculator {
//     // Two ints
//     int add(int a, int b) {
//         return a + b;
//     }

//     // Two doubles
//     double add(double a, double b) {
//         return a + b;
//     }

//     // Three ints
//     int add(int a, int b, int c) {
//         return a + b + c;
//     }
// }

// public class Polymorphism {
//     public static void main(String[] args) {
//         Calculator calc = new Calculator();
//         System.out.println(calc.add(2, 3));        // Calls add(int, int) -> 5
//         System.out.println(calc.add(2.5, 3.5));    // Calls add(double, double) -> 6.0
//         System.out.println(calc.add(1, 2, 3));     // Calls add(int, int, int) -> 6
//     }
// }
//------------------------------------------------------------------------------------------

//Compile-time Polymorphism(Method Overloading) -> depends before program runs
// class Calculator{
//     int add(int a, int b){return a+b;}
//     double add(double a, double b){return a+b;}
//     int add(int a, int b, int c){return a+b+c;}
// }
// public class Polymorphism{
//     public static void main(String[] args) {
//         Calculator cal = new Calculator();
//         System.out.println(cal.add(2,3));
//         System.out.println(cal.add(2.3,6.4));
//         System.out.println(cal.add(1,2,3));

//     }
// }
//------------------------------------------------------------------------------------------

//Run-Time Polymorphism(Method overriding/dynamic dispatch) -> depends while program runs

import java.util.List;

class Notification{
    protected String recipient;
    protected String message;
    public Notification(String recipient, String message){
        this.recipient = recipient;
        this.message = message;
    }
    public void send(){
        System.out.println("Sending generic notification to "+recipient);
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
        System.out.println("Sending Email to "+recipient+ " | subject: "+subject);
    }
}
class SMSNotification extends Notification{
    private String phoneNumber;
    public SMSNotification(String recipient, String message, String phoneNumber){
        super(recipient, message);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void send(){
        System.out.println("Sending SMS to "+phoneNumber+" | Message: "+message);
    }
}
public class Polymorphism{
    public static void main(String[] args) {
        List<Notification> notifications = List.of(
            new EmailNotification("mahesh@gmail.com", "Completed", "RunTime Polymorphism"),
            new SMSNotification("mahesh", "through SMS", "123456789")
        );
        for(Notification n : notifications){
            n.send();
        }
    }
}
