
class Car{
    private String brand;
    private String model;
    private int speed;
    public Car(String brand, String model, int speed){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }
    public void accelerate(int increment){
        speed += increment;
    }
    public void displayStatus(){
        System.out.println(brand+" is running at "+speed+"kmph.");
    }
}


public class ClassesAndObjects {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 80);
        Car c2 = new Car("Ford", "Mustang", 120);

        c2.accelerate(15);
        c2.displayStatus();
    }
}


