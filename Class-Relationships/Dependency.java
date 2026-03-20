
//     public Document(String content){
//         this.content = content;
//     }
//     public String getContent(){
//         return content;
//     }
// }
// class Printer{
//     public void print(Document document){
//         System.out.println("Printing: "+document.getContent());
//     }
// }

// public class Dependency {
//     public static void main(String[] args) {
//         Document doc = new Document("Hello, World!");
//         Printer printer = new Printer();
//         printer.print(doc);
//     }
// }
//---------------------------------------------------------------------------------------------------------

// class NotificationService{
//     private EmailSender sender;
//     public NotificationService(){
//         this.sender = new EmailSender(); //NotificationService class creating its own dependency
//     }
//     public void notifyUser(String message, String recipient){
//         sender.send(message, recipient);
//     }
// }
// class EmailSender{
//     public void send(String message, String recipient){
//         System.out.println("sending to | "+recipient+":"+message);
//     }
// }
// public class Dependency{
//     public static void main(String[] args) {
//         NotificationService ns1 = new NotificationService();
//         ns1.notifyUser("Hello world", "maheshfromcivil@gmail.com");
//     }
// }
//---------------------------------------------------------------------------------------------------------

// class NotificationService{
//     private Sender sender;
//     public NotificationService(Sender sender){
//         this.sender = sender;
//     }
//     public void notifyUser(String message){
//         sender.send(message);
//     } 
// }
// interface Sender{
//     void send(String message);
// }
// class EmailSender implements Sender{
//     public void send(String message){
//         System.out.println("Sending via Email with message : "+message);
//     }
// }
// class SmsSender implements Sender{
//     public void send(String message){
//         System.out.println("Sending via Sms with message : "+message);
//     }
// }
// public class Dependency{
//     public static void main(String[] args) {
//         NotificationService emailNotificationService = new NotificationService(new EmailSender());
//         emailNotificationService.notifyUser("Hare Krishna by email");
//     }
// }
//---------------------------------------------------------------------------------------------------------

class SeatValidator{
    public boolean isAvailable(String eventId, String seatNumber){
        System.out.println("Checking seat "+seatNumber+"for event "+eventId);
        return true;
    }
}
class PaymentProcessor{
    public boolean charge(String email, double amount){
        System.out.println("Charging $"+amount+" to "+email);
        return true;
    }
}
class QRCodeGenerator{
    public String generate(String eventId, String seatNumber){
        String qrCode = "QR-" + eventId + "-" + seatNumber;
        System.out.println("Generated QR code: "+qrCode);
        return qrCode;
    }
}
class EmailService{
    public void sendConfirmation(String email, String qrCode){
        System.out.println("Sending confirmation to "+email+"with code "+qrCode);
    }
}
class TicketBookingService{
    public boolean bookTicket(String eventId, String seatNumber, String email, double amount,
                            SeatValidator validator, PaymentProcessor payment, 
                            QRCodeGenerator qrGenerator, EmailService emailService){
        if(!validator.isAvailable(eventId, seatNumber)){
            System.out.println("Seat not available");
            return false;
        }
        if(!payment.charge(email, amount)){
            System.out.println("Payment failed");
            return false;
        }
        String qrCode = qrGenerator.generate(eventId, seatNumber);
        emailService.sendConfirmation(email, qrCode);
        System.out.println("Booking confirmed!");
        return true;
    }
}
public class Dependency{
    public static void main(String[] args) {
        TicketBookingService bookingService = new TicketBookingService();

        SeatValidator validator = new SeatValidator();
        PaymentProcessor payment = new PaymentProcessor();
        QRCodeGenerator qrGenerator = new QRCodeGenerator();
        EmailService emailServcie = new EmailService();

        bookingService.bookTicket("CONF-2025", "A12", "mahesh@gmail.com", 100, validator, payment, qrGenerator, emailServcie);
    }
}