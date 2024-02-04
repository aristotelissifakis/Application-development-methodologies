package vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Honda", "Accord", 2022, 1500.0, 200);
        Plane plane1 = new Plane("Boeing", "747", 2023, 200000.0, 68.5f);
        Plane plane2 = new Plane("Airbus", "A380", 2021, 180000.0, 79.75f);
        Plane plane3 = new Plane("Cessna", "172", 2020, 1200.0, 36.5f);

        car.drive();
        car.stop();

        plane1.fly();
        plane1.land();

        plane2.fly();
        plane2.fly();
        plane2.land();

        plane3.fly();
        plane3.fly();
        plane3.fly();
        plane3.land();

        System.out.println("Car:");
        System.out.println(car.toString());

        System.out.println("\nPlane 1:");
        System.out.println(plane1.toString());

        System.out.println("\nPlane 2:");
        System.out.println(plane2.toString());

        System.out.println("\nPlane 3:");
        System.out.println(plane3.toString());
    }
}


