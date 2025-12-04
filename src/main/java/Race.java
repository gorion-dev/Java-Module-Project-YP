import java.util.Scanner;

public class Race {
    public static final int RACE_TIME = 24;
    public static final int CARS_IN_RACE = 3;
    public static final int MIN_SPEED = 0;
    public static final int MAX_SPEED = 250;
    private int leaderDistance = 0;
    private int carCounter = 0;
    private String leaderName = "";
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (carCounter < CARS_IN_RACE) {
            Car car = createCar();
            updateLeader(car);
        }
        printWinner();
    }

    private Car createCar() {
        String name = readName();
        int speed = readSpeed();
        carCounter++;
        return new Car(name, speed);
    }

    private String readName() {
        String name;
        while (true) {
            System.out.println("Enter the name of the car №" + (carCounter + 1) + ":");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("The car name must not be empty!");
            } else {
                break;
            }
        }
        return name;
    }

    private int readSpeed() {
        int speed;
        while (true) {
            System.out.println("Enter the speed of the car №" + (carCounter + 1) + ":");
            String input = scanner.nextLine();
            try {
                speed = Integer.parseInt(input);
                if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
                    break;
                } else {
                    System.out.println("The speed of the car should be in the range from: " +
                    MIN_SPEED + " to: " + MAX_SPEED + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("The speed of the car must be an integer!");
            }
        }
        return speed;
    }

    private void updateLeader(Car car) {
        if (car == null) {
            return;
        }
        int distance = car.speed * RACE_TIME;
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.name;
        }
    }

    private void printWinner() {
        System.out.println("The fastest car is: " + leaderName);
    }
}
