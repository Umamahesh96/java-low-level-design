//BASED ON DIRECTION : uni-directional Association

// class PaymentGateway{
//     public void processPayment(double amount){
//         System.out.println("Payment successful with amount : "+amount);
//     }
// }
// class Order{
//     private PaymentGateway gateway;
//     public Order(PaymentGateway gateway){
//         this.gateway = gateway;
//     }
    
//     public void checkOut(){
//         gateway.processPayment(100);
//     }
// }

// public class Association{
//     public static void main(String[] args) {
//         Order o1 = new Order(new PaymentGateway());
//         o1.checkOut();
//     }
// }

//BASED ON DIRECTION : bi-directional Association

import java.util.ArrayList;
import java.util.List;

class Developer{
    //Developer class is holding the reference of Team class
    private Team team;
    public void setTeam(Team team){
        this.team = team;
    }
}
class Team{
    //Team class holding the reference of Developer class
    private List<Developer> developers = new ArrayList<>();
    
    public void addDeveloper(Developer dev){
        developers.add(dev);
        dev.setTeam(this);
    }
}
public class Association{
    public static void main(String[] args) {
        
    }
}
