
import java.util.*;

interface Flyable{
    void fly();
    String getFlightInfo();
}
class Bird implements Flyable{
    private String species;
    private double wingSpan;
    public Bird(String species, double wingSpan){
        this.species = species;
        this.wingSpan = wingSpan;
    }
    public void fly(){
        System.out.println(species+" flaps its wings and take off.");
    }
    public String getFlightInfo(){
        return species + " (wingspan: "+wingSpan+"m, get powered by muscle)";
    }
}
class Airplane implements Flyable{
    private String model;
    private int maxAltitude;
    public Airplane(String model, int maxAltitude){
        this.model = model;
        this.maxAltitude = maxAltitude;
    }
    public void fly(){
        System.out.println(model+" engines roar as it accelerates down the runway");
    }
    public String getFlightInfo(){
        return model + " (max Altitude : "+maxAltitude+" powered by jet engines";
    }
}


public class Realization {
    public static void main(String[] args) {
        List<Flyable> flyingThings = new ArrayList<>();
        flyingThings.add(new Bird("Eagle", 2.3));
        flyingThings.add(new Airplane("Boeing 737", 41000));
        for(Flyable things : flyingThings){
            System.out.println(things.getFlightInfo());
            things.fly();
            System.out.println();
        }
    }
}
