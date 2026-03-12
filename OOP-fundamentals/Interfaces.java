

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

// class AlertService{
//     private NotificationService notifier;

//     public AlertService(NotificationService notifier) {
//         this.notifier = notifier;
//     }

//     public void triggerAlert(String recipient, String issue){
//         String alertMessage = "ALERT: "+issue;
//         notifier.send(recipient, alertMessage);
//     }
    
// }

// interface NotificationService{
//     public void send(String recipient, String message);
// }

// class EmailNotifier implements NotificationService{
//     @Override
//     public void send(String recipient, String message){
//         System.out.println("[Email] To: "+recipient + " | "+message);
//     }
// }
// class SlackNotifier implements NotificationService{
//     @Override
//     public void send(String recipient, String message){
//         System.out.println("[Slack] Channel: "+recipient + " | "+message);
//     }
// }
// class WebhookNotifier implements NotificationService{
//     @Override
//     public void send(String recipient, String message){
//         System.out.println("[Webhook] URL: "+recipient + " | "+message);
//     }
// }

// public class Interfaces{
//     public static void main(String[] args) {
//         AlertService emailAlerts = new AlertService(new EmailNotifier());
//         emailAlerts.triggerAlert("ops@company.com", "CPU usage at 95%");

//         AlertService slackAlerts = new AlertService(new SlackNotifier());
//         slackAlerts.triggerAlert("#incidents", "Database connection pool exhausted");

//         AlertService webhookAlerts = new AlertService(new WebhookNotifier());
//         webhookAlerts.triggerAlert("https://hooks.example.com/alerts", "Disk usage at 90%");
//     }
// }

//----------------------------------------------------------------------------------------------------------------------------------------

// class CheckoutService{
//     private PaymentGateway paymentGateway;
//     public CheckoutService(PaymentGateway paymentGateway){
//         this.paymentGateway = paymentGateway;
//     }
//     public void setPaymentMethod(PaymentGateway paymentGateway){
//         this.paymentGateway = paymentGateway;
//     }
//     public void checkout(double amount){
//         paymentGateway.initiatePayment(amount);
//     }
// }

// interface PaymentGateway{
//     void initiatePayment(double amount);
// }
// class RazorPay implements PaymentGateway{
//     public void initiatePayment(double amount){
//         System.out.println("Payment processed by RazorPay with amount : "+amount);
//     }
// }
// class StripePay implements PaymentGateway{
//     public void initiatePayment(double amount){
//         System.out.println("Payment processed by StripePay with amount : "+amount);
//     }
// }
// public class Interfaces{
//     public static void main(String[] args) {
//         PaymentGateway stripeGateway = new StripePay();
//         CheckoutService service = new CheckoutService(stripeGateway);
//         service.checkout(15649.26);

//         PaymentGateway razorGateway = new RazorPay();
//         service.setPaymentMethod(razorGateway);
//         service.checkout(400.25);
//     }
// }
//----------------------------------------------------------------------------------------------------------------------------------------

interface PaymentGateway{
    public void initiatePayment(double amount);
}

class StripePayment implements PaymentGateway{
    public void initiatePayment(double amount){
        System.out.println("Payment made through Stripe with amount $"+amount);
    }
}

class RazorpayPayment implements PaymentGateway{
    public void initiatePayment(double amount){
        System.out.println("Payment made through Razorpay with amount $"+amount);
    }
}
class CheckoutService{
    private PaymentGateway gateway;
    public CheckoutService(PaymentGateway gateway){
        this.gateway = gateway;
    }
    public void setPaymentGateway(PaymentGateway gateway){
        this.gateway = gateway;
    }
    public void checkout(double amount){
        gateway.initiatePayment(amount);
    }
}
public class Interfaces{
    public static void main(String[] args) {
        PaymentGateway gateway1 = new StripePayment();
        CheckoutService service = new CheckoutService(gateway1);
        service.checkout(1500);

        PaymentGateway gateway2 = new RazorpayPayment();
        service.setPaymentGateway(gateway2);
        service.checkout(18);
    }
}