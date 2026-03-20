
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


public class Realization {
    
}
