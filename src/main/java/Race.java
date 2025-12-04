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
            System.out.println("Введите название машины №" + (carCounter + 1) + ":");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Название машины не должно быть пустым!");
            } else {
                break;
            }
        }
        return name;
    }

    private int readSpeed() {
        int speed;
        while (true) {
            System.out.println("Введите скорость машины №" + (carCounter + 1) + ":");
            String input = scanner.nextLine();
            try {
                speed = Integer.parseInt(input);
                if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
                    break;
                } else {
                    System.out.println("Скорость машины должна быть в диапазоне от: " +
                    MIN_SPEED + " до: " + MAX_SPEED + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Скорость машины должна быть целым числом!");
            }
        }
        return speed;
    }

    private void updateLeader(Car car) {
        if (car == null) {
            return;
        }
        int distance = car.getSpeed() * RACE_TIME;
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.getName();
        }
    }

    private void printWinner() {
        System.out.println("Самая быстрая машина: " + leaderName);
    }
}
