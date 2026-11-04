public class Car {

    /**
     *
     *  Attributes (data)
     *
     */
    String make;
    String model;
    String color;
    int year;
    int maxSpeed;
    int currentSpeed;

    /**
     *
     *  Methods (funktioner)
     *
     */
    Car(String make, String model, String color, int year, int maxSpeed) {
        System.out.printf("%s %s %s %d %d\n", make, model, color, year, maxSpeed);

        this.make = make;   // Save parameter value inte class variable
        this.model = model;
        this.color = color;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    int accelerate(int changeInSpeed) {
        currentSpeed =  currentSpeed + changeInSpeed;
        if(currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
        return currentSpeed;
    }

    int brake(int changeInSpeed) {
        currentSpeed =  currentSpeed - changeInSpeed;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        return currentSpeed;
    }

    void honk() {
        System.out.println("TOOOT TOOT!");
    }


}
