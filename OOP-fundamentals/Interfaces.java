

class CheckoutService{
    private PaymentGateway paymentGateway;
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public void setPaymentGateway(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public void checkOut(double amount){
        paymentGateway.initiatePayment(amount);
    }
}

interface PaymentGateway{
    public void initiatePayment(double amount);
}
class StripePay implements PaymentGateway{
    @Override
    public void initiatePayment(double amount){
        System.out.println("Processing payment via Stripe : $"+amount);
    }
}
class RazorPay implements PaymentGateway{
    @Override
    public void initiatePayment(double amount){
        System.out.println("Processing payment via Razor : Rs."+amount);
    }
}
class PayPal implements PaymentGateway{
    @Override
    public void initiatePayment(double amount){
        System.out.println("Processing payment via PayPal : "+amount);
    }
}
public class Interfaces{
    public static void main(String[] args) {
        PaymentGateway stripePay = new StripePay();
        CheckoutService service = new CheckoutService(stripePay);
        service.checkOut(120.50);

        PaymentGateway razorPay = new RazorPay();
        service.setPaymentGateway(razorPay);
        service.checkOut(150.50);
    }
}