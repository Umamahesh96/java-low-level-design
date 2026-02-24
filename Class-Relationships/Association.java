//Based on Direction : uni-directional Association

// class PaymentGateway{
//     public void processPayment(double amount){
//         System.out.println("Payment done with amount : "+amount);
//     }
// }

// class Order{
//     private PaymentGateway gateway;
//     public Order(PaymentGateway gateway){
//         this.gateway = gateway;
//     }
//     public void checkout(){
//         gateway.processPayment(200);
//     }
// }

// public class Association{
//     public static void main(String[] args) {
//         Order o1 = new Order(new PaymentGateway());
//         o1.checkout();
//     }
// }

//Based on direction : bi-directional Association
import java.util.*;
class Developer{
    private Team team;
    public void setTeam(Team team){
        this.team = team;
    }
}
class Team{
    private List<Developer> developers = new ArrayList<>();
    public void addDeveloper(Developer dev){
        developers.add(dev);
        dev.setTeam(this);
    }
}
public class Association{
    public static void main(String[] args) {
        Developer mahesh = new Developer();
        
        Team JFS = new Team();
        JFS.addDeveloper(mahesh);

    }
}