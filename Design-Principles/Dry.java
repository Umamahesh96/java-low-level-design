
// class AuthService{
//     public boolean isValidEmail(String email){
//         return email != null && email.contains("@") && email.contains("."); 
//     }
// }
// class PaymentService{
//     public boolean isValidEmail(String email){
//         return email != null && email.contains("@") && email.contains(".");
//     }
// }
// class MessagingService{
//     public boolean isValidEmail(String email){
//         return email != null && email.contains("@") && email.contains(".");
//     }
// }

// //Applying DRY
// class EmailValidator{
//     public static boolean isValid(String email){
//         return email != null &&
//                 email.contains("@") &&
//                 (email.endsWith(".com") || email.endsWith(".org"));
//     }
// }
// public class Dry {
    
// }

// class AuthService{
//     public boolean isValidEmail(String email){
//         return email != null && 
//                 email.contains("@") && 
//                 (email.endsWith(".com") || email.endsWith(".org"));
//     }
// }
// class MessagingService{
//     public boolean isValidEmail(String email){
//         return email != null &&
//                 email.contains("@") &&
//                 (email.endsWith(".com") || email.endsWith(".org"));
//     }
// }

// //Applying DRY
// class EmailValidator{
//     public static boolean isValid(String email){
//         return email != null &&
//                 email.contains("@") &&
//                 (email.endsWith(".com") || email.endsWith(".org"));
//     }
// }
// public class Dry{
//     public static void main(String[] args) {
//         EmailValidator.isValid("maheshfromcivil@gmail.com");
//     }
// }

class Orderservice{
    public void notifyOrderConfirmation(String userId, String orderId){
        //Duplication of message formatting
        String message = "[Order] Hi "+userId+" , your order "+orderId+" has been confirmed.";
        String formatted = message.toUpperCase().substring(0,1) + message.substring(1);
        //Duplication of sending logic
        System.out.println("Connecting to notification API");
        System.out.println("Sending to "+userId+": "+formatted);
        System.out.println("Notification sent successfully");
    }
}
class ShippingService{
    public void notifyOrdeConfirmation(String userId, String orderId){
        String message = "[Order] Hi "+userId+" ,your order "+orderId+" has been confirmed.";
        String formatted = message.toUpperCase().substring(0,1)+message.substring(1);
        
        System.out.println("Connecting to notification API");
        System.out.println("Sending to "+userId+": "+formatted);
        System.out.println("Notification sent successfully");
    }
}

