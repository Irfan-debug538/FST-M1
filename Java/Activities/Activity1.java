
public class Activity1 {
    public static void main(String[] args) {
        // Creating an object of the Car class
        Car myCar = new Car();
        
        // Initializing the values
        myCar.make = 2014;
        myCar.color = "Black";
        myCar.transmission = "Manual";
        
        // Calling the methods to display the characteristics of the car
        myCar.displayCharacteristics();
        
        // Calling the accelerate and brake methods
        myCar.accelerate();
        myCar.brake();
    }
}
