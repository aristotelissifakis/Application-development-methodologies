package vehicle;

/**
 *
 * @author Aristotelis
 */
public class Car extends Vehicle {
    private boolean isDriving;
    private int horsepower;

    public Car(String make, String model, int year, double weight, int horsepower) {
        super(make, model, year, weight);
        this.isDriving = false;
        this.horsepower = horsepower;
    }

    // Getters and Setters for isDriving and horsepower
    public boolean isDriving() {
        return isDriving;
    }

    public void setDriving(boolean isDriving) {
        this.isDriving = isDriving;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    // Method to start driving
    public void drive() {
        isDriving = true;
    }

    // Method to stop driving
    public void stop() {
        isDriving = false;
        incrementTripsSinceMaintenance();
        if (getTripsSinceMaintenance() > 100) {
            setNeedsMaintenance(true);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nHorsepower: " + horsepower;
    }
}
