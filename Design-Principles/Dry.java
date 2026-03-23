
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

public class Dry {
    
}
