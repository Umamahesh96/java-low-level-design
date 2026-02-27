

// class CheckoutService{
//     private PaymentGateway paymentGateway;
//     public CheckoutService(PaymentGateway paymentGateway){
//         this.paymentGateway = paymentGateway;
//     }
//     public void setPaymentGateway(PaymentGateway paymentGateway){
//         this.paymentGateway = paymentGateway;
//     }
//     public void checkOut(double amount){
//         paymentGateway.initiatePayment(amount);
//     }
// }

// interface PaymentGateway{
//     public void initiatePayment(double amount);
// }
// class StripePay implements PaymentGateway{
//     @Override
//     public void initiatePayment(double amount){
//         System.out.println("Processing payment via Stripe : $"+amount);
//     }
// }
// class RazorPay implements PaymentGateway{
//     @Override
//     public void initiatePayment(double amount){
//         System.out.println("Processing payment via Razor : Rs."+amount);
//     }
// }
// class PayPal implements PaymentGateway{
//     @Override
//     public void initiatePayment(double amount){
//         System.out.println("Processing payment via PayPal : "+amount);
//     }
// }
// public class Interfaces{
//     public static void main(String[] args) {
//         PaymentGateway stripePay = new StripePay();
//         CheckoutService service = new CheckoutService(stripePay);
//         service.checkOut(120.50);

//         PaymentGateway razorPay = new RazorPay();
//         service.setPaymentGateway(razorPay);
//         service.checkOut(150.50);
//     }
// }
//==================================================================================

//Practical Example : Notification Service

class AlertService{
    private NotificationService notifier;

    public AlertService(NotificationService notifier) {
        this.notifier = notifier;
    }

    public void triggerAlert(String recipient, String issue){
        String alertMessage = "ALERT: "+issue;
        notifier.send(recipient, alertMessage);
    }
    
}

interface NotificationService{
    public void send(String recipient, String message);
}

class EmailNotifier implements NotificationService{
    @Override
    public void send(String recipient, String message){
        System.out.println("[Email] To: "+recipient + " | "+message);
    }
}
class SlackNotifier implements NotificationService{
    @Override
    public void send(String recipient, String message){
        System.out.println("[Slack] Channel: "+recipient + " | "+message);
    }
}
class WebhookNotifier implements NotificationService{
    @Override
    public void send(String recipient, String message){
        System.out.println("[Webhook] URL: "+recipient + " | "+message);
    }
}

public class Interfaces{
    public static void main(String[] args) {
        AlertService emailAlerts = new AlertService(new EmailNotifier());
        emailAlerts.triggerAlert("ops@company.com", "CPU usage at 95%");

        AlertService slackAlerts = new AlertService(new SlackNotifier());
        slackAlerts.triggerAlert("#incidents", "Database connection pool exhausted");

        AlertService webhookAlerts = new AlertService(new WebhookNotifier());
        webhookAlerts.triggerAlert("https://hooks.example.com/alerts", "Disk usage at 90%");
    }
}