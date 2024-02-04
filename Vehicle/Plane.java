
package vehicle;

/**
 *
 * @author Aristotelis
 */

public class Plane extends Vehicle {
    private boolean isFlying;
    private float wingspan;

    public Plane(String make, String model, int year, double weight, float wingspan) {
        super(make, model, year, weight);
        this.isFlying = false;
        this.wingspan = wingspan;
    }

    // Getters and Setters for isFlying and wingspan
      // Getter for isFlying
    public boolean isFlying() {
        return isFlying;
    }

    // Setter for isFlying
    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    // Getter for wingspan
    public float getWingspan() {
        return wingspan;
    }

    // Setter for wingspan
    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }
    

    // Method to start flying
    public void fly() {
        if (isFlying) {
            System.out.println("The plane is already flying.");
        } else if (isNeedsMaintenance()) {
            System.out.println("Maintenance is required. Cannot start a new flight.");
        } else {
            isFlying = true;
        }
    }

    // Method to land the plane
    public void land() {
        if (isFlying) {
            isFlying = false;
            incrementTripsSinceMaintenance();
            if (getTripsSinceMaintenance() > 80) {
                setNeedsMaintenance(true);
            }
        } else {
            System.out.println("The plane is not currently flying.");
        }
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() +
                "\nWingspan: " + wingspan +
                "\nIs Flying: " + isFlying;
    }
}
