
class AuthService{
    public boolean isValidEmail(String email){
        return email != null && email.contains("@") && email.contains("."); 
    }
}
class PaymentService{
    public boolean isValidEmail(String email){
        return email != null && email.contains("@") && email.contains(".");
    }
}
class MessagingService{
    public boolean isValidEmail(String email){
        return email != null && email.contains("@") && email.contains(".");
    }
}

//Applying DRY
class EmailValidator{
    public static boolean isValid(String email){
        return email != null &&
                email.contains("@") &&
                (email.endsWith(".com") || email.endsWith(".org"));
    }
}
public class Dry {
    
}
