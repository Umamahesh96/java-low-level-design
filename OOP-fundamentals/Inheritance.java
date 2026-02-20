class Vehicle{
    protected String make;
    protected String model;
    protected int year;
    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public void startEngine(){
        System.out.println("Engine Started");
    }
    public void stopEngine(){
        System.out.println("Engine stopped");
    }   
    public void displayInfo(){
        System.out.println(year+" "+make+" "+model);
    }
}
class ElectricCar extends Vehicle{
    private int batteryCapacity;
    public ElectricCar(String make, String model, int year, int batteryCapacity){
        super(make, model, year);
        this.batteryCapacity = batteryCapacity;
    }
    public void chargeBattery(){
        System.out.println("Charging "+batteryCapacity+"kWh battery");
    }
    public void startEngine(){

    }
}
class GasCar extends Vehicle{
    private double fuelTankSize;
    public GasCar(String make, String model, int year, double fuelTankSize){
        super(make, model, year);
        this.fuelTankSize = fuelTankSize;
    }
    public void fillTank(){
        System.out.println("Filling "+fuelTankSize+"L fuel tank");
    }
    public void startEngine(){

    }
}
public class Inheritance{
    public static void main(String[] args) {
        ElectricCar v1 = new ElectricCar("Tesla", "T150", 2026, 10);
        v1.chargeBattery();
    }
}




