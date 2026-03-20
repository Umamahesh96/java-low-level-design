
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

class NotificationService{
    private Sender sender;
    public NotificationService(Sender sender){
        this.sender = sender;
    }
    public void notifyUser(String message){
        sender.send(message);
    } 
}
interface Sender{
    void send(String message);
}
class EmailSender implements Sender{
    public void send(String message){
        System.out.println("Sending via Email with message : "+message);
    }
}
class SmsSender implements Sender{
    public void send(String message){
        System.out.println("Sending via Sms with message : "+message);
    }
}
public class Dependency{
    public static void main(String[] args) {
        NotificationService emailNotificationService = new NotificationService(new EmailSender());
        emailNotificationService.notifyUser("Hare Krishna by email");
    }
}