package vehicle;

/**
 *
 * @author Aristotelis
 */
public class Vehicle {
    private String make;
    private String model;
    private int year;
    private double weight;
    private boolean needsMaintenance;
    private int tripsSinceMaintenance;

    public Vehicle(String make, String model, int year, double weight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.weight = weight;
        this.needsMaintenance = false;
        this.tripsSinceMaintenance = 0;
    }

    // Getters and Setters for make, model, year, and weight
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getters and Setters for needsMaintenance and tripsSinceMaintenance
    public boolean isNeedsMaintenance() {
        return needsMaintenance;
    }

    public void setNeedsMaintenance(boolean needsMaintenance) {
        this.needsMaintenance = needsMaintenance;
    }

    public int getTripsSinceMaintenance() {
        return tripsSinceMaintenance;
    }

    public void setTripsSinceMaintenance(int tripsSinceMaintenance) {
        this.tripsSinceMaintenance = tripsSinceMaintenance;
    }

    // Method to increment tripsSinceMaintenance
    public void incrementTripsSinceMaintenance() {
        tripsSinceMaintenance++;
    }

    // Method to repair the vehicle
    public void repair() {
        tripsSinceMaintenance = 0;
        needsMaintenance = false;
    }
    
    // Override toString() method
    @Override
    public String toString() {
        return "Make: " + make +
                "\nModel: " + model +
                "\nYear: " + year +
                "\nWeight: " + weight +
                "\nNeeds Maintenance: " + needsMaintenance +
                "\nTrips Since Maintenance: " + tripsSinceMaintenance;
    }
}
