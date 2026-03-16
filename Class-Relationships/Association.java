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
// import java.util.*;
// class Developer{
//     private Team team;
//     public void setTeam(Team team){
//         this.team = team;
//     }
// }
// class Team{
//     private List<Developer> developers = new ArrayList<>();
//     public void addDeveloper(Developer dev){
//         developers.add(dev);
//         dev.setTeam(this);
//     }
// }
// public class Association{
//     public static void main(String[] args) {
//         Developer mahesh = new Developer();
        
//         Team JFS = new Team();
//         JFS.addDeveloper(mahesh);

//     }
// }
//---------------------------------------------------------------------------------

//Based on Direction - uni directional Association
// class PaymentGateway{
//     public void processPayment(double amount){
//         System.out.println("Payment processed with $"+amount);
//     }
// }
// class Order{
//     private PaymentGateway gateway; 
//     public Order(PaymentGateway gateway){
//         this.gateway = gateway;
//     }
//     public void checkout(){
//         gateway.processPayment(456.32);
//     }
// }

//Based on Direction - bi-directional Association
// import java.util.*;
// class Developer{
//     private Team team;
//     public void setTeam(Team team){
//         this.team = team;
//     }
// }
// class Team{
//     private List<Developer> developers;
//     public void addDeveloper(Developer dev){
//         developers.add(dev);
//         dev.setTeam(this);
//     }
// }
// public class Association{
//     public static void main(String[] args) {
//         Developer dev1 = new Developer();
//         Developer dev2 = new Developer();
        
//         Team JFS = new Team();
//         JFS.addDeveloper(dev1);
//     }
// }
//---------------------------------------------------------------------------------

//Based on Multiplicity : one-to-one Association
// class Profile{
//     private User user;
//     public void setUser(User user){
//         this.user = user;
//     }
// }
// class User{
//     private Profile profile;
//     public void setProfile(Profile profile){
//         this.profile = profile;
//         profile.setUser(this);
//     }
// }
// public class Association{
//     public static void main(String[] args) {
//         User mahesh = new User();
//         User hanuma = new User();

//         mahesh.setProfile(new Profile());
//     }
// }
//---------------------------------------------------------------------------------

//Baced on Multiplicity : One-to-Many association
// class Issue{
//     private Project project;
//     public void setProject(Project project){
//         this.project = project;
//     }
// }
// class Project{
//     private Issue issue;
//     public void addIssue(Issue issue){
//         this.issue = issue;
//         issue.setProject(this);
//     }
// }
//---------------------------------------------------------------------------------

//Based on Multiplicity: Mant-to-Many association
import java.util.*;
class User{
    private String name;
    private List<Group> groups = new ArrayList<>();
    public User(String name){
        this.name = name;
    }
    public void joinGroup(Group group){
        if(!groups.contains(group)){
            groups.add(group);
            group.addUser(this);
        }
    }
    public String getName(){
        return name;
    }
    public List<Group> getGroups(){
        return groups;
    }
    @Override
    public String toString(){
        return name;
    }
}
class Group{
    private String name;
    private List<User> users = new ArrayList<>();
    public Group(String name){
        this.name = name;
    }
    public void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
            user.joinGroup(this);
        }
    }
    public String getName(){
        return name;
    }
    public List<User> getUsers(){
        return users;
    }
}
public class Association{
    public static void main(String[] args) {
        User mahesh = new User("mahesh");
        User yashwin = new User("Yashwin");

        Group malaysia = new Group("Malaysia");
        Group goodFellows = new Group("Good Fellows");
        
        mahesh.joinGroup(malaysia);
        yashwin.joinGroup(malaysia);

        yashwin.joinGroup(goodFellows);

        System.out.println("Users in Good Fellows group: "+goodFellows.getUsers());
        System.out.println("Users in malaysia group: "+malaysia.getUsers());
    }
}